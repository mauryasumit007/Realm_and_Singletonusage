package com.example.sumitmaurya.hopqapp.Signup;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sumitmaurya.hopqapp.Login.LoginActivity;
import com.example.sumitmaurya.hopqapp.R;


import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends Activity implements SignupView {

    @BindView(R.id.signupbutton)
    Button signupbutton;


    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.emailid)
    EditText emailid;

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    private SignupPresenter presenter;
    Context context= SignupActivity.this;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
        ButterKnife.bind(this);


        presenter=new SignupPresenterimpl(this,new SignupInteractorimpl());

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                presenter.ValidateandSignup(username.getText().toString(),emailid.getText().toString(), password.getText().toString(),context);

            }
        });


    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        progressBar.setVisibility(View.GONE);

        username.setError("Username not correct");

    }

    @Override public void setPasswordError() {
        progressBar.setVisibility(View.GONE);

        password.setError("Password not correct");
    }



    @Override public void setEmailError() {
        progressBar.setVisibility(View.GONE);

        emailid.setError("Email not correct");
    }

    @Override public void navigateToHome(String userSignedUp) {
        progressBar.setVisibility(View.GONE);

        Toast.makeText(SignupActivity.this,"Signup Successful"+ userSignedUp,Toast.LENGTH_LONG).show();
        Intent i=new Intent(this, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }


}
