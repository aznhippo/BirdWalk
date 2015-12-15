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
            new LatLng(38.587754, -121.420361),
    };

    static LatLng csuLot = new LatLng (38.559484, -121.419776);
    static LatLng[] csuPts = {
            new LatLng(38.559484, -121.419776),
    };

    static LatLng howeLot = new LatLng (38.559607, -121.406420);
    static LatLng[] howePts = {
            new LatLng(38.559607, -121.406420),
    };

    static LatLng wattLot = new LatLng (38.559607, -121.406420);
    static LatLng[] wattPts = {
            new LatLng(38.565895, -121.381673),
    };

    static LatLng gristLot = new LatLng (38.574271, -121.344872);
    static LatLng[] gristPts = {
            new LatLng(38.574271, -121.344872),
    };

    static LatLng willPondLot = new LatLng (38.545395, -121.507086);
    static LatLng[] willPondPts = {
            new LatLng(38.545395, -121.507086),
    };

    static LatLng riverBendLot = new LatLng (38.595127, -121.330402);
    static LatLng[] riverBendPts = {
            new LatLng(38.595127, -121.330402),
    };

    static LatLng effieLot = new LatLng (38.616771, -121.312577);
    static LatLng[] effiePts = {
            new LatLng(38.616771, -121.312577),
    };

    static LatLng rossmoorLot = new LatLng (38.624326, -121.301820);
    static LatLng[] rossmoorPts = {
            new LatLng(38.624326, -121.301820),
    };

    static LatLng barLot = new LatLng (38.633206, -121.286619);
    static LatLng[] barPts = {
            new LatLng(38.633206, -121.286619),
    };

    static LatLng lowSunriseLot = new LatLng (38.631875, -121.269982);
    static LatLng[] lowSunrisePts = {
            new LatLng(38.631875, -121.269982),
    };

    static LatLng sailorLot = new LatLng (38.634109, -121.233595);
    static LatLng[] sailorPts = {
            new LatLng(38.634109, -121.233595),
    };

    static LatLng upSunriseLot = new LatLng (38.635525, -121.264099);
    static LatLng[] upSunrisePts = {
            new LatLng(38.635525, -121.264099),
    };

    static LatLng nimbusLot = new LatLng (38.633617, -121.224062);
    static LatLng[] nimbusPts = {
            new LatLng(38.633617, -121.224062),
    };

    //done
    static LatLng purp1Lot = new LatLng (38.561816, -121.486343);
    static LatLng[] purp1Pts = { new LatLng(38.561816, -121.486343)};
    static LatLng purp2Lot = new LatLng (38.584245, -121.503890);
    static LatLng[] purp2Pts = { new LatLng(38.584245, -121.503890)};
    static LatLng purp3Lot = new LatLng (38.564447, -121.471494);
    static LatLng[] purp3Pts = { new LatLng(38.564447, -121.471494) };
    //

    static LatLng eastLawnLot = new LatLng (38.561201, -121.449865);
    static LatLng[] eastLawnPts = {
            new LatLng(38.561201, -121.449865),
    };

    static LatLng arcadeCollegeLot = new LatLng (38.652294, -121.344399);
    static LatLng[] arcadeCollegePts = {
            new LatLng(38.652294, -121.344399),
    };

    static LatLng arcadeArdenLot = new LatLng (38.656455, -121.335007);
    static LatLng[] arcadeArdenPts = {
            new LatLng(38.656455, -121.335007),
    };

    //done
    static LatLng swallows1Lot = new LatLng (38.525773, -121.521545);
    static LatLng[] swallows1Pts = { new LatLng(38.525773, -121.521545)};
    static LatLng swallows2Lot = new LatLng (38.523123, -121.521359);
    static LatLng[] swallows2Pts = { new LatLng(38.523123, -121.521359)};
    static LatLng swallows3Lot = new LatLng (38.516309, -121.522323);
    static LatLng[] swallows3Pts = { new LatLng(38.516309, -121.522323)};
    //

    static LatLng willParkLot = new LatLng (38.523094, -121.522252);
    static LatLng[] willParkPts = {
            new LatLng(38.523094, -121.522252),
    };

    static LatLng reichmuthLot = new LatLng (38.514887, -121.517806);
    static LatLng[] reichmuthPts = {
            new LatLng(38.514887, -121.517806),
    };

    static LatLng greenHavenLot = new LatLng (38.507404, -121.532512);
    static LatLng[] greenHavenPts = {
            new LatLng(38.507404, -121.532512),
    };

    static LatLng garciaLot = new LatLng (38.478730, -121.542698);
    static LatLng[] garciaPts = {
            new LatLng(38.478730, -121.542698),
    };

    static LatLng marriottLot = new LatLng (38.476954, -121.511721);
    static LatLng[] marriottPts = {
            new LatLng(38.476954, -121.511721),
    };

    static LatLng chorleyLot = new LatLng (38.497842, -121.492404);
    static LatLng[] chorleyPts = {
            new LatLng(38.497842, -121.492404),
    };

    static LatLng riversideLot = new LatLng (38.523094, -121.522252);
    static LatLng[] riversidePts = {
            new LatLng(38.523094, -121.522252),
    };



    public static final HashMap<String, Trail> trailHashMap = new HashMap<>();
    public static Trail getValue(String key) {
        return trailHashMap.get(key);
    }

    static {
        trailHashMap.put("Discovery Park",
                new Trail("Discovery Park",
                        discLot, discPts, "1.56 miles", "icon_disc", "disc", "disc",
                        "1000 Garden Hwy, Sacramento, CA",
                        "Yellow-billed Magpie, Western Bluebirds, Nesting Hawks",
                        "Streamside, Dense Shrubs, Riverside Woodlands, Water Features"));

        trailHashMap.put("Bushy Lake and the Cal Expo Floodplain",
                new Trail("Bushy Lake and the Cal Expo Floodplain",
                        bushyLot, bushyPts, "9.09 miles", "icon_bushy", "bushy", "bushy",
                        "Cal Expo Gate #13, Sacramento, CA",
                        "Nesting Great Horned Owls, Migrating Warblers, Wood Ducks",
                        "Riparian Vegetation, Water Features"));

        trailHashMap.put("California State University, Sacramento",
                new Trail("California State University, Sacramento",
                        csuLot,csuPts, "9.09 miles", "icon_csu", "csu", "csu",
                        "6000 J Street, Sacramento, CA",
                        "Seasonal Variety, Year-round White-tailed Kite",
                        "Streamside Woodlands, Hedges, Trees, Savannah"));

        trailHashMap.put("Howe Ave River Access",
                new Trail("Howe Ave River Access",
                        howeLot, howePts, "9.09 miles", "icon_howe", "howe_watt", "howe",
                        "The La Riviera Off-ramp to Entrance",
                        "Nesting Rough-Winged Swallows, Waterbirds",
                        "Riparian, Pond, Flooded Backwaters"));

        trailHashMap.put("Watt Ave River Access",
                new Trail("Watt Ave River Access",
                        wattLot, wattPts, "9.09 miles", "icon_watt", "howe_watt", "watt",
                        "Riviera Drive Off Watt Ave, Sacramento, CA",
                        "Wood Ducks, Belted Kingfishers, Green Herons, Black Phoebes",
                        "Cottonwood Stands, Riparian"));


        trailHashMap.put("Gristmill Recreation Area",
                new Trail("Gristmill Recreation Area",
                        gristLot, gristPts, "9.09 miles", "icon_grist", "grist", "grist",
                        "Mira Del Rio Dr., Sacramento, CA",
                        "Rarities, Small But Productive",
                        "Riparian, Willows, Cottonwoods, Other Trees"));

        trailHashMap.put("William B. Pond Recreation Area",
                new Trail("William B. Pond Recreation Area",
                        willPondLot, willPondPts, "9.09 miles", "icon_willpond", "willpond", "willpond",
                        "5700 Arden Way, Carmichael, CA",
                        "Great Blue Heron And Great Egret Nesting Rookery",
                        "Riparian, Riverine, Ponds, Grassland"));

        trailHashMap.put("River Bend Park",
                new Trail("River Bend Park",
                        riverBendLot, riverBendPts, "9.09 miles", "icon_riverbend", "riverbend", "riverbend",
                        "2300 Rod Beaudry Dr, Rancho Cordova, CA",
                        "Cliff Swallows Nests Under The Bike Bridge",
                        "Oak Woodlands, Riparian Woodlands, Riverine, Bridge"));

        trailHashMap.put("Effie Yeaw Nature Center",
                new Trail("Effie Yeaw Nature Center",
                        effieLot, effiePts, "9.09 miles", "icon_effie", "effie", "effie",
                        "6700 Tarshes Dr, Carmichael, CA",
                        "100+ Species Possible; Wild Turkeys",
                        "Riparian Woodlands, Riverine, Ponds, Grassland Open Areas"));

        trailHashMap.put("Rossmoor Bar",
                new Trail("Rossmoor Bar",
                        rossmoorLot, rossmoorPts, "9.09 miles", "icon_rossmoor", "rossmoor", "rossmoor",
                        "1949 Rossmoor Dr, Rancho Cordova, CA",
                        "Active Bank Swallow Colony On North Bank Of The River",
                        "Low Bluffs, Riverine, Riparian Shrub, Oak Woodlands"));

        trailHashMap.put("Sacramento Bar and Bannister Park",
                new Trail("Sacramento Bar and Bannister Park",
                        barLot, barPts, "9.09 miles", "icon_bar", "bar", "bar",
                        "3820 Bannister Rd, Fair Oaks, CA",
                        "Breeding Yellow-breasted Chats",
                        "Riparian, Riverine, Gravel Tailings, Ponds"));

        trailHashMap.put("Lower Sunrise Area",
                new Trail("Lower Sunrise Area",
                        lowSunriseLot, lowSunrisePts, "9.09 miles", "icon_sunrise", "lowsunrise", "lowsunrise",
                        "At End Of Riverlite Ct., Rancho Cordova, CA",
                        "Acorn Woodpeckers, Tree Swallows, Hawks, Osprey",
                        "Low Bluffs, Riverine, Riparian Shrub, Oak Woodlands"));

        trailHashMap.put("Sailor Bar",
                new Trail("Sailor Bar",
                        sailorLot, sailorPts, "9.09 miles", "icon_sailor", "sailor", "sailor",
                        "At End Of Illinois Ave., Sacramento, CA",
                        "Red-winged Blackbirds, Acorn Woodpeckers",
                        "Riparian, Woodland, Open Area, Gravel Tailings"));

        trailHashMap.put("Upper Sunrise",
                new Trail("Upper Sunrise",
                        upSunriseLot, upSunrisePts, "9.09 miles", "icon_sunrise", "upSunrise", "upSunrise",
                        "2001 Nimbus Rd, Gold River, CA",
                        "Barrow’s Goldeneye, Gulls",
                        "Rising Bluffs, Riverine, Riparian, Oaks, Toyon, Gray Pine"));

        trailHashMap.put("Nimbus Hatchery",
                new Trail("Nimbus Hatchery",
                        nimbusLot, nimbusPts, "9.09 miles", "icon_nimbus", "nimbus", "nimbus",
                        "2001 Nimbus Rd, Gold River, CA",
                        "Bald Eagle During Salmon Run",
                        "Rising Bluffs, Riverine, Riparian, Oaks, Toyon, Gray Pine"));

        trailHashMap.put("Purple Martins Site #1",
                new Trail("Purple Martins Site #1",
                        purp1Lot, purp1Pts, "n/a", "icon_purp", "purp", "purp",
                        "20th Street Between X And W Streets, Sacramento, CA",
                        "Purple Martins Migrating from South America for Winter",
                        "Weep Holes Under Freeway Overpasses"));

        trailHashMap.put("Purple Martins Site #2",
                new Trail("Purple Martins Site #2",
                        purp2Lot, purp2Pts, "n/a", "icon_purp", "purp", "purp",
                        "Old Town Sacramento, 125 I Street",
                        "Purple Martins Migrating from South America for Winter",
                        "Weep Holes Under Freeway Overpasses"));

        trailHashMap.put("Purple Martins Site #3",
                new Trail("Purple Martins Site #3",
                        purp3Lot, purp3Pts, "n/a", "icon_purp", "purp", "purp",
                        "29th and 30th Streets Between R and S Sts",
                        "Purple Martins Migrating from South America for Winter",
                        "Weep Holes Under Freeway Overpasses"));

        trailHashMap.put("East Lawn Cemetery",
                new Trail("East Lawn Cemetery",
                        eastLawnLot, eastLawnPts, "9.09 miles", "icon_eastlawn", "eastlawn", "eastlawn",
                        "4300 Folsom Boulevard, Sacramento, CA",
                        "Bushtits, Warblers, Robins, Flickers, Red-Tailed Hawk",
                        "Lawns, Tall Evergreens, Deciduous Trees, Shrubbery"));

        trailHashMap.put("Arcade Creek at American River College",
                new Trail("Arcade Creek at American River College",
                        arcadeCollegeLot, arcadeCollegePts, "9.09 miles", "icon_arcadeCollege", "arcade", "arcade",
                        "6377 Bonham Cir., Citrus Heights, CA ",
                        "Good Birding Anytime Of The Day",
                        "Creek, Mountain Migrants, Nesting Birds"));

        trailHashMap.put("Arcade Creek from Arden Creek Park",
                new Trail("Arcade Creek from Arden Creek Park",
                        arcadeArdenLot, arcadeArdenPts, "9.09 miles", "icon_arcadeArden", "arcade", "arcade",
                        "...",
                        "...",
                        "..."));

        trailHashMap.put("Rough Winged Swallows Site #1",
                new Trail("Rough Winged Swallows Site #1",
                        swallows1Lot, swallows1Pts, "n/a", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 and Seamas Blvd. Overpass",
                        "March-Summer, Nests In Weep Holes In The Overpass",
                        "Weep Holes On Overpass"));

        trailHashMap.put("Rough Winged Swallows Site #2",
                new Trail("Rough Winged Swallows Site #2",
                        swallows2Lot, swallows2Pts, "n/a", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 And 35th Avenue Overpass",
                        "March-Summer, Nests In Weep Holes In The Overpass",
                        "Weep Holes On Overpass"));

        trailHashMap.put("Rough Winged Swallows Site #3",
                new Trail("Rough Winged Swallows Site #3",
                        swallows3Lot, swallows3Pts, "n/a", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 And 43rd  Avenue Overpass",
                        "March-Summer, Nests In Weep Holes In The Overpass",
                        "Weep Holes On Overpass"));

        trailHashMap.put("William Land Park",
                new Trail("William Land Park",
                        willParkLot, willParkPts, "9.09 miles", "icon_willpark", "willpark", "willpark",
                        "3800 W Land Park Dr, Sacramento, CA",
                        "Bird “Panhandle”",
                        "Large Conifers, Shrubs, Mature Trees"));

        trailHashMap.put("Reichmuth Park",
                new Trail("Reichmuth Park",
                        reichmuthLot, reichmuthPts, "9.09 miles", "icon_reichmuth", "reichmuth", "reichmuth",
                        "6135 Gloria Dr. Sacramento, CA",
                        "Magnet For Migrating Land Birds, Hooded Orioles",
                        "Formerly An Oxbow, Swampy Wooded Area"));

        trailHashMap.put("Green Haven Lake",
                new Trail("Green Haven Lake",
                        greenHavenLot, greenHavenPts, "9.09 miles", "icon_greenhaven", "greenhaven", "greenhaven",
                        "Havenside Dr., Sacramento, CA",
                        "Access Sites Available",
                        "Shoreline, Lake"));

        trailHashMap.put("Garcia Bend",
                new Trail("Garcia Bend",
                        garciaLot, garciaPts, "9.09 miles", "icon_garcia", "garcia_marriott", "garcia",
                        "7654 Pocket Rd. Sacramento, CA",
                        "Migrating Landbirds, Caspian And Forster’s Terns",
                        "Riparian, Riverine"));

        trailHashMap.put("Marriott Park",
                new Trail("Marriott Park",
                        marriottLot, marriottPts, "9.09 miles", "icon_marriott", "garcia_marriott", "marriott",
                        "7658 El Douro Dr, Sacramento, CA",
                        "Migrating Warblers, Vireos, Tanagers",
                        "Large Valley Oaks"));

        trailHashMap.put("Chorley Park",
                new Trail("Chorley Park",
                        chorleyLot, chorleyPts, "9.09 miles", "icon_chorley", "chorley", "chorley",
                        "7000 20th Street, Sacramento, CA",
                        "Nature Area",
                        "Mowed Lawns, Willows and Cottonwoods"));

        trailHashMap.put("Riverside Trails",
                new Trail("Riverside Trails",
                        riversideLot, riversidePts, "9.09 miles", "icon_riverside", "riverside", "riverside",
                        "Park 0/1 mis. South 35th",
                        "Mew Gull in Winter",
                        "Riparian Habitat"));
    }


}