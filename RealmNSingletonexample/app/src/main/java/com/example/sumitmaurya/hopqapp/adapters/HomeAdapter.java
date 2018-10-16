package com.example.sumitmaurya.hopqapp.adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumitmaurya.hopqapp.R;
import com.example.sumitmaurya.hopqapp.database.EventCategory;
import com.example.sumitmaurya.hopqapp.others.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.EventDataHolder> {

    List<EventCategory> eventList;
    Context context;
    ItemClickListener itemClickListener;


    public HomeAdapter(List<EventCategory> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public EventDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout1, parent, false);
        EventDataHolder mh = new EventDataHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(final EventDataHolder holder, int position) {

        holder.tvTitle.setText(eventList.get(position).getCatName());


        Picasso.with(context)
                .load(eventList.get(position).getCatUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.icon);

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
        return eventList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

//    public void setClickListener(ItemClickListener itemClickListener) {    //  Method for setting clicklistner interface
//        this.itemClickListener = itemClickListener;
//
//    }

    public void setClickListener(ItemClickListener itemClickListener) {    //  Method for setting clicklistner interface
        this.itemClickListener = itemClickListener;

    }

    public class EventDataHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        CardView carditem;
        ImageView icon;

        public EventDataHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.categoryName);
            carditem = v.findViewById(R.id.carditem);
            icon = v.findViewById(R.id.icon);

        }


    }
}
