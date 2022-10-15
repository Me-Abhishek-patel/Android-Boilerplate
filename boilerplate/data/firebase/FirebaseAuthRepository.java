package com.ciberciti.subscraze.boilerplate.data.firebase;

import android.app.Application;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import com.ciberciti.subscraze.boilerplate.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class FirebaseAuthRepository {
    private Application application;

    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;

    public FirebaseAuthRepository(Application application) {
        this.application = application;
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.userLiveData = new MutableLiveData<>();
        this.loggedOutLiveData = new MutableLiveData<>();

        if (firebaseAuth.getCurrentUser() != null) {
            userLiveData.postValue(firebaseAuth.getCurrentUser());
            loggedOutLiveData.postValue(false);
        }
    }

    public MutableLiveData<Boolean> register(String displayName, String email, String password) {
        MutableLiveData<Boolean> loginLiveData = new MutableLiveData<>();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(ContextCompat.getMainExecutor(application), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                            updateDisplayName(displayName);
                            loginLiveData.postValue(true);
                            saveUserData(new User(firebaseAuth.getUid(), firebaseAuth.getCurrentUser().getDisplayName(), getCurrentUser().getEmail()));
                            loggedOutLiveData.postValue(false);
                        } else {
                            loginLiveData.postValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return loginLiveData;
    }

    //TODO: Implement saveUserData
    public void saveUserData(User user) {

    }

    public MutableLiveData<Boolean> login(String email, String password) {
        MutableLiveData<Boolean> loginLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(ContextCompat.getMainExecutor(application), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            userLiveData.postValue(task.getResult().getUser());
                            loginLiveData.postValue(true);
                            loggedOutLiveData.postValue(false);
                        } else {
                            loginLiveData.postValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return loginLiveData;
    }

    public void logOut() {
        firebaseAuth.signOut();
        Toast.makeText(application, "Logged Out:" + (firebaseAuth.getCurrentUser() == null), Toast.LENGTH_SHORT).show();
        userLiveData.postValue(firebaseAuth.getCurrentUser());
        loggedOutLiveData.postValue(true);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }

    public FirebaseUser getCurrentUser() {
        return firebaseAuth.getCurrentUser();
    }

    public MutableLiveData<Boolean> updateDisplayName(String newDisplayName) {
        MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(newDisplayName)
                .build();

        firebaseAuth.getCurrentUser().updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            isSuccessful.setValue(true);
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            isSuccessful.setValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });
        return isSuccessful;
    }

    public MutableLiveData<Boolean> updateEmail(String newEmail) {
        MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();
        firebaseAuth.getCurrentUser().updateEmail(newEmail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            isSuccessful.setValue(true);
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            isSuccessful.setValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return isSuccessful;
    }

    public MutableLiveData<Boolean> sendVerificationEmail() {
        MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();
        firebaseAuth.getCurrentUser().sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            isSuccessful.setValue(true);
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            isSuccessful.setValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return isSuccessful;
        
    }

    public MutableLiveData<Boolean> sendPasswordResetEmail(String email) {
        MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            isSuccessful.setValue(true);
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            isSuccessful.setValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return isSuccessful;
    }

    public MutableLiveData<Boolean> updatePassword(String newPassword) {
        MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();
        firebaseAuth.getCurrentUser().updatePassword(newPassword)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            isSuccessful.setValue(true);
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            isSuccessful.setValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return isSuccessful;
    }

    public MutableLiveData<Boolean> deleteAccount() {
        MutableLiveData<Boolean> isSuccessful = new MutableLiveData<>();
        firebaseAuth.getCurrentUser().delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            isSuccessful.setValue(true);
                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                        } else {
                            isSuccessful.setValue(false);
                            Toast.makeText(application.getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return isSuccessful;
    }


}
