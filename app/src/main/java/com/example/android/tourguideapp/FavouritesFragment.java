package com.example.android.tourguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


public class FavouritesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;


    public FavouritesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_favourite, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
        //   createLocations();

        return rootView;
    }

    /*private void createLocations() {
        addItemToFavourites(new LocationContent.LocationItem("1", getString(R.string.charles_church_name), getString(R.string.charles_church_street), getString(R.string.charles_church_postcode), getString(R.string.charles_church_details)));
        addItemToFavourites(new LocationContent.LocationItem("2", getString(R.string.theatre_royal_plymouth_name), getString(R.string.royal_parade_street), getString(R.string.theatre_royal_postcode), getString(R.string.theatre_royal_details)));
    }*/

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        mAdapter = new RecyclerViewAdapterFavourites((MainActivity) getActivity(), LocationContent.Favourites);
        recyclerView.setAdapter(mAdapter);
    }


}