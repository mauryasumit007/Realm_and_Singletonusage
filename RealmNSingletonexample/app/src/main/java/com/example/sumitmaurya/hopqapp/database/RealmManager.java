package com.example.sumitmaurya.hopqapp.database;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.sumitmaurya.hopqapp.others.HopqApplication;

import java.util.ArrayList;
import java.util.List;


import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmManager {


    private static RealmManager mInstance;
    private static boolean mIsTesting = false;

    public static RealmManager getInstance() {
        if (mInstance == null) {
            mInstance = new RealmManager();
        }
        return mInstance;
    }

    public static void setSpecialInstanceForTesting(RealmManager realmManager) {
        mInstance = realmManager;
        mIsTesting = true;
    }

    public static boolean isTesting() {
        return mIsTesting;
    }

    public void saveUserDetail(UserSignedUp userSignedUp, Context context) {
        Realm realm = getRealm();
        if (realm.isInTransaction()) {

            realm.cancelTransaction();
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(userSignedUp);
        realm.commitTransaction();

    }

    public void saveLikedindex(LikedEvents likedEvents, Context context) {
        Realm realm = getRealm();
        if (realm.isInTransaction()) {

            realm.cancelTransaction();
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(likedEvents);
        realm.commitTransaction();

    }





    public List<LikedEvents> getLikedevents() {
        List<LikedEvents> likelist = new ArrayList<>();

        Realm realm = getRealm();

        if (realm.isInTransaction()) {

            realm.cancelTransaction();
        }
        RealmResults<LikedEvents> likes = realm.where(LikedEvents.class)
                .findAll();

        for (LikedEvents likw : likes) {
            likelist.add(likw);
        }

        return likelist;
    }


    public void savedFavindex(FavoriteEvents favoriteEvents, Context context) {
        Realm realm = getRealm();
        if (realm.isInTransaction()) {

            realm.cancelTransaction();
        }
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(favoriteEvents);
        realm.commitTransaction();

    }

    public List<FavoriteEvents> getfavindex() {
        List<FavoriteEvents> likelist = new ArrayList<>();

        Realm realm = getRealm();

        if (realm.isInTransaction()) {

            realm.cancelTransaction();
        }
        RealmResults<FavoriteEvents> likes = realm.where(FavoriteEvents.class)
                .findAll();

        for (FavoriteEvents likw : likes) {
            likelist.add(likw);
        }

        return likelist;
    }


    private Realm getRealm() {
        Realm.init(HopqApplication.getInstance());
        return Realm.getDefaultInstance();
    }

    public UserSignedUp getUserdetail(String email, String password, Context context) {
        Realm realm = getRealm();
        if (realm.isInTransaction()) {

            realm.cancelTransaction();
        }
        realm.beginTransaction();
        UserSignedUp users =
                realm.where(UserSignedUp.class)
                        .equalTo("email", email)
                        .equalTo("password", password)
                        .findFirst();


        return users;
    }


}
