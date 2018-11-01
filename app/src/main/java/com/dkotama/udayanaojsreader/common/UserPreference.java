package com.dkotama.udayanaojsreader.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by dkotama on 19/09/18.
 */

public class UserPreference {
    final public static String USER_ID = "user_id";
    final public static String USERNAME = "username";


    private int userId = 0;
    private String username = "";
    private String TAG = "UserPreference";

    protected SharedPreferences preferences;
    protected SharedPreferences.Editor editor;
    protected Context context;

    public UserPreference() {
        this.context = Core.getAppContext();

        preferences = context.getSharedPreferences(Constant.PREFERENCE_FILENAME, Context.MODE_PRIVATE);
        editor = preferences.edit();

        loadData();
    }

    private void loadData() {
       userId = preferences.getInt(USER_ID, 0);
       username = preferences.getString(USERNAME, "");
        Log.d("UserPreference", "loadData: " + userId + ", " + username);
    }


    public void write(String preferenceName, String value) {
        Log.d(TAG, "writing key: " + preferenceName + ", value " + value);
        editor.putString(preferenceName, value);
        editor.commit();
    }

    public void write(String preferenceName, boolean value) {
        editor.putBoolean(preferenceName, value);
    }

    public void write(String preferenceName, int value) {
        Log.d(TAG, "writing key: " + preferenceName + ", value " + value);
        editor.putInt(preferenceName, value);
        editor.commit();
    }

    public void write(String preferenceName, float value) {
        editor.putFloat(preferenceName, value);
    }

    public void write(String preferenceName, Long value) {
        editor.putLong(preferenceName, value);
    }

    public void clearPreference() {
        editor.clear();
        editor.commit();
    }

    public void removeKey(String key) {
        editor.remove(key);
        editor.commit();
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
