package com.example.teacher.db050601;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
    Handler handler = new Handler();
    int i;

    public MyService() {
        i = 0;

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Runnable showTime = new Runnable() {
        @Override
        public void run() {
            Log.d("SER", "Time:" + new java.util.Date());
            i++;
            if (i <= 30) {
                handler.postDelayed(this, 1000);
            } else {


            }

        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.post(showTime);
        return super.onStartCommand(intent, flags, startId);
    }
}
