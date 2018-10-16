package com.example.sumitmaurya.hopqapp.others;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.sumitmaurya.hopqapp.database.EventCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "UserLogininfo";
    private static final String SHARED_PREF_Liked = "Liked";
    private static final String SHARED_PREF_fav = "Fav";


    private static final String TAG_Email = "email";
    private static final String TAG_Pwd = "password";
    private static final String TAG_Name = "name";


    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;}

       // To save username and pwd

    public boolean saveUserinfo(String name,String email, String pwd){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_Name,name);
        editor.putString(TAG_Email, email);
        editor.putString(TAG_Pwd,pwd);
        editor.apply();
        return true;
    }
    //this method will fetch the device token from shared preferences
    public String getUserinfo(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(TAG_Email, null);
    }

    public String getusername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(TAG_Email, null);
    }


    public void clearSession(){
        SharedPreferences sp=mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor e=sp.edit();
        e.clear();
        e.commit();
    }

// Liked events

    public void savelikedevents(List<String> likedlist){

        SharedPreferences shared=mCtx.getSharedPreferences(SHARED_PREF_Liked,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("LikedEvents", TextUtils.join(",", likedlist));
        editor.apply();
    }
    public List<String> retriveSharedValue() {
        List<String> list=new ArrayList<>();
        SharedPreferences shared=mCtx.getSharedPreferences(SHARED_PREF_Liked,Context.MODE_PRIVATE);

       try {
           String serialized = shared.getString("LikedEvents", null);

           list = Arrays.asList(TextUtils.split(serialized, ","));
       }
           catch (Exception e){

           list=null;
           }


       return list;
    }


    //favorite events

    public void savefavorites(List<String> likedlist){
        SharedPreferences shared=mCtx.getSharedPreferences(SHARED_PREF_Liked,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("FavEvents", TextUtils.join(",", likedlist));
        editor.apply();
    }


    public List<String> retrivefavorites() {

        List<String> list;
        SharedPreferences shared=mCtx.getSharedPreferences(SHARED_PREF_Liked,Context.MODE_PRIVATE);

        String serialized = shared.getString("FavEvents", null);

        if(shared.getString("FavEvents", null)!=null){
            list = Arrays.asList(TextUtils.split(serialized, ","));


        }else {

            list=null;
        }

        return list;
    }
}
