package com.ciberciti.subscraze.boilerplate.ui.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ciberciti.subscraze.R;
import com.ciberciti.subscraze.boilerplate.ui.base.BaseActivity;
import com.ciberciti.subscraze.databinding.ActivityAuthBinding;

public class AuthActivity extends BaseActivity {
    final int LOGIN_FRAGMENT_ID = 1;
    final int REGISTER_FRAGMENT_ID = 2;
    LoginFragment loginFragment;
    RegisterFragment registerFragment;
    FragmentTransaction transaction;
    //    TextView tvSwitchFragment;
    AuthViewModel authViewModel;
    FragmentManager manager;
    ActivityAuthBinding binding;
    AuthActivityClickHandler authActivityClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        authActivityClickHandler = new AuthActivityClickHandler(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        binding.setAuthViewModel(authViewModel);
        binding.setClickHandler(authActivityClickHandler);
        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();


        manager = getSupportFragmentManager();

        if (authViewModel.activeFragmentId != LOGIN_FRAGMENT_ID && authViewModel.activeFragmentId != REGISTER_FRAGMENT_ID) {
            transaction = manager.beginTransaction();
            authViewModel.activeFragmentId = 1;
            //TODO: extract String resource getResources().getString( R.string.register_now)
            authViewModel.setSwitcherText("Register Now");
            transaction.add(R.id.fragment_container_view, loginFragment, "REGISTER_FRAGMENT");
            transaction.commit();
        }
        authViewModel.getSwitcherText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvRegister.setText(s);
            }
        });

    }

    public class AuthActivityClickHandler {
        Context context;

        public AuthActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onSwitcherClicked(View view) {
            switch (authViewModel.activeFragmentId) {
                case LOGIN_FRAGMENT_ID:
                    manager.beginTransaction().replace(R.id.fragment_container_view, registerFragment).commit();
                    //TODO: extract String resource getResources().getString( R.string.log_in)
                    authViewModel.setSwitcherText("LOG IN");
                    authViewModel.activeFragmentId = REGISTER_FRAGMENT_ID;
                    break;
                case REGISTER_FRAGMENT_ID:
                    manager.beginTransaction().replace(R.id.fragment_container_view, loginFragment).commit();
                    authViewModel.activeFragmentId = LOGIN_FRAGMENT_ID;
                    //TODO: extract String resource getResources().getString( R.string.register_now)
                    authViewModel.setSwitcherText("Register Now");
                    break;


            }
        }
    }
}