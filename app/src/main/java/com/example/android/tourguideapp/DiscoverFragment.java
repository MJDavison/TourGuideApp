package com.example.android.tourguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;



public class DiscoverFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    public DiscoverFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
        if (LocationContent.List.size() < 1)
            createLocations();

        return rootView;
    }

    private void createLocations() {
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), getString(R.string.charles_church_name), getString(R.string.charles_church_street), getString(R.string.charles_church_postcode), getString(R.string.charles_church_details)));
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), getString(R.string.theatre_royal_plymouth_name), getString(R.string.royal_parade_street), getString(R.string.theatre_royal_postcode), getString(R.string.theatre_royal_details)));
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), getString(R.string.the_tudor_rose_name), getString(R.string.the_tudor_rose_street), getString(R.string.the_tudor_rose_postcode), getString(R.string.the_tudor_rose_details)));
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), getString(R.string.drake_circus_name), getString(R.string.drakes_circus_street), getString(R.string.drake_circus_postcode), getString(R.string.drake_circus_details)));
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        mAdapter = new RecyclerViewAdapter((MainActivity) getActivity(), LocationContent.List);
        recyclerView.setAdapter(mAdapter);
    }


}