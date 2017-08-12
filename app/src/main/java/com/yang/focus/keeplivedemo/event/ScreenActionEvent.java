package com.yang.focus.keeplivedemo.event;

/**
 * Created by focus on 2017/8/12.
 */

public class ScreenActionEvent {
    public boolean isScreenLock() {
        return isScreenLock;
    }

    public void setScreenLock(boolean screenLock) {
        isScreenLock = screenLock;
    }

    private boolean isScreenLock;
    public ScreenActionEvent(boolean screenlock) {
        this.isScreenLock = screenlock;
    }
}
