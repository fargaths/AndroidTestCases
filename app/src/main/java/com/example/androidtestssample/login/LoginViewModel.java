package com.example.androidtestssample.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> loginStatus;
    private LoginRepository loginRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository = LoginRepository.getInstance();
    }

    public MutableLiveData<Boolean> getLoginStatus() {
        if (loginStatus == null) {
            loginStatus = new MutableLiveData<>();
        }
        return loginStatus;
    }


    void validateLogin(String userName, String password) {
        boolean status = loginRepository.verifyLoginDetails(userName,password);
        loginStatus.setValue(status);
    }
}
