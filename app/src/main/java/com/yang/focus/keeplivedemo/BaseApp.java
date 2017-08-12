package com.yang.focus.keeplivedemo;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;

import com.yang.focus.keeplivedemo.receiver.KeepLiveReceiver;

/**
 * Created by focus on 2017/8/12.
 */

public class BaseApp extends Application {

    private IntentFilter intentFilter;
    private KeepLiveReceiver keepLiveReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        registReceiver();
    }

    private void registReceiver() {
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);  //添加要收到的广播
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);  //添加要收到的广播
        keepLiveReceiver = new KeepLiveReceiver();                    //广播实例
        registerReceiver(keepLiveReceiver, intentFilter);
    }
}
