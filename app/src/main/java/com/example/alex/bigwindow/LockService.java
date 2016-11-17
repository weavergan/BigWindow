package com.example.alex.bigwindow;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by alex on 6/22/16.
 */
public class LockService extends Service {

    LockReceiver receiver = null;
    Intent startIntent = null;

    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {

        startIntent = intent;

        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_SCREEN_ON);

        filter.addAction(Intent.ACTION_SCREEN_OFF);

        receiver = new LockReceiver();

        registerReceiver(receiver, filter);

        System.out.println("service onStart and action is " + intent.getAction());

        System.out.println("service onStart and startId is " + startId);
        return super.onStartCommand(intent, flags, startId);

    }

    @Override

    public void onDestroy() {

        // TODO Auto-generated method stub

        System.out.println("service onDestroy");

        unregisterReceiver(receiver);

        if (startIntent != null) {

            System.out.println("serviceIntent not null");

            startService(startIntent);

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
