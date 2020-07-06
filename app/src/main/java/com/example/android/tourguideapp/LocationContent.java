package com.example.android.tourguideapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocationContent {
    public static final Map<String, LocationItem> LIST_ITEM_MAP = new HashMap<String, LocationItem>();
    public static final Map<String, LocationItem> FAVOURITES_ITEM_MAP = new HashMap<String, LocationItem>();
    static ArrayList<LocationItem> List = new ArrayList<>();
    static ArrayList<LocationItem> Favourites = new ArrayList<>();

    public static void addItemToList(LocationItem item) {
        if (!List.contains(item)) {
            List.add(item);
            LIST_ITEM_MAP.put(item.id, item);
        }

    }

    public static void addItemToFavourites(LocationItem item) {
        if (!Favourites.contains(item)) {
            Favourites.add(item);
            FAVOURITES_ITEM_MAP.put(item.id, item);
        }
    }

    /*static {
        for (int i = 1; i < COUNT; i++) {
            addItem(createLocationItem(i));
        }
    }



    private static LocationItem createLocationItem(int position) {
        //return new LocationItem(String.valueOf(position), "Location " +position, "Street "+position, "Postcode "+position,  makeDetails(position));
        return new LocationItem(String.valueOf(position), "Location " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Location: ").append(position);

        builder.append("\nMore detailed information here.");
        return builder.toString();
    }
*/
    public static class LocationItem {
        public final String id;
        public final String locationName;
        public final String locationStreetName;
        public final String locationPostcode;
        public final String details;

        public LocationItem(String id, String locationName, String locationStreetName, String locationPostcode, String details) {
            this.id = id;
            this.locationName = locationName;
            this.locationStreetName = locationStreetName;
            this.locationPostcode = locationPostcode;
            this.details = details;
        }


        @Override
        public String toString() {
            return locationName;
        }
    }
}
