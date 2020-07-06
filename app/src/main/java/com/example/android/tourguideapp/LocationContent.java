package com.example.android.tourguideapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocationContent {
    public static final Map<String, LocationItem> ITEM_MAP = new HashMap<String, LocationItem>();
    static final int COUNT = 9;
    static ArrayList<LocationItem> ITEMS = new ArrayList<>();

    static {
        for (int i = 1; i < COUNT; i++) {
            addItem(createLocationItem(i));
        }
    }

    private static void addItem(LocationItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
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

    public static class LocationItem {
        public final String id;
        public final String content;
        //public final String locationName;
        //public final String locationStreetName;
        //public final String locationPostcode;
        public final String details;

        /*public LocationItem(String id, String locationName, String locationStreetName, String locationPostcode, String details) {
            this.id = id;
            this.locationName = locationName;
            this.locationStreetName = locationStreetName;
            this.locationPostcode = locationPostcode;
            this.details = details;
        }*/

        public LocationItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
