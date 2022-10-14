package com.ciberciti.subscraze.boilerplate.ui.base;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */

public abstract class BaseFragment extends Fragment {


    private BaseActivity mActivity;
    private View mRootView;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
//        performDependencyInjection(getBuildComponent());
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    public boolean isNetworkConnected() {
        return mActivity != null && mActivity.isNetworkConnected();
    }


//    public abstract void performDependencyInjection(FragmentComponent buildComponent);


//    private FragmentComponent getBuildComponent() {
//        return DaggerFragmentComponent.builder()
//                .appComponent(((MvvmApp)(getContext().getApplicationContext())).appComponent)
//                .fragmentModule(new FragmentModule(this))
//                .build();
//    }

    public void showToastMessage(String text) {
        if (mActivity != null)
            mActivity.showToast(text);
    }

    public void showToastMessage(int textRes) {
        if(mActivity!=null)
          mActivity.showToast(textRes);
    }

    public void showProgress() {
        if(mActivity!=null){
            mActivity.showProgress();
        }
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
