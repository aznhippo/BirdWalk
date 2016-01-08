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
    private String length;
    private String iconName;
    private String excName;
    private String bgName;
    private String address;
    private String birds;
    private String habitats;
    private Boolean isArea;
    private Boolean isLoop;
    private String distAway;

    public Trail(String sTrailName, LatLng sLotPoint, LatLng[] sPoints, String sLength,
                 String sIconName, String sExcName, String sBgName, String sAddress,
                 String sBirds, String sHabitats, Boolean sIsArea, Boolean sIsLoop){
        trailName = sTrailName;
        lotPoint = sLotPoint;
        points = sPoints;
        length = sLength;
        iconName = sIconName;
        excName = sExcName;
        bgName = sBgName;
        address = sAddress;
        birds = sBirds;
        habitats = sHabitats;
        isArea = sIsArea;
        isLoop = sIsLoop;
    }

    public String getTrailName(){return trailName;}
    public LatLng getLotPoint() {return lotPoint;}
    public LatLng getStart(){return points[0];}
    public LatLng[] getPoints() {return points;}
    public Boolean lotIsStart() { return (lotPoint.equals(points[0]));}
    public String getLength() {return length;}
    public String getIconName() {return iconName;}
    public String getExcName() {return excName;}
    public String getBgName() {return bgName;}
    public String getAddress() {return address;}
    public String getBirds() {return birds;}
    public String getHabitats() {return habitats;}
    public Boolean isArea() {return isArea;}
    public Boolean isLoop() {return isLoop;}
    public void setDistAway(String dist) {distAway = dist;}
    public String getDistAway() {return distAway;}

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

    /*Comparator for sorting the list by Trail Length*/
    public static Comparator<Trail> TrailComparatorLength = new Comparator<Trail>() {

        public int compare(Trail s1, Trail s2) {
            String TrailLen1, TrailLen2;
            if (s1.getLength().equals("n/a"))
                TrailLen1 = "0.00";
            else
                TrailLen1 = s1.getLength();
            if (s2.getLength().equals("n/a"))
                TrailLen2 = "0.00";
            else
                TrailLen2 = s2.getLength();


            //ascending order
            //return TrailLen1.compareTo(TrailLen2);
            //descending order
            return TrailLen2.compareTo(TrailLen1);
        }};



}













