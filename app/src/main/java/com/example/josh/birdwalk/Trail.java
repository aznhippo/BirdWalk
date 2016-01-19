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
    private String length, iconName, excName, bgName, address, birds, habitats;
    private Boolean isArea, isLoop;
    private String birdText;

    public Trail(String trailName, LatLng lotPoint, LatLng[] points, String length,
                 String iconName, String excName, String bgName, String address,
                 String birds, String habitats, Boolean isArea, Boolean isLoop, String birdText){
        this.trailName = trailName;
        this.lotPoint = lotPoint;
        this.points = points;
        this.length = length;
        this.iconName = iconName;
        this.excName = excName;
        this.bgName = bgName;
        this.address = address;
        this.birds = birds;
        this.habitats = habitats;
        this.isArea = isArea;
        this.isLoop = isLoop;
        this.birdText = birdText;
    }

    public String getTrailName(){return trailName;}
    public LatLng getLotPoint() {return lotPoint;}
    public LatLng getStart(){return points[0];}
    public LatLng[] getPoints() {return points;}
    public int numPoints() {return points.length;}
    public Boolean singlePoint() {return points.length==1;}
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
    public String birdText() {return birdText;}

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













