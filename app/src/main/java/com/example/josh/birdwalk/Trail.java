package com.example.josh.birdwalk;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Josh on 11/11/15.
 */
class Trail {

    public LatLng lotPoint;
    public LatLng[] points;
    public String distance;
    public String resName; //the name of the trailicon, and the excerpt file
    public String address;
    public String birds;
    public String habitats;

    public Trail(LatLng sLotPoint, LatLng[] sPoints, String sDistance, String sResName,
                 String sAddress, String sBirds, String sHabitats){
        lotPoint = sLotPoint;
        points = sPoints;
        distance = sDistance;
        resName = sResName;
        address = sAddress;
        birds = sBirds;
        habitats = sHabitats;
    }

    public LatLng getStart(){
        return points[0];
    }

    public Boolean lotIsStart() { return (lotPoint.equals(points[0]));}

}
