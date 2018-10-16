package com.example.sumitmaurya.hopqapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.database.CategoryEvents;
import com.example.sumitmaurya.hopqapp.database.EventCategory;
import com.example.sumitmaurya.hopqapp.others.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Detailpage1Adapter extends RecyclerView.Adapter<Detailpage1Adapter.Detailpage1holder> {

    Context context;
    List<CategoryEvents> categoryEvents;
    private ItemClickListener itemClickListener;

    public Detailpage1Adapter(List<CategoryEvents> categoryEvents, Context context) {
        this.categoryEvents = categoryEvents;
        this.context = context;
    }

    @Override
    public Detailpage1holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_detail1, parent, false);
        Detailpage1holder mh = new Detailpage1holder(view);
        return mh;

    }

    @Override
    public void onBindViewHolder(final Detailpage1holder holder, int position) {


        holder.tvTitle.setText(categoryEvents.get(position).getTitle());
        holder.tvOverview.setText(categoryEvents.get(position).getDate());
        holder.tvotherinfo.setText(categoryEvents.get(position).getSubtitle());
        Picasso.with(context)
                .load("http://www.mulierchile.com/cool-wallpapers-for-girls/cool-wallpapers-for-girls-003.jpg")
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.iwikiprofile);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null)
                    itemClickListener.onClick(view, holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {

        return categoryEvents.size();
    }


    public void setClickListener(ItemClickListener itemClickListener) {    //  Method for setting clicklistner interface
        this.itemClickListener = itemClickListener;

    }

    public class Detailpage1holder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvOverview, tvotherinfo;
        ImageView iwikiprofile;

        public Detailpage1holder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvOverview = (TextView) v.findViewById(R.id.tvOverView);
            tvotherinfo = (TextView) v.findViewById(R.id.tvotherinfo);
            iwikiprofile = (ImageView) v.findViewById(R.id.iwikiprofile);
        }


    }
}
