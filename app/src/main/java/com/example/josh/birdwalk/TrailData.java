package com.example.josh.birdwalk;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by Josh on 11/4/15.
 */

public class TrailData {
    private static TrailData ourInstance = new TrailData();

    public static TrailData getInstance() {
        return ourInstance;
    }

    private TrailData() { }

    static LatLng discLot = new LatLng (38.605124, -121.500527);
    static LatLng[] discPts = {
            new LatLng(38.6068861, -121.5019278),
            new LatLng(38.60690, -121.501597),
            new LatLng(38.606974,-121.501121),
            new LatLng(38.607247,-121.498148),
            new LatLng(38.6073472,-121.496944),
            new LatLng(38.607571,-121.494568),
            new LatLng(38.607636,-121.493453),
            new LatLng(38.6077389, -121.4925333),
            new LatLng(38.6077944, -121.491556),
            new LatLng(38.6077583, -121.4908250),
            new LatLng(38.607657,-121.4912681),
            new LatLng(38.607222,-121.491971),
            new LatLng(38.606665,-121.492461),
            new LatLng(38.6062361, -121.4925917),
            new LatLng(38.605575,-121.492591),
            new LatLng(38.605149,-121.492525),
            new LatLng(38.6043583, -121.4924861),
            new LatLng(38.604279,-121.492588),
            new LatLng(38.604233,-121.493102),
            new LatLng(38.604167,-121.493731),
            new LatLng(38.604006,-121.494792),
            new LatLng(38.603880,-121.495589),
            new LatLng(38.6035028, -121.496058),
            new LatLng(38.603789,-121.496810),
            new LatLng(38.604196,-121.497154),
            new LatLng(38.604546,-121.497508),
            new LatLng(38.6047917, -121.4978500),
            new LatLng(38.6047472, -121.4995528),
            new LatLng(38.6048194, -121.5012778),
            new LatLng(38.6057139, -121.5017028),
            new LatLng(38.606765,-121.501639),
            new LatLng(38.60690, -121.501597)
    };

