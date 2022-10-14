package com.ciberciti.subscraze.boilerplate.ui.auth;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.ciberciti.subscraze.R;
import com.ciberciti.subscraze.boilerplate.ui.base.BaseFragment;
import com.ciberciti.subscraze.databinding.FragmentLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends BaseFragment {

    FragmentLoginBinding binding;
    LoginFragmentClickHandlers loginFragmentClickHandlers;
    private AuthViewModel authViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        binding = DataBindingUtil.bind(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        authViewModel = new ViewModelProvider(getActivity()).get(AuthViewModel.class);
        loginFragmentClickHandlers = new LoginFragmentClickHandlers(getActivity());
        binding.setLoginClickHandler(loginFragmentClickHandlers);
        binding.setAuthViewModel(authViewModel);

    }

    private void loginUser() {

    }

    public class LoginFragmentClickHandlers {
        Context context;

        public LoginFragmentClickHandlers(Context context) {
            this.context = context;
        }

        public void onLoginClicked(View view) {
            loginUser();
        }
    }


}