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
                return HistoricalFragment.TAB_NAME;
            case 1:
                return EntertainmentFragment.TAB_NAME;
            case 2:
                return RestaurantFragment.TAB_NAME;
            case 3:
                return ShoppingFragment.TAB_NAME;
            default:
                return FavouritesFragment.TAB_NAME;
        }
    }
}
