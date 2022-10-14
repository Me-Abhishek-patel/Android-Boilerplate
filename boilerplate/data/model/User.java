package com.ciberciti.subscraze.boilerplate.data.model;

import android.net.Uri;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Abhishek Patel on 13-10-2022.
 */
public class User {
    String uid;
    String displayName;
    String phoneNumber;
    String email;
    Uri photoUrl;

    public User() {
    }

    public User(String uid) {
        this.uid = uid;
    }

    public User(String uid, String displayName, String email) {
        this.uid = uid;
        this.displayName = displayName;
        this.email = email;
    }

    public User(String uid, String displayName, String phoneNumber, String email, Uri photoUrl) {
        this.uid = uid;
        this.displayName = displayName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.photoUrl = photoUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Uri getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(Uri photoUrl) {
        this.photoUrl = photoUrl;
    }
}
