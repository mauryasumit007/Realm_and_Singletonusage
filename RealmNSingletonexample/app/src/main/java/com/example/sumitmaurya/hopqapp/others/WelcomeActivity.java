package com.example.sumitmaurya.hopqapp.others;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sumitmaurya.hopqapp.Login.LoginActivity;
import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.Signup.SignupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.signupbutton)
    Button signupbutton;

    @BindView(R.id.signinbutton)
    Button signinbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);
        ButterKnife.bind(this);

        signinbutton.setOnClickListener(this);
        signupbutton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if (v==signinbutton){

            startActivity(new Intent(this, LoginActivity.class));


        }else {

            startActivity(new Intent(this, SignupActivity.class));

         }

    }
}
