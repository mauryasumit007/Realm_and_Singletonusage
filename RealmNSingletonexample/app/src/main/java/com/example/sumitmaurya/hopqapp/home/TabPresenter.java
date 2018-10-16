package com.example.sumitmaurya.hopqapp.home;

import android.app.Activity;

import com.example.sumitmaurya.hopqapp.database.EventCategory;

import java.util.List;


public class TabPresenter implements TabContractorInterface.MainPresenterInterface, TabContractorInterface.OnFinishedListener, TabContractorInterface.OnErrorListener {

    TabContractorInterface.MainViewInterface viewInterface;
    private TabContractorInterface mainContractorInterface;


    public TabPresenter(TabContractorInterface.MainViewInterface viewInterface, TabContractorInterface mainContractorInterface) {
        this.viewInterface = viewInterface;
        this.mainContractorInterface = mainContractorInterface;
    }


    @Override
    public void fetchData(Activity activity) {

        mainContractorInterface.getDataResponse(this, this, activity, viewInterface);


    }

    @Override
    public void onFinished(List<EventCategory> eventList) {


        viewInterface.displayEventdata(eventList);


    }

    @Override
    public void onError(String error) {

        viewInterface.displayError(error);
    }
}
