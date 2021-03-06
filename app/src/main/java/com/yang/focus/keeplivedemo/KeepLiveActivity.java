package com.yang.focus.keeplivedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.yang.focus.keeplivedemo.mgr.AppManager;

/**
 * Created by focus on 2017/8/12.
 */

public class KeepLiveActivity extends Activity {
    private static final String TAG = "KeepLiveActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.addActivity(this);
        Log.d(TAG, "KeepLiveActivity is created");

        Window window = getWindow();
        window.setGravity(Gravity.LEFT|Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 100;
        params.y = 100;
        params.height = 200;
        params.width = 200;
        window.setAttributes(params);
    }
}
