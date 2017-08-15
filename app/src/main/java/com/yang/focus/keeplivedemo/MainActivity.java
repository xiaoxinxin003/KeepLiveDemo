package com.yang.focus.keeplivedemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yang.focus.keeplivedemo.event.ScreenActionEvent;
import com.yang.focus.keeplivedemo.intf.CJMListener;
import com.yang.focus.keeplivedemo.mgr.AppManager;
import com.yang.focus.keeplivedemo.utils.RxBus;

import java.util.List;
import java.util.Stack;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity implements CJMListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        initScreenLockEvent();
        tv.setText(new MyNdk(this).getString());
        findViewById(R.id.display_button_activity_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyNdk(MainActivity.this).displaySomething();
            }
        });
    }

    private void initScreenLockEvent() {
        RxBus.getInstance().toObserverable(ScreenActionEvent.class)
                .subscribe(new Action1<ScreenActionEvent>() {
                    @Override
                    public void call(ScreenActionEvent screenActionEvent) {
                          if (screenActionEvent.isScreenLock()) {
                              startKeepLiveActivity();
                          }else if (!screenActionEvent.isScreenLock()) {
                              finishKeepLiveActivity();
                          }
                    }
                });
    }

    private void finishKeepLiveActivity() {
        AppManager.finishActivity(KeepLiveActivity.class);
    }

    private void startKeepLiveActivity() {
        Intent intent = new Intent(MainActivity.this, KeepLiveActivity.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
