package com.example.sumitmaurya.hopqapp.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FavoriteEvents extends RealmObject {

    public int getFavid() {
        return favid;
    }

    public void setFavid(int favid) {
        this.favid = favid;
    }

    public int getFavindex() {
        return favindex;
    }

    public void setFavindex(int favindex) {
        this.favindex = favindex;
    }

    @PrimaryKey
    private int favid;
    private int favindex;
}
