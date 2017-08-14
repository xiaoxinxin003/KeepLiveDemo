package com.yang.focus.keeplivedemo;

/**
 * Created by focus on 2017/8/14.
 */

public class MyNdk {
    static {
        System.loadLibrary("MyLibrary");
    }
    public native String getString();
}
