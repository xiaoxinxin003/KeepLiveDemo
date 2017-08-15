package com.yang.focus.keeplivedemo;

import android.os.Handler;

import com.yang.focus.keeplivedemo.intf.CJMListener;

/**
 * Created by focus on 2017/8/14.
 */

public class MyNdk implements CJMListener{

    private Handler handler;
    private CJMListener listener;

    public MyNdk(CJMListener listener) {
        this.handler = new Handler();
        this.listener = listener;
    }

    static {
        System.loadLibrary("MyLibrary");
    }
    public native String getString();

    public native void displaySomething();

    @Override
    public void displayMessage(final String message) {
        handler.post(new Runnable() {

            @Override
            public void run() {
                listener.displayMessage(message);
            }
        });
    }
}
