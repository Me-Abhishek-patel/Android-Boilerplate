package com.ciberciti.subscraze.boilerplate.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.ciberciti.subscraze.boilerplate.utils.other.AppConstants.IS_USER_LOGGED_IN;
import static com.ciberciti.subscraze.boilerplate.utils.other.AppConstants.USER_ID;

/**
 * Created by Abhishek Patel on 13-10-2022.
 */
public class PreferenceProvider {
    Context context;
    SharedPreferences sharedPreferences;

    public PreferenceProvider(Context context) {
        this.context = context.getApplicationContext();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void addSession(int uid) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(USER_ID, uid);
        editor.putBoolean(IS_USER_LOGGED_IN, true);
        editor.apply();
    }

    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false);
    }

    public void removeSession() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(USER_ID);
        editor.putBoolean(IS_USER_LOGGED_IN, false);
        editor.apply();
    }

    public int getCurrentUserId() {
        return sharedPreferences.getInt(USER_ID, 0);
    }

}
