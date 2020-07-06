package com.example.android.tourguideapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.android.tourguideapp.LocationContent.addItemToFavourites;


public class LocationDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private static final String LOG_TAG = LocationDetailFragment.class.getSimpleName();
    FloatingActionButton fab;
    private LocationContent.LocationItem mItem;

    public LocationDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = LocationContent.LIST_ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.locationName);
            }
            fab = activity.findViewById(R.id.fab);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.location_detail)).setText(mItem.details);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToFavourites(mItem);
            }
        });
        return rootView;
    }
}