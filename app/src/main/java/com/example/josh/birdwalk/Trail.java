package com.example.josh.birdwalk;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Josh on 11/11/15.
 */
class Trail {

    public LatLng lotPoint;
    public LatLng[] points;
    public double distance;
    public String excName;
    public String address;
    public String birds;
    public String type;

    public Trail(LatLng sLotPoint, LatLng[] sPoints, double sDistance, String sExcName,
                 String sAddress, String sBirds, String sType){
        lotPoint = sLotPoint;
        points = sPoints;
        distance = sDistance;
        excName = sExcName;
        address = sAddress;
        birds = sBirds;
        type = sType;
    }

    public LatLng getStart(){
        return points[0];
    }

}
