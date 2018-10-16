package com.example.sumitmaurya.hopqapp.home;

import android.app.Activity;

import com.example.sumitmaurya.hopqapp.database.EventCategory;

import java.util.List;


public interface TabContractorInterface {


    // Network request interface

    interface OnFinishedListener {
        void onFinished(List<EventCategory> eventList);
    }

    // Error listener interface

    interface OnErrorListener {
        void onError(String error);
    }

    // Main Action interface

    interface MainPresenterInterface {

        void fetchData( Activity activity);
    }


    // VIew interface

    interface MainViewInterface {


        void displayEventdata(List<EventCategory> eventCategories);
        void displayError(String s);
    }

    // Method to get response and send to presenter

    void getDataResponse(OnFinishedListener listener,OnErrorListener errorListener,  Activity activity, TabContractorInterface.MainViewInterface mvi);

}
