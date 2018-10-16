package com.example.sumitmaurya.hopqapp.home;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.sumitmaurya.hopqapp.database.CategoryEvents;
import com.example.sumitmaurya.hopqapp.database.EventCategory;
import com.example.sumitmaurya.hopqapp.database.RealmManager;
import com.example.sumitmaurya.hopqapp.others.HopqApplication;
import com.example.sumitmaurya.hopqapp.others.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

public class TabModel implements TabContractorInterface {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void getDataResponse(OnFinishedListener listener, OnErrorListener errorListener, Activity activity, MainViewInterface mvi) {

        List<String> event_name = new ArrayList<>();
        List<String> event_url = new ArrayList<>();
        List<EventCategory> eventList = new ArrayList<>();


        event_name.add("Outdoor");
        event_name.add("Food");
        event_name.add("Technology");
        event_name.add("Fashion");

        event_name.add("Adventure");

        event_url.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/PNG_transparency_demonstration_1.png/280px-PNG_transparency_demonstration_1.png");
        event_url.add("http://www.mulierchile.com/cool-wallpapers-for-girls/cool-wallpapers-for-girls-003.jpg");
        event_url.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/PNG_transparency_demonstration_1.png/280px-PNG_transparency_demonstration_1.png");
        event_url.add("http://www.mulierchile.com/cool-wallpapers-for-girls/cool-wallpapers-for-girls-003.jpg");
        event_url.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/PNG_transparency_demonstration_1.png/280px-PNG_transparency_demonstration_1.png");


        if (HopqApplication.getInstance().getEventSingletonList().isEmpty()) {
            for (int i = 0; i < event_url.size(); i++) {

                EventCategory ev = new EventCategory();
                ev.setCatid(i);
                ev.setCatUrl(event_url.get(i));
                ev.setCatName(event_name.get(i));
                eventList.add(ev);
            }
        }


        HopqApplication.getInstance().setEventSingletonList(eventList);


        ArrayList<CategoryEvents> storeCatlist = new ArrayList<CategoryEvents>();

        storeCatlist.add(new CategoryEvents(1, "Outdoor1", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(2, "Outdoor2", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(3, "Outdoor3", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(3, "Outdoor4", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(5, "Outdoor5", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(6, "Outdoor6", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(7, "Outdoor7", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(8, "Outdoor8", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(9, "Outdoor9", "out event", "10-20 sep", "Outdoor", "no", "no"));
        storeCatlist.add(new CategoryEvents(10, "Outdoor10", "out event", "10-20 sep", "Outdoor", "no", "no"));

        storeCatlist.add(new CategoryEvents(11, "Food1", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(12, "Food2", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(13, "Food3", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(14, "Food4", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(15, "Food5", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(16, "Food6", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(17, "Food7", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(18, "Food8", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(19, "Food9", "food event", "10-20 sep", "Food", "no", "no"));
        storeCatlist.add(new CategoryEvents(20, "Food10", "food event", "10-20 sep", "Food", "no", "no"));


        storeCatlist.add(new CategoryEvents(21, "Technology1", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(22, "Technology2", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(23, "Technology3", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(24, "Technology4", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(25, "Technology5", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(26, "Technology6", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(27, "Technology7", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(28, "Technology8", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(29, "Technology9", "tech event", "10-20 sep", "Technology", "no", "no"));
        storeCatlist.add(new CategoryEvents(30, "Technology10", "tech event", "10-20 sep", "Technology", "no", "no"));


        storeCatlist.add(new CategoryEvents(31, "Fashion1", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(32, "Fashion2", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(33, "Fashion3", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(34, "Fashion4", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(35, "Fashion5", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(36, "Fashion6", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(37, "Fashion7", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(38, "Fashion8", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(39, "Fashion9", "fashion event", "10-20 sep", "Fashion", "no", "no"));
        storeCatlist.add(new CategoryEvents(40, "Fashion10", "fashion event", "10-20 sep", "Fashion", "no", "no"));


        storeCatlist.add(new CategoryEvents(11, "Adventure1", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(42, "Adventure2", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(43, "Adventure3", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(44, "Adventure4", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(45, "Adventure5", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(46, "Adventure6", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(47, "Adventure7", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(48, "Adventure8", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(49, "Adventure9", "adventure event", "10-20 sep", "Adventure", "no", "no"));
        storeCatlist.add(new CategoryEvents(50, "Adventure10", "adventure event", "10-20 sep", "Adventure", "no", "no"));

        HopqApplication.getInstance().setCatEventlist(storeCatlist);

// Get liked events

        if (RealmManager.getInstance().getLikedevents() != null) {

            for (int i = 0; i < RealmManager.getInstance().getLikedevents().size(); i++) {

                HopqApplication.getInstance().getCatEventlist().get(RealmManager.getInstance().getLikedevents().get(i).getLikeindex()).setLiked("yes");

            }
        }

// get favorite events


        if (RealmManager.getInstance().getfavindex() != null) {

            for (int i = 0; i < RealmManager.getInstance().getfavindex().size(); i++) {

                HopqApplication.getInstance().getCatEventlist().get(RealmManager.getInstance().getfavindex().get(i).getFavindex()).setFavorite("yes");

            }
        }


        listener.onFinished(HopqApplication.getInstance().getEventSingletonList());


    }
}