    static LatLng bushyLot = new LatLng (38.587754, -121.420361);
    static LatLng[] bushyPts = {
            new LatLng(38.587754, -121.420361), new LatLng(38.6067917, -121.50165),
    };
    static LatLng csuLot = new LatLng (38.560453, -121.420846);
    static LatLng[] csuPts = {
            new LatLng(38.560453, -121.420846), new LatLng(38.6067917, -121.50165),
    };
    static LatLng howeLot = new LatLng (38.559607, -121.406420);
    static LatLng[] howePts = {
            new LatLng(38.559607, -121.406420), new LatLng(38.6067917, -121.50165),
    };
    static LatLng gristLot = new LatLng (38.574271, -121.344872);
    static LatLng[] gristPts = {
            new LatLng(38.574271, -121.344872), new LatLng(38.6067917, -121.50165),
    };
    static LatLng willLot = new LatLng (38.592002, -121.334241);
    static LatLng[] willPts = {
            new LatLng(38.592002, -121.334241), new LatLng(38.6067917, -121.50165),
    };
    static LatLng riverBendLot = new LatLng (38.595127, -121.330402);
    static LatLng[] riverBendPts = {
            new LatLng(38.595127, -121.330402), new LatLng(38.6067917, -121.50165),
    };
    static LatLng effieLot = new LatLng (38.616771, -121.312577);
    static LatLng[] effiePts = {
            new LatLng(38.616771, -121.312577), new LatLng(38.6067917, -121.50165),
    };
    static LatLng rossmoorLot = new LatLng (38.624326, -121.301820);
    static LatLng[] rossmoorPts = {
            new LatLng(38.624326, -121.301820), new LatLng(38.6067917, -121.50165),
    };
    static LatLng barBannisterLot = new LatLng (38.633206, -121.286619);
    static LatLng[] barBannisterPts = {
            new LatLng(38.633206, -121.286619), new LatLng(38.6067917, -121.50165),
    };
    static LatLng lowSunriseLot = new LatLng (38.631875, -121.269982);
    static LatLng[] lowSunrisePts = {
            new LatLng(38.631875, -121.269982), new LatLng(38.6067917, -121.50165),
    };
    static LatLng sailorLot = new LatLng (38.634109, -121.233595);
    static LatLng[] sailorPts = {
            new LatLng(38.634109, -121.233595), new LatLng(38.6067917, -121.50165),
    };
    static LatLng upperSunriseLot = new LatLng (38.635525, -121.264099);
    static LatLng[] upperSunrisePts = {
            new LatLng(38.635525, -121.264099), new LatLng(38.6067917, -121.50165),
    };
    static LatLng nimbusLot = new LatLng (38.633617, -121.224062);
    static LatLng[] nimbusPts = {
            new LatLng(38.633617, -121.224062), new LatLng(38.6067917, -121.50165),
    };
    static LatLng purp1Lot = new LatLng (38.561816, -121.486343);
    static LatLng[] purp1Pts = {
            new LatLng(38.561816, -121.486343), new LatLng(38.6067917, -121.50165),
    };
    static LatLng purp2Lot = new LatLng (38.584245, -121.503890);
    static LatLng[] purp2Pts = {
            new LatLng(38.584245, -121.503890), new LatLng(38.6067917, -121.50165),
    };
    static LatLng purp3Lot = new LatLng (38.564447, -121.471494);
    static LatLng[] purp3Pts = {
            new LatLng(38.564447, -121.471494), new LatLng(38.6067917, -121.50165),
    };
    static LatLng eastLawnLot = new LatLng (38.561201, -121.449865);
    static LatLng[] eastLawnPts = {
            new LatLng(38.561201, -121.449865), new LatLng(38.6067917, -121.50165),
    };
    static LatLng arcadeCollegeLot = new LatLng (38.652294, -121.344399);
    static LatLng[] arcadeCollegePts = {
            new LatLng(38.652294, -121.344399), new LatLng(38.6067917, -121.50165),
    };
    static LatLng arcadeArdenLot = new LatLng (38.656455, -121.335007);
    static LatLng[] arcadeArdenPts = {
            new LatLng(38.656455, -121.335007), new LatLng(38.6067917, -121.50165),
    };
    static LatLng swallows1Lot = new LatLng (38.525773, -121.521545);
    static LatLng[] swallows1Pts = {
            new LatLng(38.525773, -121.521545), new LatLng(38.6067917, -121.50165),
    };
    static LatLng swallows2Lot = new LatLng (38.523123, -121.521359);
    static LatLng[] swallows2Pts = {
            new LatLng(38.523123, -121.521359), new LatLng(38.6067917, -121.50165),
    };
    static LatLng swallows3Lot = new LatLng (38.516309, -121.522323);
    static LatLng[] swallows3Pts = {
            new LatLng(38.516309, -121.522323), new LatLng(38.6067917, -121.50165),
    };
    static LatLng williamParkLot = new LatLng (38.523094, -121.522252);
    static LatLng[] williamParkPts = {
            new LatLng(38.523094, -121.522252), new LatLng(38.6067917, -121.50165),
    };
    static LatLng reichmuthLot = new LatLng (38.514887, -121.517806);
    static LatLng[] reichmuthPts = {
            new LatLng(38.514887, -121.517806), new LatLng(38.6067917, -121.50165),
    };
    static LatLng greenHavenLot = new LatLng (38.507404, -121.532512);
    static LatLng[] greenHavenPts = {
            new LatLng(38.507404, -121.532512), new LatLng(38.6067917, -121.50165),
    };
    static LatLng garciaBendLot = new LatLng (38.478730, -121.542698);
    static LatLng[] garciaBendPts = {
            new LatLng(38.478730, -121.542698), new LatLng(38.6067917, -121.50165),
    };
    static LatLng marriottLot = new LatLng (38.476954, -121.511721);
    static LatLng[] marriottPts = {
            new LatLng(38.476954, -121.511721), new LatLng(38.6067917, -121.50165),
    };
    static LatLng chorleyLot = new LatLng (38.497842, -121.492404);
    static LatLng[] chorleyPts = {
            new LatLng(38.497842, -121.492404), new LatLng(38.6067917, -121.50165),
    };



    public static final HashMap<String, Trail> trailHashMap = new HashMap<>();
    public static Trail getValue(String key) {
        return trailHashMap.get(key);
    }

