package com.elasdka2.myapp.BroadCastReceiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

import com.elasdka2.myapp.Login;
import com.elasdka2.myapp.R;

import java.util.Random;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


       /* Intent service = new Intent(context, NotificationAlarmService.class);
        service.putExtra("notifId", intent.getIntExtra("notifId", 0));
        context.startService(service);
*/
        context.startService(new Intent(context,NotificationAlarmService.class));

    }
}
