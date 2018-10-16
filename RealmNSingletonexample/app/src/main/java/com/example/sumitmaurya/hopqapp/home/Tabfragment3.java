package com.example.sumitmaurya.hopqapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sumitmaurya.hopqapp.Login.LoginActivity;
import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.others.SharedPrefManager;

public class Tabfragment3 extends Fragment {

    //Overriden method onCreateView
    TextView username;
    Button signout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.tab3, container, false);

        username = v.findViewById(R.id.username);
        signout = v.findViewById(R.id.signout);

        username.setText(SharedPrefManager.getInstance(getContext()).getusername());

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPrefManager.getInstance(getContext()).clearSession();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return v;

    }
}
