package com.example.androidtestssample.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidtestssample.R;
import com.example.androidtestssample.home.HomeActivity;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;
    private Button loginButton;
    private EditText userNameField;
    private EditText passwordField;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        loginButton = view.findViewById(R.id.login_validate_button);
        userNameField = view.findViewById(R.id.username_field);
        passwordField = view.findViewById(R.id.password_field);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.validateLogin(userNameField.getText().toString(),
                        passwordField.getText().toString());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        final Observer<Boolean> loginStatusObserver = new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean loginStatus) {
                if (loginStatus) {
                    Toast.makeText(getActivity(), getString(R.string.successful), Toast.LENGTH_LONG).show();
                    navigateToHome();
                }else {
                    Toast.makeText(getActivity(), getString(R.string.failed), Toast.LENGTH_LONG).show();
                }
            }
        };
        mViewModel.getLoginStatus().observe(this, loginStatusObserver);

    }

    private void navigateToHome() {
        Intent intent =  new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }

}
