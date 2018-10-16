package com.example.sumitmaurya.hopqapp.Login;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.example.sumitmaurya.hopqapp.database.CategoryEvents;
import com.example.sumitmaurya.hopqapp.database.EventCategory;
import com.example.sumitmaurya.hopqapp.database.RealmManager;
import com.example.sumitmaurya.hopqapp.database.UserSignedUp;
import com.example.sumitmaurya.hopqapp.others.HopqApplication;

import java.util.ArrayList;
import java.util.List;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener, final Context context) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    return;
                }


                UserSignedUp userlogincredential= RealmManager.getInstance().getUserdetail(username,password,context);

                if(userlogincredential==null){

                 listener.onFailure("User Not Available!");
                }
                 else {





                    listener.onSuccess(userlogincredential);
                }
            }
        }, 1000);
    }
}

