package com.yang.focus.keeplivedemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yang.focus.keeplivedemo.event.ScreenActionEvent;
import com.yang.focus.keeplivedemo.utils.RxBus;

/**
 * Created by focus on 2017/8/12.
 */

public class KeepLiveReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            RxBus.getInstance().post(new ScreenActionEvent(true));
        }else if (action.equals(Intent.ACTION_SCREEN_ON)) {
            RxBus.getInstance().post(new ScreenActionEvent(false));
        }
    }
}
