package com.example.kshrd.mynavigationdraswe.fcm;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.kshrd.mynavigationdraswe.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by kshrd on 6/26/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{
    private String TAG;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }
        String title;
        String body;

//        String title = remoteMessage.getNotification().getTitle();
//        String body = remoteMessage.getNotification().getBody();
        if(remoteMessage.getNotification()!=null){
            title = remoteMessage.getNotification().getTitle();
            body = remoteMessage.getNotification().getBody();
        }else {
            title = "Title is Null";
            body = "Body is Null";

        }


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int i = (int) (System.currentTimeMillis() / 1000);
        notificationManager.notify(i, builder.build());
    }
}
