package com.example.sumitmaurya.hopqapp.others;





import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.home.MainActivity;


public class Splash extends Activity {
    // SessionManager session;
    Context context=Splash.this;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);



//METHOD 2


        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {


                if(SharedPrefManager.getInstance(getApplicationContext()).getUserinfo()==null)
              {

                  startActivity(new Intent(Splash.this, WelcomeActivity.class));


              }else {
                  startActivity(new Intent(Splash.this, MainActivity.class));
              }

            }
        }, 3*1000); // wait for 3 seconds

    }

    @Override
    public void onBackPressed() {

    }
}
