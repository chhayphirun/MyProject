package com.example.kshrd.mynavigationdraswe.onesignal;

import android.content.SharedPreferences;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by LIER on 7/1/2017.
 */

public class OneSignalNotificationExtender extends NotificationExtenderService {
    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
        JSONObject object=receivedResult.payload.additionalData;
        String title="";
        if(object!=null){
            try {
                title=object.getString("title");
                SharedPreferences preferences=getSharedPreferences("setting",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("title",title);
                editor.apply();
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }



        return false;
    }
}
