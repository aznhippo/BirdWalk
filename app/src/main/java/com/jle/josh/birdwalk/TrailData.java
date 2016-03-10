package com.jle.josh.birdwalk;

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


    public static final HashMap<String, Trail> trailHashMap = new HashMap<>();
    public static Trail getValue(String key) {
        return trailHashMap.get(key);
    }

    static {
        trailHashMap.put("Discovery Park",
                new Trail("Discovery Park",
                        TrailCoords.discLot, TrailCoords.discPts, "1.56 miles", "icon_disc", "disc", "disc",
                        "1000 Garden Hwy, Sacramento, CA",
                        "Yellow-billed Magpie, Western Bluebirds, Nesting Hawks",
                        "Streamside, Dense Shrubs, Riverside Woodlands, Water Features",
                        false, true, TrailBirds.disc));

        trailHashMap.put("Bushy Lake and the Cal Expo Floodplain",
                new Trail("Bushy Lake and the Cal Expo Floodplain",
                        TrailCoords.bushyLot, TrailCoords.bushyPts, "3.19 miles", "icon_bushy", "bushy", "bushy",
                        "Cal Expo Gate #13, Sacramento, CA",
                        "Nesting Great Horned Owls, Migrating Warblers, Wood Ducks",
                        "Riparian Vegetation, Water Features",
                        false, true, TrailBirds.bushy));

        trailHashMap.put("California State University, Sacramento",
                new Trail("California State University, Sacramento",
                        TrailCoords.csuLot,TrailCoords.csuPts, "0.01 miles\u00b2", "icon_csu", "csu", "csu",
                        "6000 J Street, Sacramento, CA",
                        "Seasonal Variety, Year-round White-tailed Kite",
                        "Streamside Woodlands, Hedges, Trees, Savannah",
                        true, false, TrailBirds.csu));

        trailHashMap.put("Howe Ave River Access",
                new Trail("Howe Ave River Access",
                        TrailCoords2.howeLot, TrailCoords2.howePts, "1.81 miles", "icon_howe", "howe_watt", "howe",
                        "The La Riviera Off-ramp to Entrance",
                        "Nesting Rough-Winged Swallows, Waterbirds",
                        "Riparian, Pond, Flooded Backwaters",
                        false, true, TrailBirds.howe));

        trailHashMap.put("Watt Ave River Access",
                new Trail("Watt Ave River Access",
                        TrailCoords2.wattLot, TrailCoords2.wattPts, "1.64 miles ", "icon_watt", "howe_watt", "watt",
                        "Riviera Drive Off Watt Ave, Sacramento, CA",
                        "Wood Ducks, Belted Kingfishers, Green Herons, Black Phoebes",
                        "Cottonwood Stands, Riparian",
                        false, false, TrailBirds.watt));

        trailHashMap.put("Gristmill Recreation Area",
                new Trail("Gristmill Recreation Area",
                        TrailCoords.gristLot, TrailCoords.gristPts, "1.47 miles", "icon_grist", "grist", "grist",
                        "Mira Del Rio Dr., Sacramento, CA",
                        "Rarities; Eastern Wood Pewee, Red-eyed vireo, Warblers",
                        "Riparian, Willows, Cottonwoods, Other Trees",
                        false, false, TrailBirds.gristmill));

        trailHashMap.put("William B. Pond Recreation Area",
                new Trail("William B. Pond Recreation Area",
                        TrailCoords.willPondLot, TrailCoords.willPondPts, "2.17 miles", "icon_willpond", "willpond", "willpond",
                        "5700 Arden Way, Carmichael, CA",
                        "Great Blue Heron And Great Egret Nesting Rookery",
                        "Riparian, Riverine, Ponds, Grassland",
                        false, true, TrailBirds.willpond));

        trailHashMap.put("River Bend Park",
                new Trail("River Bend Park",
                        TrailCoords.riverBendLot, TrailCoords.riverBendPts, "1.69 miles", "icon_riverbend", "riverbend", "riverbend",
                        "2300 Rod Beaudry Dr, Rancho Cordova, CA",
                        "Cliff Swallows Nests Under The Bike Bridge",
                        "Oak Woodlands, Riparian Woodlands, Riverine, Bridge",
                        false, true, TrailBirds.riverbend));

        trailHashMap.put("Effie Yeaw Nature Center",
                new Trail("Effie Yeaw Nature Center",
                        TrailCoords.effieLot, TrailCoords.effiePts, "3.84 miles", "icon_effie", "effie", "effie",
                        "6700 Tarshes Dr, Carmichael, CA",
                        "100+ Species Possible; Wild Turkeys",
                        "Riparian Woodlands, Riverine, Ponds, Grassland Open Areas",
                        false, true, TrailBirds.effie));

        trailHashMap.put("Rossmoor Bar",
                new Trail("Rossmoor Bar",
                        TrailCoords.rossmoorLot, TrailCoords.rossmoorPts, "2.02 miles", "icon_rossmoor", "rossmoor", "rossmoor",
                        "1949 Rossmoor Dr, Rancho Cordova, CA",
                        "Active Bank Swallow Colony On North Bank Of The River",
                        "Low Bluffs, Riverine, Riparian Shrub, Oak Woodlands",
                        false, true, TrailBirds.rossmoor));

        trailHashMap.put("Sacramento Bar and Bannister Park",
                new Trail("Sacramento Bar and Bannister Park",
                        TrailCoords.barLot, TrailCoords.barPts, "2.63 miles", "icon_bar", "bar", "bar",
                        "3820 Bannister Rd, Fair Oaks, CA",
                        "Breeding Yellow-breasted Chats",
                        "Riparian, Riverine, Gravel Tailings, Ponds",
                        false, true, TrailBirds.bar));

        trailHashMap.put("Lower Sunrise Area",
                new Trail("Lower Sunrise Area",
                        TrailCoords.lowSunriseLot, TrailCoords.lowSunrisePts, "2.66 miles", "icon_sunrise", "lowsunrise", "lowsunrise",
                        "At End Of Riverlite Ct., Rancho Cordova, CA",
                        "Acorn Woodpeckers, Tree Swallows, Hawks, Osprey",
                        "Low Bluffs, Riverine, Riparian Shrub, Oak Woodlands",
                        false, true, TrailBirds.lowsunrise));

        trailHashMap.put("Sailor Bar",
                new Trail("Sailor Bar",
                        TrailCoords.sailorLot, TrailCoords.sailorPts, "3.3 miles", "icon_sailor", "sailor", "sailor",
                        "At End Of Illinois Ave., Sacramento, CA",
                        "Red-winged Blackbirds, Acorn Woodpeckers",
                        "Riparian, Woodland, Open Area, Gravel Tailings",
                        false, true, TrailBirds.sailor));

        trailHashMap.put("Upper Sunrise",
                new Trail("Upper Sunrise",
                        TrailCoords.upSunriseLot, TrailCoords.upSunrisePts, "3.35 miles", "icon_sunrise", "upsunrise", "upsunrise",
                        "2001 Nimbus Rd, Gold River, CA",
                        "Barrow’s Goldeneye, Gulls",
                        "Rising Bluffs, Riverine, Riparian, Oaks, Toyon, Gray Pine",
                        false, false, TrailBirds.upper_nimbus));

        trailHashMap.put("Nimbus Hatchery",
                new Trail("Nimbus Hatchery",
                        TrailCoords.nimbusLot, TrailCoords.nimbusPts, "2.6 miles", "icon_nimbus", "nimbus", "nimbus",
                        "2001 Nimbus Rd, Gold River, CA",
                        "Bald Eagle During Salmon Run",
                        "Rising Bluffs, Riverine, Riparian, Oaks, Toyon, Gray Pine",
                        false, false, TrailBirds.upper_nimbus));

        trailHashMap.put("Purple Martins Site #1",
                new Trail("Purple Martins Site #1",
                        TrailCoords.purp1Lot, TrailCoords.purp1Pts, "", "icon_purp", "purp", "purp",
                        "20th Street Between X And W Streets, Sacramento, CA",
                        "Purple Martins Nesting",
                        "Weep Holes Under Freeway Overpasses",
                        false, false, TrailBirds.purp));

        trailHashMap.put("Purple Martins Site #2",
                new Trail("Purple Martins Site #2",
                        TrailCoords.purp2Lot, TrailCoords.purp2Pts, "0.08 miles", "icon_purp", "purp", "purp",
                        "Old Town Sacramento, 125 I Street",
                        "Purple Martins Nesting",
                        "Weep Holes Under Freeway Overpasses",
                        false, false, TrailBirds.purp));

        trailHashMap.put("Purple Martins Site #3",
                new Trail("Purple Martins Site #3",
                        TrailCoords.purp3Lot, TrailCoords.purp3Pts, "", "icon_purp", "purp", "purp",
                        "29th and 30th Streets Between R and S Sts",
                        "Purple Martins Nesting",
                        "Weep Holes Under Freeway Overpasses",
                        false, false, TrailBirds.purp));

        trailHashMap.put("East Lawn Cemetery",
                new Trail("East Lawn Cemetery",
                        TrailCoords.eastLawnLot, TrailCoords.eastLawnPts, "1.03 miles", "icon_eastlawn", "eastlawn", "eastlawn",
                        "4300 Folsom Boulevard, Sacramento, CA",
                        "Bushtits, Warblers, Robins, Flickers, Red-Tailed Hawk",
                        "Lawns, Tall Evergreens, Deciduous Trees, Shrubbery",
                        false, false, TrailBirds.eastlawn));

        trailHashMap.put("Arcade Creek at American River College",
                new Trail("Arcade Creek at American River College",
                        TrailCoords.arcadeCollegeLot, TrailCoords.arcadeCollegePts, "0.67 miles", "icon_arcadecollege", "arcade", "arcadecollege",
                        "4700 College Oak Dr, Sacramento, CA ",
                        "Riparian Trees",
                        "Creek, Mountain Migrants, Nesting Birds",
                        false, false, TrailBirds.arcade));

        trailHashMap.put("Arcade Creek from Arden Creek Park",
                new Trail("Arcade Creek from Arden Creek Park",
                        TrailCoords.arcadeArdenLot, TrailCoords.arcadeArdenPts, "0.67 miles", "icon_arcadearden", "arcade", "arcadearden",
                        "5613 Omni Drive, Sacramento",
                        "Mountain Migrants Nesting",
                        "Riparian Trees",
                        false, false, TrailBirds.arcade));

        trailHashMap.put("Rough Winged Swallows Site #1",
                new Trail("Rough Winged Swallows Site #1",
                        TrailCoords.swallows1Lot, TrailCoords.swallows1Pts, "", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 and Seamas Blvd. Overpass",
                        "Rough-winged Swallows Nesting ",
                        "Weep Holes On Overpass",
                        false, false, TrailBirds.swallows));

        trailHashMap.put("Rough Winged Swallows Site #2",
                new Trail("Rough Winged Swallows Site #2",
                        TrailCoords.swallows2Lot, TrailCoords.swallows2Pts, "", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 And 35th Avenue Overpass",
                        "Rough-winged Swallows Nesting ",
                        "Weep Holes On Overpass",
                        false, false, TrailBirds.swallows));

        trailHashMap.put("Rough Winged Swallows Site #3",
                new Trail("Rough Winged Swallows Site #3",
                        TrailCoords.swallows3Lot, TrailCoords.swallows3Pts, "", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 And 43rd Avenue Overpass",
                        "Rough-winged Swallows Nesting ",
                        "Weep Holes On Overpass",
                        false, false, TrailBirds.swallows));

        trailHashMap.put("William Land Park",
                new Trail("William Land Park",
                        TrailCoords.willParkLot, TrailCoords.willParkPts, "0.04 miles\u00b2", "icon_willpark", "willpark", "willpark",
                        "3800 W Land Park Dr, Sacramento, CA",
                        "Bird “Panhandle”",
                        "Large Conifers, Shrubs, Mature Trees",
                        true, false, TrailBirds.willpark));

        trailHashMap.put("Reichmuth Park",
                new Trail("Reichmuth Park",
                        TrailCoords.reichmuthLot, TrailCoords.reichmuthPts, "0.03 miles\u00b2", "icon_reichmuth", "reichmuth", "reichmuth",
                        "6135 Gloria Dr. Sacramento, CA",
                        "Migrating Land Birds, Hooded Orioles",
                        "Formerly An Oxbow, Swampy Wooded Area",
                        true, false, TrailBirds.reichmuth));

        trailHashMap.put("Green Haven Lake",
                new Trail("Green Haven Lake",
                        TrailCoords.greenHavenLot, TrailCoords.greenHavenPts, "", "icon_greenhaven", "greenhaven", "greenhaven",
                        "Havenside Dr., Sacramento, CA",
                        "Mergansers, Cormorants, Gulls, Ducks",
                        "Views of Shoreline, Lake",
                        false, false, TrailBirds.greenhaven));

        trailHashMap.put("Garcia Bend",
                new Trail("Garcia Bend",
                        TrailCoords.garciaLot, TrailCoords.garciaPts, "0.0 miles\u00b2", "icon_garcia", "garcia_marriott", "garcia",
                        "7654 Pocket Rd. Sacramento, CA",
                        "Migrating Landbirds, Caspian And Forster’s Terns",
                        "Riparian, Riverine",
                        true, false, TrailBirds.garcia));

        trailHashMap.put("Marriott Park",
                new Trail("Marriott Park",
                        TrailCoords.marriottLot, TrailCoords.marriottPts, "0.01 miles\u00b2", "icon_marriott", "garcia_marriott", "marriott",
                        "7658 El Douro Dr, Sacramento, CA",
                        "Migrating Warblers, Vireos, Tanagers",
                        "Large Valley Oaks",
                        true, false, TrailBirds.marriott));

        trailHashMap.put("Chorley Park",
                new Trail("Chorley Park",
                        TrailCoords.chorleyLot, TrailCoords.chorleyPts, "0.05 miles\u00b2", "icon_chorley", "chorley", "chorley",
                        "7000 20th Street, Sacramento, CA",
                        "Nature Area",
                        "Mowed Lawns, Willows and Cottonwoods",
                        true, false, TrailBirds.chorley));

        trailHashMap.put("Riverside Trails",
                new Trail("Riverside Trails",
                        TrailCoords.riversideLot, TrailCoords.riversidePts, "0.89 miles", "icon_riverside", "riverside", "riverside",
                        "Park 0/1 mis. South 35th",
                        "Mew Gull in Winter",
                        "Riparian Habitat",
                        false, false, TrailBirds.riverside));


        ////////////
        trailHashMap.put("North Natomas",
                new Trail("North Natomas",
                        TrailCoords2.natomasLot, TrailCoords2.natomasPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Wolf Ranch Wildlife Sanctuary",
                new Trail("Wolf Ranch Wildlife Sanctuary",
                        TrailCoords2.wolfLot, TrailCoords2.wolfPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Bufferlands",
                new Trail("Bufferlands",
                        TrailCoords2.bufferlandsLot, TrailCoords2.bufferlandsPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Cosumnes River Preserve",
                new Trail("Cosumnes River Preserve",
                        TrailCoords2.cosumnesLot, TrailCoords2.cosumnesPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Rancho Seco RA",
                new Trail("Rancho Seco RA",
                        TrailCoords2.ranchoLot, TrailCoords2.ranchoPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("The Howard Ranch Trail",
                new Trail("The Howard Ranch Trail",
                        TrailCoords2.howardLot, TrailCoords2.howardPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Delta Loop",
                new Trail("Delta Loop",
                        TrailCoords2.deltaLot, TrailCoords2.deltaPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Korth’s Marina",
                new Trail("Korth’s Marina",
                        TrailCoords2.korthsLot, TrailCoords2.korthsPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Sherman Island",
                new Trail("Sherman Island",
                        TrailCoords2.shermanLot, TrailCoords2.shermanPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Brannan Island",
                new Trail("Brannan Island",
                        TrailCoords2.brannanLot, TrailCoords2.brannanPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Eddo’s RV Park",
                new Trail("Eddo’s RV Park",
                        TrailCoords2.eddosLot, TrailCoords2.eddosPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Mather Lake",
                new Trail("Mather Lake",
                        TrailCoords2.matherLot, TrailCoords2.matherPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("White Rock and Payen Roads",
                new Trail("White Rock and Payen Roads",
                        TrailCoords2.whiteRockLot, TrailCoords2.whiteRockPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Scott Road",
                new Trail("Scott Road",
                        TrailCoords2.scottLot, TrailCoords2.scottPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Latrobe Road (Deer Creek Hills)",
                new Trail("Latrobe Road (Deer Creek Hills)",
                        TrailCoords2.latrobeLot, TrailCoords2.latrobePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Michigan Bar",
                new Trail("Michigan Bar",
                        TrailCoords2.michiganLot, TrailCoords2.michiganPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Meiss Road",
                new Trail("Meiss Road",
                        TrailCoords2.meissLot, TrailCoords2.meissPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));


        ////////////
        trailHashMap.put("Nimbus Flat",
                    new Trail("Nimbus Flat",
                            TrailCoords2.nimbusFlatLot, TrailCoords2.nimbusFlatPts, "TBA", "icon_", "r", "r",
                            "TBA",
                            "TBA",
                            "TBA",
                            false, false, TrailBirds.riverside));
        trailHashMap.put("Lake Overlook Access",
                new Trail("Lake Overlook Access",
                        TrailCoords2.overlookLot, TrailCoords2.overlookPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Willow Creek Access",
                new Trail("Willow Creek Access",
                        TrailCoords2.willowLot, TrailCoords2.willowPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Negro Bar",
                new Trail("Negro Bar",
                        TrailCoords2.negroLot, TrailCoords2.negroPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Folsom Rodeo Grounds",
                new Trail("Folsom Rodeo Grounds",
                        TrailCoords2.rodeoLot, TrailCoords2.rodeoPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Folsom Point",
                new Trail("Folsom Point",
                        TrailCoords2.folsomPointLot, TrailCoords2.folsomPointPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Mormon Island Preserve",
                new Trail("Mormon Island Preserve",
                        TrailCoords2.mormonPreserveLot, TrailCoords2.mormonPreservePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Mormon Island Lake Access",
                new Trail("Mormon Island Lake Access",
                        TrailCoords2.mormonLakeLot, TrailCoords2.mormonLakePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Brown’s Ravine",
                new Trail("Brown’s Ravine",
                        TrailCoords2.brownsLot, TrailCoords2.brownsPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Falcon Crest Lane",
                new Trail("Falcon Crest Lane",
                        TrailCoords2.falconLot, TrailCoords2.falconPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Sweetwater Creek",
                new Trail("Sweetwater Creek",
                        TrailCoords2.sweetwaterCreekLot, TrailCoords2.sweetwaterCreekPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Sweetwater Trail",
                new Trail("Sweetwater Trail",
                        TrailCoords2.sweetwaterTrailLot, TrailCoords2.sweetwaterTrailPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Beal’s Point",
                new Trail("Beal’s Point",
                        TrailCoords2.bealsLot, TrailCoords2.bealsPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Granite Bay Entrance",
                new Trail("Granite Bay Entrance",
                        TrailCoords2.graniteLot, TrailCoords2.granitePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Beek’s Bight",
                new Trail("Beek’s Bight",
                        TrailCoords2.beeksLot, TrailCoords2.beeksPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Pioneer Express Trail",
                new Trail("Pioneer Express Trail",
                        TrailCoords2.pioneerLot, TrailCoords2.pioneerPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Folsom Lake Peninsula",
                new Trail("Folsom Lake Peninsula",
                        TrailCoords2.folsomPeninsulaLot, TrailCoords2.folsomPeninsulaPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));

        ///////////////////////////////////////

        trailHashMap.put("Brewer Road",
                new Trail("Brewer Road",
                        TrailCoords2.brewerLot, TrailCoords2.brewerPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Bobelaine Audobon Sanctuary",
                new Trail("Bobelaine Audobon Sanctuary",
                        TrailCoords2.bobelaineLot, TrailCoords2.bobelainePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Sand Creek Road",
                new Trail("Sand Creek Road",
                        TrailCoords2.sandCreekLot, TrailCoords2.sandCreekPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Bear Valley",
                new Trail("Bear Valley",
                        TrailCoords2.bearValleyLot, TrailCoords2.bearValleyPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Gray Lodge Wildlife Area",
                new Trail("Gray Lodge Wildlife Area",
                        TrailCoords2.grayLodgeLot, TrailCoords2.grayLodgePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Woodbridge Ecological Reserve",
                new Trail("Woodbridge Ecological Reserve",
                        TrailCoords2.woodbridgeEcoLot, TrailCoords2.woodbridgeEcoPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Staten Island",
                new Trail("Staten Island",
                        TrailCoords2.statenLot, TrailCoords2.statenPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Woodbridge Regional Park",
                new Trail("Woodbridge Regional Park",
                        TrailCoords2.woodbridgeParkLot, TrailCoords2.woodbridgeParkPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Lodi Lake",
                new Trail("Lodi Lake",
                        TrailCoords2.lodiLot, TrailCoords2.lodiPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Lake Solano Park",
                new Trail("Lake Solano Park",
                        TrailCoords2.solanoLot, TrailCoords2.solanoPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Stebbins Cold Canyon Reserve",
                new Trail("Stebbins Cold Canyon Reserve",
                        TrailCoords2.stebbinsLot, TrailCoords2.stebbinsPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Robinson Road",
                new Trail("Robinson Road",
                        TrailCoords2.robinsonLot, TrailCoords2.robinsonPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Lagoon Valley Regional Park",
                new Trail("Lagoon Valley Regional Park",
                        TrailCoords2.lagoonLot, TrailCoords2.lagoonPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("New York Creek, El Dorado Hills",
                new Trail("New York Creek, El Dorado Hills",
                        TrailCoords2.newYorkLot, TrailCoords2.newYorkPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Cronan Ranch Regional Trails Park",
                new Trail("Cronan Ranch Regional Trails Park",
                        TrailCoords2.cronanLot, TrailCoords2.cronanPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Greenwood Unit",
                new Trail("Greenwood Unit",
                        TrailCoords2.greenwoodLot, TrailCoords2.greenwoodPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Marshall Gold Discovery State Historic Park",
                new Trail("Marshall Gold Discovery State Historic Park",
                        TrailCoords2.marshallLot, TrailCoords2.marshallPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Dave Moore Nature Area",
                new Trail("Dave Moore Nature Area",
                        TrailCoords2.daveLot, TrailCoords2.davePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Old Stage Road Trailhead",
                new Trail("Old Stage Road Trailhead",
                        TrailCoords2.oldStageLot, TrailCoords2.oldStagePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Old Foresthill Road",
                new Trail("Old Foresthill Road",
                        TrailCoords2.oldForesthillLot, TrailCoords2.oldForesthillPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Old Quarry Road",
                new Trail("Old Quarry Road",
                        TrailCoords2.oldQuarryLot, TrailCoords2.oldQuarryPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("No Hands Bridge",
                new Trail("No Hands Bridge",
                        TrailCoords2.noHandsLot, TrailCoords2.noHandsPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Lake Clementine",
                new Trail("Lake Clementine",
                        TrailCoords2.clementineLot, TrailCoords2.clementinePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Driver’s Flat",
                new Trail("Driver’s Flat",
                        TrailCoords2.driversLot, TrailCoords2.driversPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Mosquito Ridge Road",
                new Trail("Mosquito Ridge Road",
                        TrailCoords2.mosquitoLot, TrailCoords2.mosquitoPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Riverton-Crystal Basin Area",
                new Trail("Riverton-Crystal Basin Area",
                        TrailCoords2.rivertonLot, TrailCoords2.rivertonPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));


        /////////////////////
        trailHashMap.put("Yolo Wildlife Area",
                new Trail("Yolo Wildlife Area",
                        TrailCoords2.yoloLot, TrailCoords2.yoloPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Wood Ducks Pond",
                new Trail("Wood Ducks Pond",
                        TrailCoords2.woodDucksLot, TrailCoords2.woodDucksPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Babel Slough Road",
                new Trail("Babel Slough Road",
                        TrailCoords2.babelLot, TrailCoords2.babelPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("UCD, Davis Arboretum",
                new Trail("UCD, Davis Arboretum",
                        TrailCoords2.arboretumLot, TrailCoords2.arboretumPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Putah Creek Riparian Preserve",
                new Trail("Putah Creek Riparian Preserve",
                        TrailCoords2.putahLot, TrailCoords2.putahPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Slide Hill Park",
                new Trail("Slide Hill Park",
                        TrailCoords2.slideLot, TrailCoords2.slidePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("North Pond",
                new Trail("North Pond",
                        TrailCoords2.northPondLot, TrailCoords2.northPondPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("North Davis Farms",
                new Trail("North Davis Farms",
                        TrailCoords2.northDavisLot, TrailCoords2.northDavisPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Wildhorse Golf Course",
                new Trail("Wildhorse Golf Course",
                        TrailCoords2.wildhorseLot, TrailCoords2.wildhorsePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Willow Bank Ditch",
                new Trail("Willow Bank Ditch",
                        TrailCoords2.willowBankLot, TrailCoords2.willowBankPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Davis Wastewater Treatment Plant",
                new Trail("Davis Wastewater Treatment Plant",
                        TrailCoords2.wastewaterLot, TrailCoords2.wastewaterPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("City of Davis Wetlands",
                new Trail("City of Davis Wetlands",
                        TrailCoords2.wetlandsLot, TrailCoords2.wetlandsPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Yolo Egret and Heron Rookery",
                new Trail("Yolo Egret and Heron Rookery",
                        TrailCoords2.rookeryLot, TrailCoords2.rookeryPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Woodland Waste Water Treatment Plant",
                new Trail("Woodland Waste Water Treatment Plant",
                        TrailCoords2.woodlandLot, TrailCoords2.woodlandPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Dunnigan Hills, Longspur Corner",
                new Trail("Dunnigan Hills, Longspur Corner",
                        TrailCoords2.dunniganLot, TrailCoords2.dunniganPts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));
        trailHashMap.put("Rayhouse Road",
                new Trail("Rayhouse Road",
                        TrailCoords2.rayhouseLot, TrailCoords2.rayhousePts, "TBA", "icon_", "r", "r",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverside));



    }
}