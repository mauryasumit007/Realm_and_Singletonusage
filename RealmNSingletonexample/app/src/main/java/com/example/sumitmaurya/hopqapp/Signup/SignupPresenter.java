package com.example.sumitmaurya.hopqapp.Signup;

import android.content.Context;

public interface SignupPresenter {

    void ValidateandSignup(String username, String email, String password, Context context);

    void onDestroy();
}
