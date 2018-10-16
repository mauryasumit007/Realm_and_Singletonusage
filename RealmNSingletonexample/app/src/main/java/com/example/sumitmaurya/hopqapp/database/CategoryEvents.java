package com.example.sumitmaurya.hopqapp.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CategoryEvents extends RealmObject {

    public CategoryEvents(int cateventId, String title, String subtitle, String date, String category, String liked, String favorite) {
        CateventId = cateventId;
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.category = category;
        this.liked = liked;
        this.favorite = favorite;
    }

    public CategoryEvents() {
    }

    public int getCateventId() {
        return CateventId;
    }

    public void setCateventId(int cateventId) {
        CateventId = cateventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @PrimaryKey
    private int CateventId;
    private String title;
    private String subtitle;
    private String date;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    private String liked;
    private String favorite;


}
