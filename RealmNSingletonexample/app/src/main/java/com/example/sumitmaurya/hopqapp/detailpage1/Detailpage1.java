package com.example.sumitmaurya.hopqapp.detailpage1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.adapters.Detailpage1Adapter;
import com.example.sumitmaurya.hopqapp.adapters.HomeAdapter;
import com.example.sumitmaurya.hopqapp.database.CategoryEvents;
import com.example.sumitmaurya.hopqapp.detailpage2.DetailsPage2;
import com.example.sumitmaurya.hopqapp.others.HopqApplication;
import com.example.sumitmaurya.hopqapp.others.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Detailpage1 extends AppCompatActivity implements ItemClickListener, AdapterView.OnItemSelectedListener {

    Detailpage1Adapter detailpage1Adapter;

    @BindView(R.id.detail1list)
    RecyclerView detail1list;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.cat)
    TextView cat;

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.searchView)
    SearchView searchView;

    private Menu menu;

    private String section = "Event categories";

    ImageView backicon;
    TextView toolTitle;

    List<CategoryEvents> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail1);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        backicon = toolbar.findViewById(R.id.back);
        toolTitle = toolbar.findViewById(R.id.toolTitle);
        toolTitle.setText(getIntent().getStringExtra("Category"));

        initviews();

        loadList();
        initSpinner();
        searchmethod();


    }

    private void initviews() {

        backicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        detail1list.setLayoutManager(new LinearLayoutManager(this));

    }

    private void searchmethod() {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                if (section.equals("Event categories")) {

                    result.clear();
                    for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {
                        if (person.getCategory().equals(s)) {
                            result.add(person);
                        }
                    }
                    detailpage1Adapter = new Detailpage1Adapter(result, Detailpage1.this);
                    detail1list.setAdapter(detailpage1Adapter);
                    detailpage1Adapter.setClickListener(Detailpage1.this);

                } else if (section.equals("Event Name")) {

                    result.clear();
                    for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {
                        if (person.getTitle().equals(s)) {
                            result.add(person);
                        }
                    }
                    detailpage1Adapter = new Detailpage1Adapter(result, Detailpage1.this);
                    detail1list.setAdapter(detailpage1Adapter);
                    detailpage1Adapter.setClickListener(Detailpage1.this);


                } else {

                    result.clear();
                    for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {
                        if (person.getLiked().equals("yes")) {
                            result.add(person);
                        }
                    }
                    detailpage1Adapter = new Detailpage1Adapter(result, Detailpage1.this);
                    detail1list.setAdapter(detailpage1Adapter);
                    detailpage1Adapter.setClickListener(Detailpage1.this);


                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if (section.equals("Event categories")) {

                    result.clear();
                    for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {
                        if (person.getCategory().startsWith(s)) {
                            result.add(person);
                        }
                    }
                    detailpage1Adapter = new Detailpage1Adapter(result, Detailpage1.this);
                    detail1list.setAdapter(detailpage1Adapter);
                    detailpage1Adapter.setClickListener(Detailpage1.this);

                } else if (section.equals("Event Name")) {

                    result.clear();
                    for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {
                        if (person.getTitle().startsWith(s)) {
                            result.add(person);
                        }
                    }
                    detailpage1Adapter = new Detailpage1Adapter(result, Detailpage1.this);
                    detail1list.setAdapter(detailpage1Adapter);
                    detailpage1Adapter.setClickListener(Detailpage1.this);

                } else {

                    result.clear();
                    for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {
                        if (person.getLiked().startsWith(s)) {
                            result.add(person);
                        }
                    }
                    detailpage1Adapter = new Detailpage1Adapter(result, Detailpage1.this);
                    detail1list.setAdapter(detailpage1Adapter);
                    detailpage1Adapter.setClickListener(Detailpage1.this);


                }

                Toast.makeText(Detailpage1.this, "Hello", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initSpinner() {

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Event categories");
        categories.add("Event Name");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    private void loadList() {

        result = new ArrayList<CategoryEvents>();
        for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {
            if (person.getCategory().equals(getIntent().getStringExtra("Category"))) {
                result.add(person);
            }
        }
        detailpage1Adapter = new Detailpage1Adapter(result, this);
        detail1list.setAdapter(detailpage1Adapter);
        detailpage1Adapter.setClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            result.clear();

            for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {

                if (person.getFavorite().equals("yes")) {
                    result.add(person);
                }
            }

            detailpage1Adapter = new Detailpage1Adapter(result, this);
            detail1list.setAdapter(detailpage1Adapter);
            detailpage1Adapter.setClickListener(this);

            return true;
        } else if (id == R.id.action_category) {


            loadList();

        } else {

            result.clear();

            for (CategoryEvents person : HopqApplication.getInstance().getCatEventlist()) {

                if (person.getLiked().equals("yes")) {
                    result.add(person);
                }
            }

            detailpage1Adapter = new Detailpage1Adapter(result, this);
            detail1list.setAdapter(detailpage1Adapter);
            detailpage1Adapter.setClickListener(this);

            return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view, int position) {
        Intent moveToWebview = new Intent(Detailpage1.this, DetailsPage2.class);
        moveToWebview.putExtra("Category", getIntent().getStringExtra("Category"));
        moveToWebview.putExtra("title", result.get(position).getTitle());
        moveToWebview.putExtra("date", result.get(position).getDate());
        moveToWebview.putExtra("image", result.get(position).getUrl());
        startActivity(moveToWebview);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        section = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
