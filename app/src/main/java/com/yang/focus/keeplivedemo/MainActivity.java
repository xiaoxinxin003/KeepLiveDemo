package com.yang.focus.keeplivedemo;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yang.focus.keeplivedemo.event.ScreenActionEvent;
import com.yang.focus.keeplivedemo.utils.RxBus;

import java.util.List;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        initScreenLockEvent();
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
        if (KeepLiveActivity.instance != null) {
            KeepLiveActivity.instance.finish();
        }
//        ActivityManager manager=(ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);
//        List<ActivityManager.RunningTaskInfo> info=manager.getRunningTasks(1);
//        String classname = null;
//        if (null != info && !(info.isEmpty())) {
//            classname = info.get(0).topActivity.getClassName();
//            if (classname.equals("com.yang.focus.keeplivedemo.KeepLiveActivity")) {
//                KeepLiveActivity.instance.finish();
//            }
//        }
    }

    private void startKeepLiveActivity() {
        Intent intent = new Intent(MainActivity.this, KeepLiveActivity.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
