package com.example.sumitmaurya.hopqapp.detailpage2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.adapters.Detailpage1Adapter;
import com.example.sumitmaurya.hopqapp.adapters.HomeAdapter;
import com.example.sumitmaurya.hopqapp.database.CategoryEvents;
import com.example.sumitmaurya.hopqapp.database.FavoriteEvents;
import com.example.sumitmaurya.hopqapp.database.LikedEvents;
import com.example.sumitmaurya.hopqapp.database.RealmManager;
import com.example.sumitmaurya.hopqapp.database.UserSignedUp;
import com.example.sumitmaurya.hopqapp.others.HopqApplication;
import com.example.sumitmaurya.hopqapp.others.SharedPrefManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsPage2 extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.title1)
    TextView title1;

    @BindView(R.id.title2)
    TextView title2;

    @BindView(R.id.title4)
    TextView title4;

    @BindView(R.id.like)
    TextView like;

    @BindView(R.id.unlike)
    TextView unlike;

    @BindView(R.id.share)
    ImageView share;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;

    @BindView(R.id.expandedImage)
    ImageView expendedImage;

    @BindView(R.id.collapsetitle)
    TextView collapsetitle;

    ImageView back, star;

    String category, title, date, image;
    List<String> likedindex = new ArrayList<>();
    List<String> favindex = new ArrayList<>();


    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail2);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getIntent().getStringExtra("title"));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        loadData();


    }


    private void loadData() {

        back = toolbar.findViewById(R.id.back);
        star = toolbar.findViewById(R.id.star);

        back.setOnClickListener(this);
        star.setOnClickListener(this);
        like.setOnClickListener(this);
        unlike.setOnClickListener(this);
        share.setOnClickListener(this);

        collapsetitle.setText(getIntent().getStringExtra("title"));
        title1.setText(getIntent().getStringExtra("title"));
        title2.setText(getIntent().getStringExtra("date"));
        title4.setText("HopQ Event!");
        Picasso.with(this).load("http://www.mulierchile.com/cool-wallpapers-for-girls/cool-wallpapers-for-girls-003.jpg").into(expendedImage);

    }


    @Override
    public void onClick(View view) {

        if (view == back) {
            finish();
        } else if (view == star) {

            star.setImageResource(android.R.drawable.star_big_on);

            for (int i = 0; i < HopqApplication.getInstance().getCatEventlist().size(); i++) {

                if (HopqApplication.getInstance().getCatEventlist().get(i).getTitle().equals(getIntent().getStringExtra("title"))) {

                    HopqApplication.getInstance().getCatEventlist().get(i).setFavorite("yes");
                    Toast.makeText(DetailsPage2.this, "Response Saved", Toast.LENGTH_LONG).show();

                    FavoriteEvents likedEvents = new FavoriteEvents();
                    likedEvents.setFavid(new Random().nextInt((80 - 20) + 1) + 20);
                    likedEvents.setFavindex(i);
                    RealmManager.getInstance().savedFavindex(likedEvents, DetailsPage2.this);

                    break;
                }
            }

            Toast.makeText(DetailsPage2.this, "Added to Favorites", Toast.LENGTH_LONG).show();


        } else if (view == like) {

            for (int i = 0; i < HopqApplication.getInstance().getCatEventlist().size(); i++) {

                if (HopqApplication.getInstance().getCatEventlist().get(i).getTitle().equals(getIntent().getStringExtra("title"))) {

                    HopqApplication.getInstance().getCatEventlist().get(i).setLiked("yes");
                    Toast.makeText(DetailsPage2.this, "Response Saved", Toast.LENGTH_LONG).show();


                    LikedEvents likedEvents = new LikedEvents();
                    likedEvents.setLikeid(new Random().nextInt((80 - 20) + 1) + 20);
                    likedEvents.setLikeindex(i);
                    RealmManager.getInstance().saveLikedindex(likedEvents, DetailsPage2.this);

                    break;
                }
            }


        } else if(view==unlike){

            for (int i = 0; i < HopqApplication.getInstance().getCatEventlist().size(); i++) {

                if (HopqApplication.getInstance().getCatEventlist().get(i).getTitle().equals(getIntent().getStringExtra("title"))) {
                    HopqApplication.getInstance().getCatEventlist().get(i).setLiked("no");
                    Toast.makeText(DetailsPage2.this, "Response Saved", Toast.LENGTH_LONG).show();


                   if(RealmManager.getInstance().getLikedevents()!=null){
                    if(RealmManager.getInstance().getLikedevents().contains(i)){

                        RealmManager.getInstance().getLikedevents().remove(i);

                    }}



                    break;
                }

            }


        }else {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Please use this HopQ app");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
    }
}
