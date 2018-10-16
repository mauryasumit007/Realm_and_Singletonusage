package com.example.sumitmaurya.hopqapp.Signup;

import android.content.Context;

import com.example.sumitmaurya.hopqapp.Login.LoginInteractor;
import com.example.sumitmaurya.hopqapp.Login.LoginPresenter;
import com.example.sumitmaurya.hopqapp.Login.LoginView;
import com.example.sumitmaurya.hopqapp.database.UserSignedUp;

public class SignupPresenterimpl implements SignupPresenter,SignupInteractor.OnSignupFinishedListener {


    private SignupView signupView;
    private SignupInteractor signupInteractor;

    public SignupPresenterimpl(SignupView signupView, SignupInteractor signupInteractor) {
        this.signupView = signupView;
        this.signupInteractor = signupInteractor;
    }

    @Override
    public void onUsernameError() {
  signupView.setUsernameError();
    }

    @Override
    public void onEmailError() {
signupView.setEmailError();
    }

    @Override
    public void onPasswordError() {
signupView.setPasswordError();
    }

    @Override
    public void onSuccess(String userSignedUp) {
signupView.navigateToHome(userSignedUp);
    }

    @Override
    public void ValidateandSignup(String username, String email, String password, Context context) {

        signupInteractor.Signup(username,email, password, this,context);
    }

    @Override
    public void onDestroy() {

    }
}