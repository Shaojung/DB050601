package com.example.teacher.db050601;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.nio.channels.AlreadyBoundException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Calendar calendar = Calendar.getInstance();
    PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        Intent it = new Intent();
        it.setAction("DB0506REC");
        sendBroadcast(it);
    }

    public void clickSetAlarm(View v)
    {
        Intent it = new Intent();
        it.setAction("DB0506Alarm");
        pi = PendingIntent.getBroadcast(MainActivity.this, 321, it, PendingIntent.FLAG_ONE_SHOT);

        // 跳出 TimePickerDialog 對話框來設定時間
        calendar.setTimeInMillis(System.currentTimeMillis());
        int hour   = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
            new MyOnTimeSetListener(), hour, minute, true);
        timePickerDialog.show();

    }
    // 設定 OnTimeSetListener 監聽器
    private class MyOnTimeSetListener implements
            TimePickerDialog.OnTimeSetListener
    {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendar.set(Calendar.MINUTE, minute);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        }
    }
}
