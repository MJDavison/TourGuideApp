package com.example.android.tourguideapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), MainActivity.this);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        if (LocationContent.fullList.size() < 1) {
            createLocations();
            allocateLocationsToList();
        }

    }

    private void createLocations() {
        //By Chris Downer, CC BY-SA 2.0, https://commons.wikimedia.org/w/index.php?curid=3023918
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.fullList.size() + 1), "Historical Structure", getString(R.string.charles_church_name), getString(R.string.charles_church_street), getString(R.string.charles_church_postcode), R.drawable.charles_church_behinddrakescircus, getString(R.string.charles_church_details)));
        //By painma - Own work, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=40629939
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.fullList.size() + 1), "Entertainment", getString(R.string.theatre_royal_plymouth_name), getString(R.string.royal_parade_street), getString(R.string.theatre_royal_postcode), R.drawable.theatre_royal_plymouth, getString(R.string.theatre_royal_details)));
        // https://tudorrosetearooms.com/gallery/
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.fullList.size() + 1), "Restaurant", getString(R.string.the_tudor_rose_name), getString(R.string.the_tudor_rose_street), getString(R.string.the_tudor_rose_postcode), R.drawable.tudor_rose, getString(R.string.the_tudor_rose_details)));
        //By Tom Jolliffe, CC BY-SA 2.0, https://commons.wikimedia.org/w/index.php?curid=14423144
        LocationContent.addItemToList(new LocationContent.LocationItem(Integer.toString(LocationContent.fullList.size() + 1), "Shopping", getString(R.string.drake_circus_name), getString(R.string.drakes_circus_street), getString(R.string.drake_circus_postcode), R.drawable.drake_circus, getString(R.string.drake_circus_details)));
    }

    private void allocateLocationsToList() {
        for (int i = 0; i < LocationContent.fullList.size(); i++) {
            switch (LocationContent.fullList.get(i).mLocationType.toLowerCase()) {
                case "historical structure":
                    LocationContent.historical.add(LocationContent.fullList.get(i));
                    break;
                case "entertainment":
                    LocationContent.entertainment.add(LocationContent.fullList.get(i));
                    break;
                case "restaurant":
                    LocationContent.restaurant.add(LocationContent.fullList.get(i));
                    break;
                case "shopping":
                    LocationContent.shopping.add(LocationContent.fullList.get(i));
                    break;
            }

        }
    }
}