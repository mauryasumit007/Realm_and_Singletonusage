package com.example.sumitmaurya.hopqapp.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LikedEvents extends RealmObject {

    public int getLikeid() {
        return likeid;
    }

    public void setLikeid(int likeid) {
        this.likeid = likeid;
    }

    public int getLikeindex() {
        return likeindex;
    }

    public void setLikeindex(int likeindex) {
        this.likeindex = likeindex;
    }

    @PrimaryKey
    private int likeid;
    private int likeindex;
}
