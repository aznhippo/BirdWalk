package com.example.josh.birdwalk;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Josh on 11/11/15.
 */
class Trail {

    public LatLng lotPoint;
    public LatLng[] points;
    public String excName;
    public String diff;
    public String birds;
    public String type;

    public Trail(LatLng sLotPoint, LatLng[] sPoints, String sExcName, String sDiff, String sBirds, String sType){
        lotPoint = sLotPoint;
        points = sPoints;
        excName = sExcName;
        diff = sDiff;
        birds = sBirds;
        type = sType;
    }

    public LatLng getStart(){
        return points[0];
    }

}
