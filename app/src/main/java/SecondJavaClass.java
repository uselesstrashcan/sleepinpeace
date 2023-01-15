import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.List;

public class SecondJavaClass extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Code to close YouTube or YouTube Music goes here
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processes = activityManager.getRunningAppProcesses();

        for (ActivityManager.RunningAppProcessInfo process : processes) {
            if (process.processName.equals("com.google.android.youtube") ||
                    process.processName.equals("com.google.android.apps.youtube.music") ||
                    process.processName.equals("com.spotify.music") ||
                    process.processName.equals("com.vanced.android.youtube") ||
                    process.processName.equals("com.vanced.android.apps.youtube.music")) {
                activityManager.killBackgroundProcesses(process.processName);
            }
        }
    }
}
