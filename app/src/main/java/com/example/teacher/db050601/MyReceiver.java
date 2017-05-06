package com.example.teacher.db050601;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            Log.d("REC1", "onReceive!!");
            Intent it = new Intent(context, MyService.class);
            context.startService(it);
        }

        if (intent.getAction().equals("DB0506REC"))
        {
            Log.d("REC1", "onReceive!! click!!");
            NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            Notification.Builder builder = new Notification.Builder(context.getApplicationContext());
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("收到廣播")
                    .setContentText("收到廣播");
            Notification notification = builder.build();
            manager.notify(3122, notification);
        }
    }
}
