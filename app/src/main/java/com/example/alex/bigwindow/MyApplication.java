package com.example.alex.bigwindow;

import android.app.Application;
import android.content.Intent;

/**
 * Created by alex on 6/22/16.
 */
public class MyApplication extends Application {
    private static boolean PermissionAllowed  = false;

    public static boolean isPermissionAllowed()
    {
        return  PermissionAllowed;
    }

    public static void setPermissionAllowed(boolean allowed)
    {
        PermissionAllowed = allowed;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Intent localIntent = new Intent(getApplicationContext(),
                LockService.class);
        startService(localIntent);
    }
}
