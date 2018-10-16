package com.example.sumitmaurya.hopqapp.others;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sumitmaurya.hopqapp.home.Tabfragment1;
import com.example.sumitmaurya.hopqapp.home.Tabfragment2;
import com.example.sumitmaurya.hopqapp.home.Tabfragment3;


//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Tabfragment1 tab1 = new Tabfragment1();
                return tab1;
            case 1:
                Tabfragment2 tab2 = new Tabfragment2();
                return tab2;
            case 2:
                Tabfragment3 tab3 = new Tabfragment3();
                return tab3;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
