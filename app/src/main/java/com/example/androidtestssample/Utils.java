package com.example.androidtestssample;

import android.text.TextUtils;
import android.util.Patterns;

public class Utils {

    private Utils() {

    }

    public static boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

}
