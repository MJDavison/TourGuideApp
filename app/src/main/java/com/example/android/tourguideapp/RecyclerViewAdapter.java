package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    MainActivity mParentActivity;
    private ArrayList<LocationContent.LocationItem> mDataset;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LocationContent.LocationItem item = (LocationContent.LocationItem) v.getTag();

            Context context = v.getContext();
            Intent intent = new Intent(context, LocationDetailActivity.class);
            intent.putExtra(LocationDetailFragment.ARG_ITEM_ID, item.id);

            context.startActivity(intent);
        }
    };

    public RecyclerViewAdapter(MainActivity parent, ArrayList<LocationContent.LocationItem> locationItems) {
        this.mDataset = locationItems;
        this.mParentActivity = parent;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_object, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.mIdView.setText(mDataset.get(position).id);
        holder.mContentView.setText(mDataset.get(position).content);

        holder.itemView.setTag(mDataset.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mIdView;
        final TextView mContentView;

        public ViewHolder(View itemView) {
            super(itemView);
            mIdView = (TextView) itemView.findViewById(R.id.id_text);
            mContentView = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
