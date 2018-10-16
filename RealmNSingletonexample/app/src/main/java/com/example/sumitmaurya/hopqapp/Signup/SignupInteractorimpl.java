package com.example.sumitmaurya.hopqapp.Signup;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.example.sumitmaurya.hopqapp.database.EventCategory;
import com.example.sumitmaurya.hopqapp.database.RealmManager;
import com.example.sumitmaurya.hopqapp.database.UserSignedUp;

import java.util.ArrayList;
import java.util.List;

public class SignupInteractorimpl implements SignupInteractor {
    @Override
    public void Signup(final String username, final String email, final String password, final OnSignupFinishedListener listener, final Context context) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    listener.onEmailError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    return;
                }

                // Saving user information

                UserSignedUp personDetailsModel = new UserSignedUp();
                personDetailsModel.setName(username);
                personDetailsModel.setEmail(email);
                personDetailsModel.setPassword(password);
                RealmManager.getInstance().saveUserDetail(personDetailsModel,context);




                // Getting user information
                listener.onSuccess(username);
            }
        }, 1000);

        }
}
