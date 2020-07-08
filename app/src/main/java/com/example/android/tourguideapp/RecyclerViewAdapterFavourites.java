package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterFavourites
        extends RecyclerView.Adapter<RecyclerViewAdapterFavourites.ViewHolder> {

    MainActivity mParentActivity;
    private ArrayList<LocationContent.LocationItem> mDataset;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LocationContent.LocationItem item = (LocationContent.LocationItem) v.getTag();

            Context context = v.getContext();
            Intent intent = new Intent(context, LocationDetailActivity.class);
            intent.putExtra(LocationDetailFragment.ARG_ITEM_ID, item.mID);

            context.startActivity(intent);
        }
    };

    public RecyclerViewAdapterFavourites(MainActivity parent, ArrayList<LocationContent.LocationItem> locationItems) {
        this.mDataset = locationItems;
        this.mParentActivity = parent;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_object_favourite, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.mContentView.setImageResource(mDataset.get(position).mLocationImage);

        holder.itemView.setTag(mDataset.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mContentView;

        public ViewHolder(View itemView) {
            super(itemView);
            mContentView = itemView.findViewById(R.id.content_favourites);
        }
    }
}
