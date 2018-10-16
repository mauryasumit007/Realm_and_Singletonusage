package com.example.sumitmaurya.hopqapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.adapters.Detailpage1Adapter;
import com.example.sumitmaurya.hopqapp.database.CategoryEvents;
import com.example.sumitmaurya.hopqapp.detailpage1.Detailpage1;
import com.example.sumitmaurya.hopqapp.detailpage2.DetailsPage2;
import com.example.sumitmaurya.hopqapp.others.HopqApplication;
import com.example.sumitmaurya.hopqapp.others.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class Tabfragment2 extends Fragment implements ItemClickListener {

    //Overriden method onCreateView

    RecyclerView favlist;
    Detailpage1Adapter detailpage1Adapter;
    List<CategoryEvents> result = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View v = inflater.inflate(R.layout.tab2, container, false);
        favlist = v.findViewById(R.id.favlist);

        favlist.setLayoutManager(new LinearLayoutManager(getActivity()));

        result.clear();
        for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {

            if (person.getFavorite().equals("yes")) {
                result.add(person);
            }
        }

        detailpage1Adapter = new Detailpage1Adapter(result, getActivity());
        favlist.setAdapter(detailpage1Adapter);
      detailpage1Adapter.setClickListener(this);


        return v;
    }

    @Override
    public void onClick(View view, int position) {

        Intent moveToWebview = new Intent(getActivity(), DetailsPage2.class);

        moveToWebview.putExtra("title", result.get(position).getTitle());
        moveToWebview.putExtra("date", result.get(position).getDate());
        moveToWebview.putExtra("image", result.get(position).getUrl());
        startActivity(moveToWebview);

    }
}