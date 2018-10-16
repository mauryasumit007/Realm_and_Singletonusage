package com.example.sumitmaurya.hopqapp.others;

import android.app.Activity;
import android.app.Application;

import com.example.sumitmaurya.hopqapp.database.CategoryEvents;
import com.example.sumitmaurya.hopqapp.database.EventCategory;

import java.util.ArrayList;
import java.util.List;

public class HopqApplication extends Application {

    private static HopqApplication CONTEXT;

    private Activity mCurrentActivity = null;


    public List<EventCategory> getEventSingletonList() {
        return eventSingletonList;
    }

    public void setEventSingletonList(List<EventCategory> eventSingletonList) {
        this.eventSingletonList = eventSingletonList;
    }

    List<EventCategory>  eventSingletonList = new ArrayList<EventCategory>();

    public List<CategoryEvents> getCatEventlist() {
        return catEventlist;
    }

    public void setCatEventlist(List<CategoryEvents> catEventlist) {
        this.catEventlist = catEventlist;
    }

    List<CategoryEvents>  catEventlist = new ArrayList<CategoryEvents>();



    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this;
    }

    public static HopqApplication getInstance() {
        return CONTEXT;
    }

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public boolean isClosed() {
        return mCurrentActivity == null;
    }

    public void setCurrentActivity(Activity currentActivity) {
        mCurrentActivity = currentActivity;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

    }


}
