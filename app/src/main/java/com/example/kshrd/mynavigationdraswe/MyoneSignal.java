package com.example.kshrd.mynavigationdraswe;


import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

/**
 * Created by kshrd on 6/27/17.
 */

public class MyoneSignal extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        // Call syncHashedEmail anywhere in your app if you have the user's email.
        // This improves the effectiveness of OneSignal's "best-time" notification scheduling feature.
        // OneSignal.syncHashedEmail(userEmail);

    }
    class OneSignalOpenHandler implements OneSignal.NotificationOpenedHandler {

        @Override
        public void notificationOpened(OSNotificationOpenResult result) {

            JSONObject data = result.notification.payload.additionalData;


            String customKey;


            if (data != null) {
                customKey = data.optString("name", null);
                if (customKey != null)
                    Log.i("DARA_FB", "customkey set with value: " + customKey);
            }

            Intent intent = new Intent(getApplicationContext() , DetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }
}