    static {
        trailHashMap.put("Discovery Park",
                new Trail(discLot, discPts, "disc", "...", "..."));
        trailHashMap.put("Bushy Lake and the Cal Expo Floodplain",
                new Trail(bushyLot, bushyPts, "bushy", "...", "..."));
        trailHashMap.put("California State University",
                new Trail(csuLot,csuPts, "csu", "...", "..."));
        trailHashMap.put("Howe and Watt Accesses",
                new Trail(howeLot, howePts, "howe", "...", "..."));
        trailHashMap.put("Gristmill Recreation Area",
                new Trail(gristLot, gristPts, "grist", "...", "..."));
        trailHashMap.put("William B. Pond Recreation Area",
                new Trail(willLot, willPts, "will", "...", "..."));
        trailHashMap.put("River Bend Park",
                new Trail(riverBendLot, riverBendPts, "riverBend", "...", "..."));
        trailHashMap.put("Effie Yeaw Nature Center",
                new Trail(effieLot, effiePts, "effie", "...", "..."));
        trailHashMap.put("Rossmoor Bar",
                new Trail(rossmoorLot, rossmoorPts, "rossmoor", "...", "..."));
        trailHashMap.put("Sacramento Bar and Bannister Park",
                new Trail(barBannisterLot, barBannisterPts, "barBannister", "...", "..."));
        trailHashMap.put("Lower Sunrise Area",
                new Trail(lowSunriseLot, lowSunrisePts, "lowSunrise", "...", "..."));
        trailHashMap.put("Sailor Bar",
                new Trail(sailorLot, sailorPts, "sailor", "...", "..."));
        trailHashMap.put("Upper Sunrise",
                new Trail(upperSunriseLot, upperSunrisePts, "upperSunrise", "...", "..."));
        trailHashMap.put("Nimbus Hatchery",
                new Trail(nimbusLot, nimbusPts, "nimbus", "...", "..."));
        trailHashMap.put("Purple Martins site #1",
                new Trail(purp1Lot, purp1Pts, "purp1", "...", "..."));
        trailHashMap.put("Purple Martins Site #2",
                new Trail(purp2Lot, purp2Pts, "purp2", "...", "..."));
        trailHashMap.put("Purple Martins Site #3",
                new Trail(purp3Lot, purp3Pts, "purp3", "...", "..."));
        trailHashMap.put("East Lawn Park",
                new Trail(eastLawnLot, eastLawnPts, "eastLawn", "...", "..."));
        trailHashMap.put("Arcade Creek at American River College",
                new Trail(arcadeCollegeLot, arcadeCollegePts, "arcadeCollege", "...", "..."));
        trailHashMap.put("Arcade Creek from Arden Creek Park",
                new Trail(arcadeArdenLot, arcadeArdenPts, "arcadeArden", "...", "..."));
        trailHashMap.put("Rough Winged Swallows Site #1",
                new Trail(swallows1Lot, swallows1Pts, "swallows1", "...", "..."));
        trailHashMap.put("Rough Winged Swallows Site #2",
                new Trail(swallows2Lot, swallows2Pts, "swallows2", "...", "..."));
        trailHashMap.put("Rough Winged Swallows Site #3",
                new Trail(swallows3Lot, swallows3Pts, "swallows3", "...", "..."));
        trailHashMap.put("William Land Park",
                new Trail(williamParkLot, williamParkPts, "williamPark", "...", "..."));
        trailHashMap.put("Reichmuth Park",
                new Trail(reichmuthLot, reichmuthPts, "reichmuth", "...", "..."));
        trailHashMap.put("Green Haven Lake",
                new Trail(greenHavenLot, greenHavenPts, "greenHaven", "...", "..."));
        trailHashMap.put("Garcia Bend",
                new Trail(garciaBendLot, garciaBendPts, "garciaBend", "...", "..."));
        trailHashMap.put("Marriott Park",
                new Trail(marriottLot, marriottPts, "marriott", "...", "..."));
        trailHashMap.put("Chorley Park",
                new Trail(chorleyLot, chorleyPts, "chorley", "...", "..."));
    }


}
