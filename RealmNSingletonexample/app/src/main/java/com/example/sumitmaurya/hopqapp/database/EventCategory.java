package com.example.sumitmaurya.hopqapp.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class EventCategory extends RealmObject {


    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatUrl() {
        return catUrl;
    }

    public void setCatUrl(String catUrl) {
        this.catUrl = catUrl;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    @PrimaryKey
    private int catid;

    private String catName;
    private String catUrl;
}
