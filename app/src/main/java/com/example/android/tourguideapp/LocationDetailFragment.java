package com.example.android.tourguideapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;




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

                appBarLayout.setTitle(mItem.mLocationType);
            }
            fab = activity.findViewById(R.id.fab);
            if (mItem.isFavourite() == true)
                fab.setImageResource(R.drawable.ic_favorite);
            else
                fab.setImageResource(R.drawable.ic_unfavourite);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.location_name)).setText(mItem.mLocationName);
            ((ImageView) rootView.findViewById(R.id.location_detail_image)).setImageResource(mItem.mLocationImage);
            ((TextView) rootView.findViewById(R.id.location_location)).setText(mItem.mLocationStreetName + " - " + mItem.mLocationPostcode);
            ((TextView) rootView.findViewById(R.id.location_detail_text)).setText(mItem.mDetails);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mItem.isFavourite()) {
                    LocationContent.addItemToFavourites(mItem);
                    fab.setImageResource(R.drawable.ic_favorite);
                    mItem.setFavourite(true);
                } else {
                    LocationContent.removeItemFromFavourites(mItem);
                    fab.setImageResource(R.drawable.ic_unfavourite);
                    mItem.setFavourite(false);
                }

            }
        });
        return rootView;
    }
}