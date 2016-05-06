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
                        "Creek, Mountain Migrants, Nesting Birds",
                        "Riparian Trees",
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
                        "Rough-winged Swallows Nesting",
                        "Weep Holes On Overpass",
                        false, false, TrailBirds.swallows));

        trailHashMap.put("Rough Winged Swallows Site #2",
                new Trail("Rough Winged Swallows Site #2",
                        TrailCoords.swallows2Lot, TrailCoords.swallows2Pts, "", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 And 35th Avenue Overpass",
                        "Rough-winged Swallows Nesting",
                        "Weep Holes On Overpass",
                        false, false, TrailBirds.swallows));

        trailHashMap.put("Rough Winged Swallows Site #3",
                new Trail("Rough Winged Swallows Site #3",
                        TrailCoords.swallows3Lot, TrailCoords.swallows3Pts, "", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 And 43rd Avenue Overpass",
                        "Rough-winged Swallows Nesting",
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
                        TrailCoords2.natomasLot, TrailCoords2.natomasPts, "TBA", "icon_natomas", "natomas", "natomas",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.natomas));
        trailHashMap.put("Wolf Ranch Wildlife Sanctuary",
                new Trail("Wolf Ranch Wildlife Sanctuary",
                        TrailCoords2.wolfLot, TrailCoords2.wolfPts, "TBA", "icon_wolf", "wolf", "wolf",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.wolf));
        trailHashMap.put("Bufferlands",
                new Trail("Bufferlands",
                        TrailCoords2.bufferlandsLot, TrailCoords2.bufferlandsPts, "TBA", "icon_bufferlands", "bufferlands", "bufferlands",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.bufferlands));
        trailHashMap.put("Cosumnes River Preserve",
                new Trail("Cosumnes River Preserve",
                        TrailCoords2.cosumnesLot, TrailCoords2.cosumnesPts, "TBA", "icon_cosumnes", "cosumnes", "cosumnes",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.cosumnes));
        trailHashMap.put("Rancho Seco RA",
                new Trail("Rancho Seco RA",
                        TrailCoords2.ranchoLot, TrailCoords2.ranchoPts, "TBA", "icon_rancho", "rancho", "rancho",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.rancho));
        trailHashMap.put("The Howard Ranch Trail",
                new Trail("The Howard Ranch Trail",
                        TrailCoords2.howardLot, TrailCoords2.howardPts, "TBA", "icon_howard", "howard", "howard",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.howard));
        trailHashMap.put("Delta Loop",
                new Trail("Delta Loop",
                        TrailCoords2.deltaLot, TrailCoords2.deltaPts, "TBA", "icon_delta", "delta", "delta",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.brannan));
        trailHashMap.put("Korth’s Marina",
                new Trail("Korth’s Marina",
                        TrailCoords2.korthsLot, TrailCoords2.korthsPts, "TBA", "icon_korths", "korths", "korths",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.brannan));
        trailHashMap.put("Sherman Island",
                new Trail("Sherman Island",
                        TrailCoords2.shermanLot, TrailCoords2.shermanPts, "TBA", "icon_sherman", "sherman", "sherman",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.brannan));
        trailHashMap.put("Brannan Island",
                new Trail("Brannan Island",
                        TrailCoords2.brannanLot, TrailCoords2.brannanPts, "TBA", "icon_brannan", "brannan", "brannan",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.brannan));
        trailHashMap.put("Eddo’s RV Park",
                new Trail("Eddo’s RV Park",
                        TrailCoords2.eddosLot, TrailCoords2.eddosPts, "TBA", "icon_eddos", "eddos", "eddos",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.brannan));
        trailHashMap.put("Mather Lake",
                new Trail("Mather Lake",
                        TrailCoords2.matherLot, TrailCoords2.matherPts, "TBA", "icon_mather", "mather", "mather",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.mather));
        trailHashMap.put("White Rock and Payen Roads",
                new Trail("White Rock and Payen Roads",
                        TrailCoords2.whiteRockLot, TrailCoords2.whiteRockPts, "TBA", "icon_white_rock", "white_rock", "white_rock",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.whiteRock));
        trailHashMap.put("Scott Road",
                new Trail("Scott Road",
                        TrailCoords2.scottLot, TrailCoords2.scottPts, "TBA", "icon_scott", "scott", "scott",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.scott));
        trailHashMap.put("Latrobe Road (Deer Creek Hills)",
                new Trail("Latrobe Road (Deer Creek Hills)",
                        TrailCoords2.latrobeLot, TrailCoords2.latrobePts, "TBA", "icon_latrobe", "latrobe", "latrobe",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.latrobe));
        trailHashMap.put("Michigan Bar",
                new Trail("Michigan Bar",
                        TrailCoords2.michiganLot, TrailCoords2.michiganPts, "TBA", "icon_michigan", "michigan", "michigan",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.michigan));
        trailHashMap.put("Meiss Road",
                new Trail("Meiss Road",
                        TrailCoords2.meissLot, TrailCoords2.meissPts, "TBA", "icon_meiss", "meiss", "meiss",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.meiss));
        trailHashMap.put("Stone Lake",
                new Trail("Stone Lake",
                        TrailCoords2.stoneLot, TrailCoords2.stonePts, "TBA", "icon_stone", "stone", "stone",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.stone));


        ////////////
        trailHashMap.put("Nimbus Flat",
                    new Trail("Nimbus Flat",
                            TrailCoords2.nimbusFlatLot, TrailCoords2.nimbusFlatPts, "TBA", "icon_nimbusFlat", "nimbusFlat", "nimbusFlat",
                            "TBA",
                            "TBA",
                            "TBA",
                            false, false, TrailBirds.nimbusFlat));
        trailHashMap.put("Lake Overlook Access",
                new Trail("Lake Overlook Access",
                        TrailCoords2.overlookLot, TrailCoords2.overlookPts, "TBA", "icon_overlook", "overlook", "overlook",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.overlook));
        trailHashMap.put("Willow Creek Access",
                new Trail("Willow Creek Access",
                        TrailCoords2.willowLot, TrailCoords2.willowPts, "TBA", "icon_willow", "willow", "willow",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.willow));
        trailHashMap.put("Negro Bar",
                new Trail("Negro Bar",
                        TrailCoords2.negroLot, TrailCoords2.negroPts, "TBA", "icon_negro", "negro", "negro",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.negro));
        trailHashMap.put("Folsom Rodeo Grounds",
                new Trail("Folsom Rodeo Grounds",
                        TrailCoords2.rodeoLot, TrailCoords2.rodeoPts, "TBA", "icon_rodeo", "rodeo", "rodeo",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.rodeo));
        trailHashMap.put("Folsom Point",
                new Trail("Folsom Point",
                        TrailCoords2.folsomPointLot, TrailCoords2.folsomPointPts, "TBA", "icon_folsomPoint", "folsomPoint", "folsomPoint",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.folsomPoint));
        trailHashMap.put("Mormon Island Preserve",
                new Trail("Mormon Island Preserve",
                        TrailCoords2.mormonPreserveLot, TrailCoords2.mormonPreservePts, "TBA", "icon_mormonPreserve", "mormonPreserve", "mormonPreserve",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.folsomPoint));
        trailHashMap.put("Mormon Island Lake Access",
                new Trail("Mormon Island Lake Access",
                        TrailCoords2.mormonLakeLot, TrailCoords2.mormonLakePts, "TBA", "icon_mormonLake", "mormonLake", "mormonLake",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.folsomPoint));
        trailHashMap.put("Brown’s Ravine",
                new Trail("Brown’s Ravine",
                        TrailCoords2.brownsLot, TrailCoords2.brownsPts, "TBA", "icon_browns", "browns", "browns",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.folsomPoint));
        trailHashMap.put("Falcon Crest Lane",
                new Trail("Falcon Crest Lane",
                        TrailCoords2.falconLot, TrailCoords2.falconPts, "TBA", "icon_falcon", "falcon", "falcon",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.folsomPoint));
        trailHashMap.put("Sweetwater Creek",
                new Trail("Sweetwater Creek",
                        TrailCoords2.sweetwaterCreekLot, TrailCoords2.sweetwaterCreekPts, "TBA", "icon_sweetwaterCreek", "sweetwaterCreek", "sweetwaterCreek",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.sweetwater));
        trailHashMap.put("Sweetwater Trail",
                new Trail("Sweetwater Trail",
                        TrailCoords2.sweetwaterTrailLot, TrailCoords2.sweetwaterTrailPts, "TBA", "icon_sweetwaterTrail", "sweetwaterTrail", "sweetwaterTrail",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.folsomPoint));
        trailHashMap.put("Beal’s Point",
                new Trail("Beal’s Point",
                        TrailCoords2.bealsLot, TrailCoords2.bealsPts, "TBA", "icon_beals", "beals", "beals",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.beals));
        trailHashMap.put("Granite Bay Entrance",
                new Trail("Granite Bay Entrance",
                        TrailCoords2.graniteLot, TrailCoords2.granitePts, "TBA", "icon_granite", "granite", "granite",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.granite));
        trailHashMap.put("Beek’s Bight",
                new Trail("Beek’s Bight",
                        TrailCoords2.beeksLot, TrailCoords2.beeksPts, "TBA", "icon_beeks", "beeks", "beeks",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.beeks));
        trailHashMap.put("Pioneer Express Trail",
                new Trail("Pioneer Express Trail",
                        TrailCoords2.pioneerLot, TrailCoords2.pioneerPts, "TBA", "icon_pioneer", "pioneer", "pioneer",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.pioneer));
        trailHashMap.put("Folsom Lake Peninsula",
                new Trail("Folsom Lake Peninsula",
                        TrailCoords2.folsomPeninsulaLot, TrailCoords2.folsomPeninsulaPts, "TBA", "icon_folsomPeninsula", "folsomPeninsula", "folsomPeninsula",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.folsomPeninsula));

        ///////////////////////////////////////

        trailHashMap.put("Brewer Road",
                new Trail("Brewer Road",
                        TrailCoords2.brewerLot, TrailCoords2.brewerPts, "TBA", "icon_brewer", "brewer", "brewer",
                        "Near Lincoln Wastewater Plant",
                        "Raptors, Snow Geese, Tundra Swans, Lark,  Longspurs, Ibis",
                        "Fields, Riparian, Water Features",
                        false, false, TrailBirds.brewer));
        trailHashMap.put("Bobelaine Audobon Sanctuary",
                new Trail("Bobelaine Audobon Sanctuary",
                        TrailCoords2.bobelaineLot, TrailCoords2.bobelainePts, "TBA", "icon_", "bobelaine", "bobelaine",
                        "Nicolaus, California",
                        "Swainson’s Hawks, Great Horned Owls, Herons, Egrets",
                        "Riparian Forest Habitat, Oak Woodland, Sycamores",
                        false, false, TrailBirds.bobelaine));
        trailHashMap.put("Sand Creek Road",
                new Trail("Sand Creek Road",
                        TrailCoords2.sandCreekLot, TrailCoords2.sandCreekPts, "TBA", "icon_sandCreek", "sandCreek", "sandCreek",
                        "Sand Creek Road, Colusa County",
                        "Yellow-billed Magpies, Greater Roadrunner, Golden Eagles",
                        "Valley Oak Woodlands, Chaparral",
                        false, false, TrailBirds.sandCreek));
        trailHashMap.put("Bear Valley",
                new Trail("Bear Valley",
                        TrailCoords2.bearValleyLot, TrailCoords2.bearValleyPts, "TBA", "icon_bearValley", "bearValley", "bearValley",
                        "Bear Valley Road Right Off Highway 16",
                        "Greater Roadrunner, Yellow-billed Magpies, Golden Eagles",
                        "Grasslands, Perennial Creek, Riparian, Chaparral",
                        false, false, TrailBirds.bearValley));
        trailHashMap.put("Gray Lodge Wildlife Area",
                new Trail("Gray Lodge Wildlife Area",
                        TrailCoords2.grayLodgeLot, TrailCoords2.grayLodgePts, "TBA", "icon_grayLodge", "grayLodge", "grayLodge",
                        "3207 Rutherford Road, Gridley",
                        "Snow Geese, Ross's Geese Virginia Rail, Sora Rails, Ducks, Hawks",
                        "Marshlands",
                        false, false, TrailBirds.grayLodge));
        trailHashMap.put("Woodbridge Ecological Reserve",
                new Trail("Woodbridge Ecological Reserve",
                        TrailCoords2.woodbridgeEcoLot, TrailCoords2.woodbridgeEcoPts, "TBA", "icon_woodbridgeEco", "woodbridgeEco", "woodbridgeEco",
                        "W Woodbridge Rd, Lodi, CA",
                        "Sandhill Cranes",
                        "Flooded Fields",
                        false, false, TrailBirds.woodbridgeEco));
        trailHashMap.put("Staten Island",
                new Trail("Staten Island",
                        TrailCoords2.statenLot, TrailCoords2.statenPts, "TBA", "icon_staten", "staten", "staten",
                        "Island in the Sacramento-San Joaquin River Delta",
                        "Sandhill Cranes, Waterfowl",
                        "Flooded Fields",
                        false, false, TrailBirds.staten));
        trailHashMap.put("Woodbridge Regional Park",
                new Trail("Woodbridge Regional Park",
                        TrailCoords2.woodbridgeParkLot, TrailCoords2.woodbridgeParkPts, "TBA", "icon_woodbridgePark", "woodbridgePark", "woodbridgePark",
                        "301 River Meadows Drive in Woodbridge",
                        "Wood Duck, Common Merganser, Hawks, Owl, Woodpeckers, Lazuli Bunting",
                        "Riparian Woodlands, River, Riparian Bush",
                        false, false, TrailBirds.woodbridgePark));
        trailHashMap.put("Lodi Lake",
                new Trail("Lodi Lake",
                        TrailCoords2.lodiLot, TrailCoords2.lodiPts, "TBA", "icon_lodi", "lodi", "lodi",
                        "1101 W Turner Rd, Lodi",
                        "Shore Birds, Gulls, Ducks, Swift’s, Orioles, Raptors, Kingbird",
                        "Lake, Riparian, Open Woodlands, Grasslands",
                        false, false, TrailBirds.lodi));
        trailHashMap.put("Lake Solano Park",
                new Trail("Lake Solano Park",
                        TrailCoords2.solanoLot, TrailCoords2.solanoPts, "TBA", "icon_solano", "solano", "solano",
                        "8685 Pleasants Valley Rd, Winters",
                        "Swainson's Hawks, Osprey, Great Horned Owls, Sapsucker",
                        "Riparian Habitat, Farmland, Fields, Lake, Creek",
                        false, false, TrailBirds.solano));
        trailHashMap.put("Stebbins Cold Canyon Reserve",
                new Trail("Stebbins Cold Canyon Reserve",
                        TrailCoords2.stebbinsLot, TrailCoords2.stebbinsPts, "TBA", "icon_stebbins", "stebbins", "stebbins",
                        "CA-128, Winters, CA",
                        "Eagles, Western Bluebirds, Hawks, Owls, Swifts, Hummingbirds, Grosbeaks, Buntings, Poorwills",
                        "Riparian Oak, Scrub Woodland",
                        false, false, TrailBirds.stebbins));
        trailHashMap.put("Robinson Road",
                new Trail("Robinson Road",
                        TrailCoords2.robinsonLot, TrailCoords2.robinsonPts, "TBA", "icon_robinson", "robinson", "robinson",
                        "South through Dixon",
                        "Hawks, Eagles, Falcons, Merlins, Mountain Plovers, Larks, Curlew, Shrikes, Pipits",
                        "Eucalyptus, Trees, Grasslands",
                        false, false, TrailBirds.robinson));
        trailHashMap.put("Lagoon Valley Regional Park",
                new Trail("Lagoon Valley Regional Park",
                        TrailCoords2.lagoonLot, TrailCoords2.lagoonPts, "TBA", "icon_lagoon", "lagoon", "lagoon",
                        "Off Interstate 80 in Vacaville",
                        "Migrants, Songbirds, Pileated Woodpecker",
                        "Reservoir, Trees, Creek, Riparian",
                        false, false, TrailBirds.lagoon));
        trailHashMap.put("New York Creek, El Dorado Hills",
                new Trail("New York Creek, El Dorado Hills",
                        TrailCoords2.newYorkLot, TrailCoords2.newYorkPts, "TBA", "icon_newYork", "newYork", "newYork",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.newYork));
        trailHashMap.put("Cronan Ranch Regional Trails Park",
                new Trail("Cronan Ranch Regional Trails Park",
                        TrailCoords2.cronanLot, TrailCoords2.cronanPts, "TBA", "icon_cronan", "cronan", "cronan",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.cronan));
        trailHashMap.put("Greenwood Unit",
                new Trail("Greenwood Unit",
                        TrailCoords2.greenwoodLot, TrailCoords2.greenwoodPts, "TBA", "icon_greenwood", "greenwood", "greenwood",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.greenwood));
        trailHashMap.put("Marshall Gold Discovery State Historic Park",
                new Trail("Marshall Gold Discovery State Historic Park",
                        TrailCoords2.marshallLot, TrailCoords2.marshallPts, "TBA", "icon_marshall", "marshall", "marshall",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.marshall));
        trailHashMap.put("Dave Moore Nature Area",
                new Trail("Dave Moore Nature Area",
                        TrailCoords2.daveLot, TrailCoords2.davePts, "TBA", "icon_dave", "dave", "dave",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.dave));
        trailHashMap.put("Old Stage Road Trailhead",
                new Trail("Old Stage Road Trailhead",
                        TrailCoords2.oldStageLot, TrailCoords2.oldStagePts, "TBA", "icon_oldStage", "oldStage", "oldStage",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.oldStage));
        trailHashMap.put("Old Foresthill Road",
                new Trail("Old Foresthill Road",
                        TrailCoords2.oldForesthillLot, TrailCoords2.oldForesthillPts, "TBA", "icon_oldForesthill", "oldForesthill", "oldForesthill",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.noBirds));
        trailHashMap.put("Old Quarry Road",
                new Trail("Old Quarry Road",
                        TrailCoords2.oldQuarryLot, TrailCoords2.oldQuarryPts, "TBA", "icon_oldQuarry", "oldQuarry", "oldQuarry",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.noBirds));
        trailHashMap.put("No Hands Bridge",
                new Trail("No Hands Bridge",
                        TrailCoords2.noHandsLot, TrailCoords2.noHandsPts, "TBA", "icon_noHands", "noHands", "noHands",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.noHands));
        trailHashMap.put("Lake Clementine",
                new Trail("Lake Clementine",
                        TrailCoords2.clementineLot, TrailCoords2.clementinePts, "TBA", "icon_clementine", "clementine", "clementine",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.clementine));
        trailHashMap.put("Driver’s Flat",
                new Trail("Driver’s Flat",
                        TrailCoords2.driversLot, TrailCoords2.driversPts, "TBA", "icon_drivers", "drivers", "drivers",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.drivers));
        trailHashMap.put("Mosquito Ridge Road",
                new Trail("Mosquito Ridge Road",
                        TrailCoords2.mosquitoLot, TrailCoords2.mosquitoPts, "TBA", "icon_mosquito", "mosquito", "mosquito",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.mosquito));
        trailHashMap.put("Riverton-Crystal Basin Area",
                new Trail("Riverton-Crystal Basin Area",
                        TrailCoords2.rivertonLot, TrailCoords2.rivertonPts, "TBA", "icon_riverton", "riverton", "riverton",
                        "TBA",
                        "TBA",
                        "TBA",
                        false, false, TrailBirds.riverton));


        /////////////////////
        trailHashMap.put("Yolo Wildlife Area",
                new Trail("Yolo Wildlife Area",
                        TrailCoords2.yoloLot, TrailCoords2.yoloPts, "TBA", "icon_yolo", "yolo", "yolo",
                        "45211 County Road 32B (Chiles Road)",
                        "American White Pelicans, Peregrine Falcon, Merlin, Swallows",
                        "Wetlands, Riparian Woodland, Grassland",
                        false, false, TrailBirds.yolo));
        trailHashMap.put("Wood Ducks Pond",
                new Trail("Wood Ducks Pond",
                        TrailCoords2.woodDucksLot, TrailCoords2.woodDucksPts, "TBA", "icon_woodDucks", "woodDucks", "woodDucks",
                        "South River Road West of the Sacramento River",
                        "Wood Ducks, Migrants, Warblers, Songbirds",
                        "Riparian, Ponds",
                        false, false, TrailBirds.woodDucks));
        trailHashMap.put("Babel Slough Road",
                new Trail("Babel Slough Road",
                        TrailCoords2.babelLot, TrailCoords2.babelPts, "TBA", "icon_babel", "babel", "babel",
                        "Babel Slough Road 0.2 miles West of South River Road",
                        "Empidonax Flycatchers, Chestnut-Sided Warbler, Ovenbird, Rose-Breasted Grosbeak",
                        "Water Feature, Trees",
                        false, false, TrailBirds.babel));
        trailHashMap.put("UCD, Davis Arboretum",
                new Trail("UCD, Davis Arboretum",
                        TrailCoords2.arboretumLot, TrailCoords2.arboretumPts, "TBA", "icon_arboretum", "arboretum", "arboretum",
                        "448 La Rue Rd, Davis, CA 95616",
                        "Red-Breasted Nuthatches, Scissor-Tailed Flycatcher, Red Crossbills",
                        "Trees, Regional Plantings, Creek",
                        false, false, TrailBirds.arboretum));
        trailHashMap.put("Putah Creek Riparian Preserve",
                new Trail("Putah Creek Riparian Preserve",
                        TrailCoords2.putahLot, TrailCoords2.putahPts, "TBA", "icon_putah", "putah", "putah",
                        "436 Mrak Hall One Shields Avenue",
                        "Chestnut-Backed Chickadees, Black-Crowned Night-Herons, Snowy Egrets",
                        "Stream, Riparian and Grassland",
                        false, false, TrailBirds.noBirds));
        trailHashMap.put("Slide Hill Park",
                new Trail("Slide Hill Park",
                        TrailCoords2.slideLot, TrailCoords2.slidePts, "TBA", "icon_slide", "slide", "slide",
                        "2850 Temple Dr, Davis, CA",
                        "Mountain Chickadee, Cassin’s Finch, Red Crossbill, Evening Grosbeak",
                        "Trees",
                        false, false, TrailBirds.slide));
        trailHashMap.put("North Pond",
                new Trail("North Pond",
                        TrailCoords2.northPondLot, TrailCoords2.northPondPts, "TBA", "icon_northPond", "northPond", "northPond",
                        "3434 Anderson Road Davis",
                        "Dowitchers, Yellowlegs, Ruff",
                        "Wetlands, Trees",
                        false, false, TrailBirds.northPond));
        trailHashMap.put("North Davis Farms",
                new Trail("North Davis Farms",
                        TrailCoords2.northDavisLot, TrailCoords2.northDavisPts, "TBA", "icon_northDavis", "northDavis", "northDavis",
                        "North Davis Farms Rd., Davis",
                        "Migratory Birds",
                        "Trees, Ponds",
                        false, false, TrailBirds.noBirds));
        trailHashMap.put("Wildhorse Golf Course",
                new Trail("Wildhorse Golf Course",
                        TrailCoords2.wildhorseLot, TrailCoords2.wildhorsePts, "TBA", "icon_wildhorse", "wildhorse", "wildhorse",
                        "Northeast of the Wildhorse Golf Course, Davis",
                        "Burrowing Owls",
                        "Burrows, Fields, Stream",
                        false, false, TrailBirds.wildhorse));
        trailHashMap.put("Willow Bank Ditch",
                new Trail("Willow Bank Ditch",
                        TrailCoords2.willowBankLot, TrailCoords2.willowBankPts, "TBA", "icon_willowBank", "willowBank", "willowBank",
                        "Lillard Ave at El Campo Ave or Ohlone Street",
                        "Winter Wrens",
                        "Trees",
                        false, false, TrailBirds.willowBank));
        trailHashMap.put("Davis Wastewater Treatment Plant",
                new Trail("Davis Wastewater Treatment Plant",
                        TrailCoords2.wastewaterLot, TrailCoords2.wastewaterPts, "TBA", "icon_wastewater", "wastewater", "wastewater",
                        "2727 2nd St, Davis",
                        "Pintails, American Widgeons, Shovelers,Phalaropes, Plovers, Gulls",
                        "Sewage Ponds, Settling Ponds, Levees",
                        false, false, TrailBirds.wastewater));
        trailHashMap.put("City of Davis Wetlands",
                new Trail("City of Davis Wetlands",
                        TrailCoords2.wetlandsLot, TrailCoords2.wetlandsPts, "TBA", "icon_wetlands", "wetlands", "wetlands",
                        "2727 2nd St, Davis",
                        "Shorebirds, Waterfowl, Northern Harriers, Marsh Wrens, Yellow-headed Blackbirds",
                        "Wetlands, Upland",
                        false, false, TrailBirds.wetlands));
        trailHashMap.put("Yolo Egret and Heron Rookery",
                new Trail("Yolo Egret and Heron Rookery",
                        TrailCoords2.rookeryLot, TrailCoords2.rookeryPts, "TBA", "icon_rookery", "rookery", "rookery",
                        "Near Yolo County Landfill",
                        "Nesting Egrets, Herons",
                        "Eucalyptus Trees",
                        false, false, TrailBirds.rookery));
        trailHashMap.put("Woodland Waste Water Treatment Plant",
                new Trail("Woodland Waste Water Treatment Plant",
                        TrailCoords2.woodlandLot, TrailCoords2.woodlandPts, "TBA", "icon_woodland", "woodland", "woodland",
                        "Road 24 opposite Gibson Road",
                        "Shorebirds, Gulls, Pacific Golden-Plovers,  Semipalmated Sandpipers, Baird’s Sandpipers",
                        "Ponds",
                        false, false, TrailBirds.woodland));
        trailHashMap.put("Dunnigan Hills, Longspur Corner",
                new Trail("Dunnigan Hills, Longspur Corner",
                        TrailCoords2.dunniganLot, TrailCoords2.dunniganPts, "TBA", "icon_dunnigan", "dunnigan", "dunnigan",
                        "Rds 16 and 90B are \"Longspur Corner\"",
                        "Golden Eagle, Northern Harrier, Hawks, Merlin,  Prairie Falcon, Burrowing Owls",
                        "Rolling Hills",
                        false, false, TrailBirds.dunnigan));
        trailHashMap.put("Rayhouse Road",
                new Trail("Rayhouse Road",
                        TrailCoords2.rayhouseLot, TrailCoords2.rayhousePts, "TBA", "icon_rayhouse", "rayhouse", "rayhouse",
                        "5 Miles past Capay Valley",
                        "Common Poorwill, Mountain Quail, Sage Sparrow, Lawrence’s Goldfinch,  Pileated Woodpeckers",
                        "Steep Mountains, Oak Woodlands, Riparian, Chaparral",
                        false, false, TrailBirds.rayhouse));



    }
}