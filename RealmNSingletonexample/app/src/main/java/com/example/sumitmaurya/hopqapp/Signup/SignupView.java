package com.example.sumitmaurya.hopqapp.Signup;

import com.example.sumitmaurya.hopqapp.database.UserSignedUp;

public interface SignupView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setEmailError();

    void setPasswordError();



    void navigateToHome(String userSignedUp);
}
