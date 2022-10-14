package com.ciberciti.subscraze.boilerplate.ui.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.ciberciti.subscraze.R;
import com.ciberciti.subscraze.databinding.FragmentRegisterBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    FragmentRegisterBinding binding;
    RegisterFragmentClickHandlers registerFragmentClickHandlers;
    private AuthViewModel authViewModel;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        binding = DataBindingUtil.bind(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        authViewModel = new ViewModelProvider(getActivity()).get(AuthViewModel.class);
        registerFragmentClickHandlers = new RegisterFragmentClickHandlers(getActivity());
        binding.setAuthViewModel(authViewModel);
        binding.setRegisterClickHandler(registerFragmentClickHandlers);


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void registerUser() {

    }

    private boolean isInputValid() {
       //TODO: Implement
        return true;
    }

    public class RegisterFragmentClickHandlers {
        Context context;

        public RegisterFragmentClickHandlers(Context context) {
            this.context = context;
        }

        public void onRegisterClicked(View view) {
            if (isInputValid())
                registerUser();
        }
    }

}