

package com.example.sumitmaurya.hopqapp.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sumitmaurya.hopqapp.home.MainActivity;
import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.database.UserSignedUp;
import com.example.sumitmaurya.hopqapp.others.SharedPrefManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    @BindView(R.id.signupbutton)
    Button signupbutton;

    @BindView(R.id.progressBar)
    ProgressBar progressbar;

    @BindView(R.id.emailid)
    EditText emailid;

    @BindView(R.id.password)
    EditText password;

    Context context= LoginActivity.this;

    private LoginPresenter presenter;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        presenter=new LoginPresenterImpl(this,new LoginInteractorImpl());
        signupbutton.setOnClickListener(this);


    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressbar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        emailid.setError("Wrong Email Id");
    }

    @Override public void setPasswordError() {
        password.setError("Password not correct");
    }

    @Override
    public void setloginError(String failuremsg) {
        progressbar.setVisibility(View.GONE);
        Toast.makeText(context,failuremsg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome(UserSignedUp userSignedUp) {
        progressbar.setVisibility(View.GONE);
        Toast.makeText(context,"WELCOME USER : "+userSignedUp.getName(),Toast.LENGTH_LONG).show();

        SharedPrefManager.getInstance(getApplicationContext()).saveUserinfo(userSignedUp.getName(),userSignedUp.getEmail(),userSignedUp.getPassword());

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    @Override public void onClick(View v) {
        presenter.validateCredentials(emailid.getText().toString(), password.getText().toString(),context);
    }
}
