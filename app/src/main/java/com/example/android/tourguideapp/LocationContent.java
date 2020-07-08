package com.example.android.tourguideapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocationContent {
    public static final Map<String, LocationItem> LIST_ITEM_MAP = new HashMap<String, LocationItem>();
    public static final Map<String, LocationItem> FAVOURITES_ITEM_MAP = new HashMap<String, LocationItem>();
    static ArrayList<LocationItem> fullList = new ArrayList<>();

    static ArrayList<LocationItem> historical = new ArrayList<>();
    static ArrayList<LocationItem> entertainment = new ArrayList<>();
    static ArrayList<LocationItem> restaurant = new ArrayList<>();
    static ArrayList<LocationItem> shopping = new ArrayList<>();

    static ArrayList<LocationItem> Favourites = new ArrayList<>();

    public static void addItemToList(LocationItem item) {
        if (!fullList.contains(item)) {
            fullList.add(item);
            LIST_ITEM_MAP.put(item.mID, item);
        }
    }

    public static void addItemToFavourites(LocationItem item) {
        if (!Favourites.contains(item)) {
            Favourites.add(item);
            FAVOURITES_ITEM_MAP.put(item.mID, item);
        }
    }

    public static void removeItemFromFavourites(LocationItem item) {
        if (Favourites.contains(item)) {
            Favourites.remove(item);
            FAVOURITES_ITEM_MAP.remove(item.mID);
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
        public final String mID;
        public final String mLocationType;
        public final String mLocationName;
        public final String mLocationStreetName;
        public final String mLocationPostcode;
        public final int mLocationImage;
        public final String mDetails;
        private boolean isFavourite = false;

        public LocationItem(String id, String locationType, String locationName, String locationStreetName, String locationPostcode, int locationImage, String details) {
            this.mID = id;
            this.mLocationType = locationType;
            this.mLocationName = locationName;
            this.mLocationStreetName = locationStreetName;
            this.mLocationPostcode = locationPostcode;
            this.mLocationImage = locationImage;
            this.mDetails = details;
        }

        public boolean isFavourite() {
            return isFavourite;
        }

        public void setFavourite(boolean favourite) {
            isFavourite = favourite;
        }

        @Override
        public String toString() {
            return mLocationName;
        }
    }
}
