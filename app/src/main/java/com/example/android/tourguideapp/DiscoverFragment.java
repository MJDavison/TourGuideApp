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
        //By Chris Downer, CC BY-SA 2.0, https://commons.wikimedia.org/w/index.php?curid=3023918
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), "Historical Structure", getString(R.string.charles_church_name), getString(R.string.charles_church_street), getString(R.string.charles_church_postcode), R.drawable.charles_church_behinddrakescircus, getString(R.string.charles_church_details)));
        //By painma - Own work, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=40629939
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), "Entertainment", getString(R.string.theatre_royal_plymouth_name), getString(R.string.royal_parade_street), getString(R.string.theatre_royal_postcode), R.drawable.theatre_royal_plymouth, getString(R.string.theatre_royal_details)));
        // https://tudorrosetearooms.com/gallery/
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), "Restaurant", getString(R.string.the_tudor_rose_name), getString(R.string.the_tudor_rose_street), getString(R.string.the_tudor_rose_postcode), R.drawable.tudor_rose, getString(R.string.the_tudor_rose_details)));
        //By Tom Jolliffe, CC BY-SA 2.0, https://commons.wikimedia.org/w/index.php?curid=14423144
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.List.size() + 1), "Shopping", getString(R.string.drake_circus_name), getString(R.string.drakes_circus_street), getString(R.string.drake_circus_postcode), R.drawable.drake_circus, getString(R.string.drake_circus_details)));
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        mAdapter = new RecyclerViewAdapter((MainActivity) getActivity(), LocationContent.List);
        recyclerView.setAdapter(mAdapter);
    }


}