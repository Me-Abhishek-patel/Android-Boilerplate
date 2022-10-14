package com.ciberciti.subscraze.boilerplate.utils.data;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public class ValidationUtils {
    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
