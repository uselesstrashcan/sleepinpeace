package com.rizz.killmusicin40;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Calendar;


public class saurabhgupta extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the timer to start at 3pm and repeat every 5 seconds
        long startTime = getStartTime();
        long interval = 5 * 1000; // 5 seconds in milliseconds

        // Create an Intent to close YouTube or YouTube Music
        Intent intent = new Intent(this, SecondJavaClass.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_CANCEL_CURRENT);


        // Get the AlarmManager service
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Set the alarm
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            @RequiresApi(api = Build.VERSION_CODES.M)
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, startTime, interval, pendingIntent);
        } else {
            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, startTime, interval, pendingIntent);
        }
    }

    private long getStartTime() {
        // Get the current time
        long currentTime = System.currentTimeMillis();

        // Set the start time to 3pm
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long startTime = calendar.getTimeInMillis();

// If the start time is in the past, add a day to it
        if (startTime < currentTime) {
            startTime += AlarmManager.INTERVAL_DAY;
        }

        return startTime;



    }
