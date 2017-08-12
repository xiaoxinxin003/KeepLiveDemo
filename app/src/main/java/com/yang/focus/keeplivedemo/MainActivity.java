package com.yang.focus.keeplivedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private KeepLiveReceiver keepLiveReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);  //添加要收到的广播
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);  //添加要收到的广播
        keepLiveReceiver = new KeepLiveReceiver();                    //广播实例
        registerReceiver(keepLiveReceiver, intentFilter);
    }

    public class KeepLiveReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_SCREEN_OFF)) {
                startKeepLiveActivity();
            }else if (action.equals(Intent.ACTION_SCREEN_ON)) {

            }
        }
    }

    private void startKeepLiveActivity() {
        Intent intent = new Intent(MainActivity.this, KeepLiveActivity.class);
        startActivity(intent);
    }
}
