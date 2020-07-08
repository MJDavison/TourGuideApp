package com.example.android.tourguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


public class RestaurantFragment extends Fragment {
    public static final String TAB_NAME = "Eat Out";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    public RestaurantFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);


        return rootView;
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        mAdapter = new RecyclerViewAdapter((MainActivity) getActivity(), LocationContent.restaurant);
        recyclerView.setAdapter(mAdapter);
    }


}