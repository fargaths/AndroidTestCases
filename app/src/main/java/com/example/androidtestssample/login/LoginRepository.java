package com.example.androidtestssample.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.androidtestssample.R;

import java.util.HashMap;
import java.util.Iterator;

public class LoginRepository {

    private HashMap<Integer, String> userNames = new HashMap<>(3);
    private HashMap<Integer, String> passwords = new HashMap<>(3);


    private static LoginRepository sInstance;

    public static LoginRepository getInstance() {
        if (sInstance == null) {
            synchronized (LoginRepository.class) {
                if (sInstance == null) {
                    sInstance = new LoginRepository();
                }
            }
        }
        return sInstance;
    }

    public LoginRepository() {
        // key is same for user name and password set
        userNames.put(0, "john");
        passwords.put(0, "john12");
        userNames.put(1, "maria");
        passwords.put(1, "maria23");
        userNames.put(2, "april");
        passwords.put(2, "april14");
    }

    public boolean verifyLoginDetails(String userName, String password) {

        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
            return verifyUserNameAndPassword(userName, password);
        }
        return false;
    }

    private boolean verifyUserNameAndPassword(String userName, String password) {
        Iterator userNameIterator = userNames.keySet().iterator();
        while (userNameIterator.hasNext()) {
            Integer key = (Integer) userNameIterator.next();
            String value = userNames.get(key);
            if (TextUtils.equals(userName, value) &&
                    TextUtils.equals(passwords.get(key), password)) {
                    return true;
            }
        }
        return false;
    }


    public String getUserName() {
        return "John";// could be from sharedpref as well if already logged in
    }

    public String getAppName(Context context) {
        return context.getString(R.string.app_name);
    }


    // Sign up flow, check whether user enters valid email and password

    public boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean isValidPassword(String password) {
        if (password.length() >= 8 && password.matches(".*\\d.*")) {
            return true;
        }
        return false;
    }

}
