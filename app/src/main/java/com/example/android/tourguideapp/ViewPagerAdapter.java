package com.example.android.tourguideapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HistoricalFragment();
            case 1:
                return new EntertainmentFragment();
            case 2:
                return new RestaurantFragment();
            case 3:
                return new ShoppingFragment();
            default:
                return new FavouritesFragment();

        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.historical_tab_label);
            case 1:
                return mContext.getString(R.string.entertainment_tab_label);
            case 2:
                return mContext.getString(R.string.restaurant_tab_label);
            case 3:
                return mContext.getString(R.string.shopping_tab_label);
            default:
                return mContext.getString(R.string.favourites_tab_label);
        }
    }
}
