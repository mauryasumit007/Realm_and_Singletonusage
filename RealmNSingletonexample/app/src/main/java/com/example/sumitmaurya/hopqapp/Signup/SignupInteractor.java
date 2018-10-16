package com.example.sumitmaurya.hopqapp.Signup;


import android.content.Context;

import com.example.sumitmaurya.hopqapp.database.UserSignedUp;

public interface SignupInteractor {

    interface OnSignupFinishedListener {
        void onUsernameError();

        void onEmailError();

        void onPasswordError();

        void onSuccess(String username);
    }

    void Signup(String username, String email, String password, OnSignupFinishedListener listener, Context context);
}
