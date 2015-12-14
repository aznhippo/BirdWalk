package com.example.josh.birdwalk;

import com.google.android.gms.maps.model.LatLng;
import java.util.Comparator;

/**
 * Created by Josh on 11/11/15.
 */
class Trail {

    private String trailName;
    private LatLng lotPoint;
    private LatLng[] points;
    private String distance;
    private String iconName;
    private String resName;
    private String address;
    private String birds;
    private String habitats;

    public Trail(String sTrailName, LatLng sLotPoint, LatLng[] sPoints, String sDistance,
                 String sIconName, String sResName, String sAddress, String sBirds, String sHabitats){
        trailName = sTrailName;
        lotPoint = sLotPoint;
        points = sPoints;
        distance = sDistance;
        iconName = sIconName;
        resName = sResName;
        address = sAddress;
        birds = sBirds;
        habitats = sHabitats;
    }

    public String getTrailName(){return trailName;}
    public LatLng getLotPoint() {return lotPoint;}
    public LatLng getStart(){return points[0];}
    public LatLng[] getPoints() {return points;}
    public Boolean lotIsStart() { return (lotPoint.equals(points[0]));}
    public String getDistance() {return distance;}
    public String getIconName() {return iconName;}
    public String getResName() {return resName;}
    public String getAddress() {return address;}
    public String getBirds() {return birds;}
    public String getHabitats() {return habitats;}

    /*Comparator for sorting the list by Trail Name*/
    public static Comparator<Trail> TrailComparatorName = new Comparator<Trail>() {

        public int compare(Trail s1, Trail s2) {
            String TrailName1 = s1.getTrailName().toUpperCase();
            String TrailName2 = s2.getTrailName().toUpperCase();

            //ascending order
            return TrailName1.compareTo(TrailName2);

            //descending order
            //return TrailName2.compareTo(TrailName1);
        }};

    /*Comparator for sorting the list by Trail Distance*/
    public static Comparator<Trail> TrailComparatorDist = new Comparator<Trail>() {

        public int compare(Trail s1, Trail s2) {
            String TrailDist1 = s1.getDistance();
            String TrailDist2 = s2.getDistance();

            //ascending order
            return TrailDist1.compareTo(TrailDist2);

            //descending order
            //return TrailName2.compareTo(TrailName1);
        }};

}













