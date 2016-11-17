package com.example.alex.bigwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by alex on 6/22/16.
 */
public class LockReceiver extends BroadcastReceiver {

    @Override

    public void onReceive(Context context, Intent intent) {

        // TODO Auto-generated method stub

        String action=intent.getAction();

        System.out.println("action is "+action);

        Intent lockIntent=new Intent(context,MainActivity.class);

        lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(lockIntent);

    }


}
