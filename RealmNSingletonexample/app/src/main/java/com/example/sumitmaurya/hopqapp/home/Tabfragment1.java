package com.example.sumitmaurya.hopqapp.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.adapters.HomeAdapter;
import com.example.sumitmaurya.hopqapp.database.EventCategory;
import com.example.sumitmaurya.hopqapp.detailpage1.Detailpage1;
import com.example.sumitmaurya.hopqapp.others.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Tabfragment1 extends Fragment implements TabContractorInterface.MainViewInterface, ItemClickListener {


    SearchView searchView;


    RecyclerView catlist;

    TabPresenter tabPresenter;
    HomeAdapter homeAdapter;
    List<EventCategory> listfinal = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1, container, false);

        searchView = view.findViewById(R.id.searchView);
        catlist = view.findViewById(R.id.catlist);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
        catlist.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView


        setupMVP();
        return view;
    }

    private void setupMVP() {

        tabPresenter = new TabPresenter(this, new TabModel());
        tabPresenter.fetchData(getActivity());
    }


    @Override
    public void displayEventdata(List<EventCategory> list) {
        listfinal = list;

        try {
            homeAdapter = new HomeAdapter(list, getContext());
            catlist.setAdapter(homeAdapter);
            homeAdapter.setClickListener(this);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void displayError(String s) {

    }

    @Override
    public void onClick(View view, int position) {

        Intent moveToWebview = new Intent(getActivity(), Detailpage1.class);
        moveToWebview.putExtra("Category", listfinal.get(position).getCatName());
        startActivity(moveToWebview);

    }
}
