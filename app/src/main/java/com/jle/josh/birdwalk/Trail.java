package com.jle.josh.birdwalk;

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
    private String birdText;

    // 0=regular, 1=loop, 2=area, 3=viewpoints, 4=trailhead, 5=drive
    private int typeCode;

    public Trail(String trailName, LatLng lotPoint, LatLng[] points, String length,
                 String iconName, String excName, String bgName, String address,
                 String birds, String habitats, int typeCode, String birdText){
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
        this.typeCode = typeCode;
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
    public int getTypeCode() {return typeCode;}
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

        public int compare(Trail t1, Trail t2) {
            Double trailLen1, trailLen2;


            if (t1.getLength().equals(""))
                trailLen1 = 0.0;
            else {
                String[] parts = t1.getLength().split(" ");
                trailLen1 = Double.parseDouble(parts[0]);
            }

            if (t2.getLength().equals(""))
                trailLen2 = 0.0;
            else {
                String[] parts = t2.getLength().split(" ");
                trailLen2 = Double.parseDouble(parts[0]);
            }


            //ascending order
            //return TrailLen1.compareTo(TrailLen2);
            //descending order
            return trailLen2.compareTo(trailLen1);
        }};



}













