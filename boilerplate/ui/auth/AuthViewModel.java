package com.ciberciti.subscraze.boilerplate.ui.auth;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.ciberciti.subscraze.boilerplate.ui.base.BaseViewModel;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class AuthViewModel extends BaseViewModel {
    public Integer uid = null;
    public String displayName;
    public String userEmail;
    public String password;

    public MutableLiveData<String> switcherText = new MutableLiveData<>();
    int activeFragmentId = 0;


    public AuthViewModel(@NonNull Application application) {
        super(application);
        switcherText.setValue("");
    }

    public int getActiveFragmentId() {
        return activeFragmentId;
    }

    public void setActiveFragmentId(int activeFragmentId) {
        this.activeFragmentId = activeFragmentId;
    }


    public boolean isUserLoggedIn() {
        //TODO: implement this
        return false;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MutableLiveData<String> getSwitcherText() {
        return switcherText;
    }

    public void setSwitcherText(String text) {
        this.switcherText.setValue(text);
    }

    public LiveData<FirebaseUser> signup() {
        //TODO: implement this
        return null;
    }


}
