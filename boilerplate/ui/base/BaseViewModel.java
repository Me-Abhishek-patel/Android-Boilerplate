
package com.ciberciti.subscraze.boilerplate.ui.base;

import android.app.Application;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

public abstract class BaseViewModel extends AndroidViewModel {
    /**
     * Created by Abhishek Patel on 12-10-2022.
     */



    private final ObservableBoolean mIsLoading = new ObservableBoolean();



    public BaseViewModel(Application application) {
        super(application);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }


    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

}
