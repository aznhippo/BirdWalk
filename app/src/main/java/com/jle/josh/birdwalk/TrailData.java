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
                        1, TrailBirds.disc));

        trailHashMap.put("Bushy Lake and the Cal Expo Floodplain",
                new Trail("Bushy Lake and the Cal Expo Floodplain",
                        TrailCoords.bushyLot, TrailCoords.bushyPts, "3.19 miles", "icon_bushy", "bushy", "bushy",
                        "Cal Expo Gate #13, Sacramento, CA",
                        "Nesting Great Horned Owls, Migrating Warblers, Wood Ducks",
                        "Riparian Vegetation, Water Features",
                        1, TrailBirds.bushy));

        trailHashMap.put("California State University, Sacramento",
                new Trail("California State University, Sacramento",
                        TrailCoords.csuLot,TrailCoords.csuPts, "0.01 miles\u00b2", "icon_csu", "csu", "csu",
                        "6000 J Street, Sacramento, CA",
                        "Seasonal Variety, Year-round White-tailed Kite",
                        "Streamside Woodlands, Hedges, Trees, Savannah",
                        2, TrailBirds.csu));

        trailHashMap.put("Howe Ave River Access",
                new Trail("Howe Ave River Access",
                        TrailCoords2.howeLot, TrailCoords2.howePts, "1.81 miles", "icon_howe", "howe_watt", "howe",
                        "The La Riviera Off-ramp to Entrance",
                        "Nesting Rough-Winged Swallows, Waterbirds",
                        "Riparian, Pond, Flooded Backwaters",
                        1, TrailBirds.howe));

        trailHashMap.put("Watt Ave River Access",
                new Trail("Watt Ave River Access",
                        TrailCoords2.wattLot, TrailCoords2.wattPts, "1.64 miles ", "icon_watt", "howe_watt", "watt",
                        "Riviera Drive Off Watt Ave, Sacramento, CA",
                        "Wood Ducks, Belted Kingfishers, Green Herons, Black Phoebes",
                        "Cottonwood Stands, Riparian",
                        0, TrailBirds.watt));

        trailHashMap.put("Gristmill Recreation Area",
                new Trail("Gristmill Recreation Area",
                        TrailCoords.gristLot, TrailCoords.gristPts, "1.47 miles", "icon_grist", "grist", "grist",
                        "Mira Del Rio Dr., Sacramento, CA",
                        "Rarities; Eastern Wood Pewee, Red-eyed vireo, Warblers",
                        "Riparian, Willows, Cottonwoods, Other Trees",
                        0, TrailBirds.gristmill));

        trailHashMap.put("William B. Pond Recreation Area",
                new Trail("William B. Pond Recreation Area",
                        TrailCoords.willPondLot, TrailCoords.willPondPts, "2.17 miles", "icon_willpond", "willpond", "willpond",
                        "5700 Arden Way, Carmichael, CA",
                        "Great Blue Heron And Great Egret Nesting Rookery",
                        "Riparian, Riverine, Ponds, Grassland",
                        1, TrailBirds.willpond));

        trailHashMap.put("River Bend Park",
                new Trail("River Bend Park",
                        TrailCoords.riverBendLot, TrailCoords.riverBendPts, "1.69 miles", "icon_riverbend", "riverbend", "riverbend",
                        "2300 Rod Beaudry Dr, Rancho Cordova, CA",
                        "Cliff Swallows Nests Under The Bike Bridge",
                        "Oak Woodlands, Riparian Woodlands, Riverine, Bridge",
                        1, TrailBirds.riverbend));

        trailHashMap.put("Effie Yeaw Nature Center",
                new Trail("Effie Yeaw Nature Center",
                        TrailCoords.effieLot, TrailCoords.effiePts, "3.84 miles", "icon_effie", "effie", "effie",
                        "6700 Tarshes Dr, Carmichael, CA",
                        "100+ Species Possible; Wild Turkeys",
                        "Riparian Woodlands, Riverine, Ponds, Grassland Open Areas",
                        1, TrailBirds.effie));

        trailHashMap.put("Rossmoor Bar",
                new Trail("Rossmoor Bar",
                        TrailCoords.rossmoorLot, TrailCoords.rossmoorPts, "2.02 miles", "icon_rossmoor", "rossmoor", "rossmoor",
                        "1949 Rossmoor Dr, Rancho Cordova, CA",
                        "Active Bank Swallow Colony On North Bank Of The River",
                        "Low Bluffs, Riverine, Riparian Shrub, Oak Woodlands",
                        1, TrailBirds.rossmoor));

        trailHashMap.put("Sacramento Bar and Bannister Park",
                new Trail("Sacramento Bar and Bannister Park",
                        TrailCoords.barLot, TrailCoords.barPts, "2.63 miles", "icon_bar", "bar", "bar",
                        "3820 Bannister Rd, Fair Oaks, CA",
                        "Breeding Yellow-breasted Chats",
                        "Riparian, Riverine, Gravel Tailings, Ponds",
                        1, TrailBirds.bar));

        trailHashMap.put("Lower Sunrise Area",
                new Trail("Lower Sunrise Area",
                        TrailCoords.lowSunriseLot, TrailCoords.lowSunrisePts, "2.66 miles", "icon_sunrise", "lowsunrise", "lowsunrise",
                        "At End Of Riverlite Ct., Rancho Cordova, CA",
                        "Acorn Woodpeckers, Tree Swallows, Hawks, Osprey",
                        "Low Bluffs, Riverine, Riparian Shrub, Oak Woodlands",
                        1, TrailBirds.lowsunrise));

        trailHashMap.put("Sailor Bar",
                new Trail("Sailor Bar",
                        TrailCoords.sailorLot, TrailCoords.sailorPts, "3.3 miles", "icon_sailor", "sailor", "sailor",
                        "At End Of Illinois Ave., Sacramento, CA",
                        "Red-winged Blackbirds, Acorn Woodpeckers",
                        "Riparian, Woodland, Open Area, Gravel Tailings",
                        1, TrailBirds.sailor));

        trailHashMap.put("Upper Sunrise",
                new Trail("Upper Sunrise",
                        TrailCoords.upSunriseLot, TrailCoords.upSunrisePts, "3.35 miles", "icon_sunrise", "upsunrise", "upsunrise",
                        "2001 Nimbus Rd, Gold River, CA",
                        "Barrow’s Goldeneye, Gulls",
                        "Rising Bluffs, Riverine, Riparian, Oaks, Toyon, Gray Pine",
                        0, TrailBirds.upper_nimbus));

        trailHashMap.put("Nimbus Hatchery",
                new Trail("Nimbus Hatchery",
                        TrailCoords.nimbusLot, TrailCoords.nimbusPts, "2.6 miles", "icon_nimbus", "nimbus", "nimbus",
                        "2001 Nimbus Rd, Gold River, CA",
                        "Bald Eagle During Salmon Run",
                        "Rising Bluffs, Riverine, Riparian, Oaks, Toyon, Gray Pine",
                        0, TrailBirds.upper_nimbus));

        trailHashMap.put("Purple Martins Site #1",
                new Trail("Purple Martins Site #1",
                        TrailCoords.purp1Lot, TrailCoords.purp1Pts, "", "icon_purp", "purp", "purp",
                        "20th Street Between X And W Streets, Sacramento, CA",
                        "Purple Martins Nesting",
                        "Weep Holes Under Freeway Overpasses",
                        0, TrailBirds.purp));

        trailHashMap.put("Purple Martins Site #2",
                new Trail("Purple Martins Site #2",
                        TrailCoords.purp2Lot, TrailCoords.purp2Pts, "0.08 miles", "icon_purp", "purp", "purp",
                        "Old Town Sacramento, 125 I Street",
                        "Purple Martins Nesting",
                        "Weep Holes Under Freeway Overpasses",
                        0, TrailBirds.purp));

        trailHashMap.put("Purple Martins Site #3",
                new Trail("Purple Martins Site #3",
                        TrailCoords.purp3Lot, TrailCoords.purp3Pts, "", "icon_purp", "purp", "purp",
                        "29th and 30th Streets Between R and S Sts",
                        "Purple Martins Nesting",
                        "Weep Holes Under Freeway Overpasses",
                        0, TrailBirds.purp));

        trailHashMap.put("East Lawn Cemetery",
                new Trail("East Lawn Cemetery",
                        TrailCoords.eastLawnLot, TrailCoords.eastLawnPts, "1.03 miles", "icon_eastlawn", "eastlawn", "eastlawn",
                        "4300 Folsom Boulevard, Sacramento, CA",
                        "Bushtits, Warblers, Robins, Flickers, Red-Tailed Hawk",
                        "Lawns, Tall Evergreens, Deciduous Trees, Shrubbery",
                        0, TrailBirds.eastlawn));

        trailHashMap.put("Arcade Creek at American River College",
                new Trail("Arcade Creek at American River College",
                        TrailCoords.arcadeCollegeLot, TrailCoords.arcadeCollegePts, "0.67 miles", "icon_arcadecollege", "arcade", "arcadecollege",
                        "4700 College Oak Dr, Sacramento, CA ",
                        "Creek, Mountain Migrants, Nesting Birds",
                        "Riparian Trees",
                        0, TrailBirds.arcade));

        trailHashMap.put("Arcade Creek from Arden Creek Park",
                new Trail("Arcade Creek from Arden Creek Park",
                        TrailCoords.arcadeArdenLot, TrailCoords.arcadeArdenPts, "0.67 miles", "icon_arcadearden", "arcade", "arcadearden",
                        "5613 Omni Drive, Sacramento",
                        "Mountain Migrants Nesting",
                        "Riparian Trees",
                        0, TrailBirds.arcade));

        trailHashMap.put("Rough Winged Swallows Sites",
                new Trail("Rough Winged Swallows Sites",
                        TrailCoords.swallows1Lot, TrailCoords.swallows1Pts, "", "icon_swallows", "swallows", "swallows",
                        "Interstate 5 and Seamas Blvd. Overpass",
                        "Rough-winged Swallows Nesting",
                        "Weep Holes On Overpass",
                        3, TrailBirds.swallows));

//        trailHashMap.put("Rough Winged Swallows Site #2",
//                new Trail("Rough Winged Swallows Site #2",
//                        TrailCoords.swallows2Lot, TrailCoords.swallows2Pts, "", "icon_swallows", "swallows", "swallows",
//                        "Interstate 5 And 35th Avenue Overpass",
//                        "Rough-winged Swallows Nesting",
//                        "Weep Holes On Overpass",
//                        false, false, TrailBirds.swallows));
//
//        trailHashMap.put("Rough Winged Swallows Site #3",
//                new Trail("Rough Winged Swallows Site #3",
//                        TrailCoords.swallows3Lot, TrailCoords.swallows3Pts, "", "icon_swallows", "swallows", "swallows",
//                        "Interstate 5 And 43rd Avenue Overpass",
//                        "Rough-winged Swallows Nesting",
//                        "Weep Holes On Overpass",
//                        false, false, TrailBirds.swallows));

        trailHashMap.put("William Land Park",
                new Trail("William Land Park",
                        TrailCoords.willParkLot, TrailCoords.willParkPts, "0.04 miles\u00b2", "icon_willpark", "willpark", "willpark",
                        "3800 W Land Park Dr, Sacramento, CA",
                        "Bird “Panhandle”",
                        "Large Conifers, Shrubs, Mature Trees",
                        2, TrailBirds.willpark));

        trailHashMap.put("Reichmuth Park",
                new Trail("Reichmuth Park",
                        TrailCoords.reichmuthLot, TrailCoords.reichmuthPts, "0.03 miles\u00b2", "icon_reichmuth", "reichmuth", "reichmuth",
                        "6135 Gloria Dr. Sacramento, CA",
                        "Migrating Land Birds, Hooded Orioles",
                        "Formerly An Oxbow, Swampy Wooded Area",
                        2, TrailBirds.reichmuth));

        trailHashMap.put("Green Haven Lake",
                new Trail("Green Haven Lake",
                        TrailCoords.greenHavenLot, TrailCoords.greenHavenPts, "", "icon_greenhaven", "greenhaven", "greenhaven",
                        "Havenside Dr., Sacramento, CA",
                        "Mergansers, Cormorants, Gulls, Ducks",
                        "Views of Shoreline, Lake",
                        3, TrailBirds.greenhaven));

        trailHashMap.put("Garcia Bend",
                new Trail("Garcia Bend",
                        TrailCoords.garciaLot, TrailCoords.garciaPts, "0.0 miles\u00b2", "icon_garcia", "garcia_marriott", "garcia",
                        "7654 Pocket Rd. Sacramento, CA",
                        "Migrating Landbirds, Caspian And Forster’s Terns",
                        "Riparian, Riverine",
                        2, TrailBirds.garcia));

        trailHashMap.put("Marriott Park",
                new Trail("Marriott Park",
                        TrailCoords.marriottLot, TrailCoords.marriottPts, "0.01 miles\u00b2", "icon_marriott", "garcia_marriott", "marriott",
                        "7658 El Douro Dr, Sacramento, CA",
                        "Migrating Warblers, Vireos, Tanagers",
                        "Large Valley Oaks",
                        2, TrailBirds.marriott));

        trailHashMap.put("Chorley Park",
                new Trail("Chorley Park",
                        TrailCoords.chorleyLot, TrailCoords.chorleyPts, "0.05 miles\u00b2", "icon_chorley", "chorley", "chorley",
                        "7000 20th Street, Sacramento, CA",
                        "Nature Area",
                        "Mowed Lawns, Willows and Cottonwoods",
                        2, TrailBirds.chorley));

        trailHashMap.put("Riverside Trails",
                new Trail("Riverside Trails",
                        TrailCoords.riversideLot, TrailCoords.riversidePts, "0.89 miles", "icon_riverside", "riverside", "riverside",
                        "Park 0/1 mis. South 35th",
                        "Mew Gull in Winter",
                        "Riparian Habitat",
                        0, TrailBirds.riverside));


        ////////////
        trailHashMap.put("North Natomas",
                new Trail("North Natomas",
                        TrailCoords2.natomasLot, TrailCoords2.natomasPts, "17.01 miles", "icon_natomas", "natomas", "natomas",
                        "Discovery Park to the Sutter County Line",
                        "Swainson’s Hawks, Tricolored Blackbirds, White-faced Ibis, Long-billed Curlew",
                        "Grassy Areas, Rice Fields, Canals, Riparian, Fields, Irrigation Ditches",
                        5, TrailBirds.natomas));
        trailHashMap.put("Wolf Ranch Wildlife Sanctuary",
                new Trail("Wolf Ranch Wildlife Sanctuary",
                        TrailCoords2.wolfLot, TrailCoords2.wolfPts, "2.34 miles\u00b2", "icon_wolf", "wolf", "wolf",
                        "South of Elkhorn Boulevard and Sorento Road",
                        "Greater Yellowlegs, Common Snipe, Great-tailed Grackles",
                        "Creeks, Wetlands, Drainage Ditch, Upland Forests",
                        1, TrailBirds.wolf));
        trailHashMap.put("Bufferlands",
                new Trail("Bufferlands",
                        TrailCoords2.bufferlandsLot, TrailCoords2.bufferlandsPts, "", "icon_bufferlands", "bufferlands", "bufferlands",
                        "8521 Laguna Station Rd, Elk Grove, CA",
                        "Canvasback, Nesting Swainson’s Hawks, Blue Grosbeak",
                        "Riparian Forest, Woodlands, Grasslands, Wetlands",
                        0, TrailBirds.bufferlands));
        trailHashMap.put("Cosumnes River Preserve",
                new Trail("Cosumnes River Preserve",
                        TrailCoords2.cosumnesLot, TrailCoords2.cosumnesPts, "1.29 miles", "icon_cosumnes", "cosumnes", "cosumnes",
                        "13501 Franklin Blvd, Galt, CA ",
                        "Globally Important Bird Area",
                        "Wetlands, Grasslands, Agriculture, Valley Oak Riparian Forest",
                        1, TrailBirds.cosumnes));
        trailHashMap.put("Rancho Seco RA",
                new Trail("Rancho Seco RA",
                        TrailCoords2.ranchoLot, TrailCoords2.ranchoPts, "", "icon_rancho", "rancho", "rancho",
                        "14440 Twin Cities Road Herald, CA",
                        "Ferruginous Hawks, Burrowing Owls, Horned Larks, Lesser Nighthawks",
                        "Grasslands, Vernal Pools, Oak Woodlands",
                        0, TrailBirds.rancho));
        trailHashMap.put("Howard Ranch Trail",
                new Trail("Howard Ranch Trail",
                        TrailCoords2.howardLot, TrailCoords2.howardPts, "", "icon_howard", "howard", "howard",
                        "14440 Twin Cities Road, Herald, CA ",
                        "Ferruginous Hawks, Burrowing Owls, Horned Larks, Lesser Nighthawks",
                        "Grasslands, Vernal Pools, Oak Woodlands",
                        4, TrailBirds.howard));
//        trailHashMap.put("Delta Loop",
//                new Trail("Delta Loop",
//                        TrailCoords2.deltaLot, TrailCoords2.deltaPts, "", "icon_delta", "korths", "delta",
//                        "TBA",
//                        "TBA",
//                        "TBA",
//                        false, false, TrailBirds.brannan));
        trailHashMap.put("Korth’s Marina",
                new Trail("Korth’s Marina",
                        TrailCoords2.korthsLot, TrailCoords2.korthsPts, "", "icon_korths", "korths", "korths",
                        "169 W Brannan Island Rd, Isleton, CA",
                        "Migrant Trap",
                        "Marina, Trees",
                        0, TrailBirds.brannan));
        trailHashMap.put("Sherman Island",
                new Trail("Sherman Island",
                        TrailCoords2.shermanLot, TrailCoords2.shermanPts, "", "icon_sherman", "korths", "sherman",
                        "3729 W Sherman Island Rd, Rio Vista, CA",
                        "Waterfowl, Raptors, Shorebirds",
                        "Fields, Fences, Trees, Rivers",
                        0, TrailBirds.brannan));
        trailHashMap.put("Brannan Island",
                new Trail("Brannan Island",
                        TrailCoords2.brannanLot, TrailCoords2.brannanPts, "", "icon_brannan", "korths", "brannan",
                        "17645 CA-160, Rio Vista, CA",
                        "Waterfowl, Raptors, Shorebirds, Yellow-breasted Chats",
                        "Trees, Water, Open Areas",
                        0, TrailBirds.brannan));
        trailHashMap.put("Eddo’s RV Park",
                new Trail("Eddo’s RV Park",
                        TrailCoords2.eddosLot, TrailCoords2.eddosPts, "", "icon_eddos", "korths", "eddos",
                        "19530 Sherman Island East Levee Rd, Rio Vista, CA",
                        "Waterfowl, Raptors, Shorebirds",
                        "Trees, Water, Open Areas",
                        0, TrailBirds.brannan));
        trailHashMap.put("Mather Lake",
                new Trail("Mather Lake",
                        TrailCoords2.matherLot, TrailCoords2.matherPts, "", "icon_mather", "mather", "mather",
                        "4101 Eagle's Nest Rd, Mather, CA",
                        "Nesting Yellow-headed Blackbird,Western Kingbird, Bullock’s Oriole, Ash-throated Flycatcher",
                        "Lake, Riparian, Upland Scrub, Wetland, Grassland",
                        0, TrailBirds.mather));
        trailHashMap.put("White Rock and Payen Roads",
                new Trail("White Rock and Payen Roads",
                        TrailCoords2.whiteRockLot, TrailCoords2.whiteRockPts, "6.02 miles", "icon_white_rock", "white_rock", "white_rock",
                        "Junction of White Rock and Payen Roads",
                        "Multi-species Black Bird Flocks, Prairie Falcon, Winter Raptors",
                        "Grasslands",
                        5, TrailBirds.whiteRock));
        trailHashMap.put("Scott Road",
                new Trail("Scott Road",
                        TrailCoords2.scottLot, TrailCoords2.scottPts, "7.93 miles", "icon_scott", "scott", "scott",
                        "Scott Rd, Folsom, Ca",
                        "Multi-species of Sparrows, American Pipits, Eagles, Hawks",
                        "Grasslands, Oaks",
                        5, TrailBirds.scott));
        trailHashMap.put("Latrobe Road (Deer Creek Hills)",
                new Trail("Latrobe Road (Deer Creek Hills)",
                        TrailCoords2.latrobeLot, TrailCoords2.latrobePts, "2.95 miles", "icon_latrobe", "latrobe", "latrobe",
                        "Junction of Latrobe Road and Stone House Road",
                        "Foothill Species, Owls",
                        "Blue Oak Woodland, Savanna, Grasslands",
                        5, TrailBirds.latrobe));
        trailHashMap.put("Michigan Bar",
                new Trail("Michigan Bar",
                        TrailCoords2.michiganLot, TrailCoords2.michiganPts, "1.24 miles", "icon_michigan", "michigan", "michigan",
                        "Michigan Bar, California",
                        "Hairy Woodpeckers, Common Poorwills, Burrowing Owls",
                        "Blue Oak Woodland, Savanna, Grasslands, River",
                        0, TrailBirds.michigan));
        trailHashMap.put("Meiss Road",
                new Trail("Meiss Road",
                        TrailCoords2.meissLot, TrailCoords2.meissPts, "7.58 miles", "icon_meiss", "meiss", "meiss",
                        "From Dillard Road to Ione Road",
                        "Raptors, Lesser Nighthawks Horned Lark, Grasshopper Sparrows",
                        "Grasslands",
                        5, TrailBirds.meiss));
        trailHashMap.put("Stone Lake",
                new Trail("Stone Lake",
                        TrailCoords2.stoneLot, TrailCoords2.stonePts, "", "icon_stone", "stone", "stone",
                        "1624 Hood Franklin Rd, Elk Grove, CA",
                        "Nesting Swainson’s Hawks, Rookery of Great Blue Herons, Great Egrets, Cormorants",
                        "Permanent and Seasonal Wetlands, Vernal Pools, Lakes, Riparian Corridors",
                        0, TrailBirds.stone));


        ////////////
        trailHashMap.put("Nimbus Flat",
                    new Trail("Nimbus Flat",
                            TrailCoords2.nimbusFlatLot, TrailCoords2.nimbusFlatPts, "", "icon_nimbusFlat", "nimbusFlat", "nimbusFlat",
                            "1901 Hazel Ave, Gold River, CA ",
                            "Gulls, Water Birds",
                            "Lake",
                            0, TrailBirds.nimbusFlat));
        trailHashMap.put("Lake Overlook Access",
                new Trail("Lake Overlook Access",
                        TrailCoords2.overlookLot, TrailCoords2.overlookPts, "", "icon_overlook", "overlook", "overlook",
                        "7755 Folsom-Auburn Rd",
                        "Commons Loon, Grebes, Rufous-crowned Sparrows, Phainopeplas",
                        "Lake, Bluffs, Oak Woodlands",
                        0, TrailBirds.overlook));
        trailHashMap.put("Willow Creek Access",
                new Trail("Willow Creek Access",
                        TrailCoords2.willowLot, TrailCoords2.willowPts, "", "icon_willow", "willow", "willow",
                        "13303 Folsom Blvd, Folsom, CA",
                        "Great Blue Heron, Great Egret, Double-Crested Cormorant Rookery",
                        "Lake, Creek, Woods",
                        0, TrailBirds.willow));
        trailHashMap.put("Negro Bar",
                new Trail("Negro Bar",
                        TrailCoords2.negroLot, TrailCoords2.negroPts, "", "icon_negro", "negro", "negro",
                        "American River Bike Trail, Orangevale, CA ",
                        "Waterbirds, Rufous-Crowned Sparrows",
                        "Lake, Oak Woodland, Gray Pine, Chaparral, Bluffs",
                        0, TrailBirds.negro));
        trailHashMap.put("Folsom Rodeo Grounds",
                new Trail("Folsom Rodeo Grounds",
                        TrailCoords2.rodeoLot, TrailCoords2.rodeoPts, "0.68 miles", "icon_rodeo", "rodeo", "rodeo",
                        "403 Stafford St, Folsom, CA",
                        "Waterbirds, Gulls, Cedar Waxwing",
                        "Lake, River, Creek, Riparian",
                        0, TrailBirds.rodeo));
        trailHashMap.put("Folsom Point",
                new Trail("Folsom Point",
                        TrailCoords2.folsomPointLot, TrailCoords2.folsomPointPts, "", "icon_folsomPoint", "folsomPoint", "folsomPoint",
                        "Folsom Lake State Recreation Area",
                        "Waterbirds, Bluebirds, California Thrashers, Yellow-breasted Chats",
                        "Lake, Oak Woodland, Chaparral",
                        0, TrailBirds.folsomPoint));
        trailHashMap.put("Mormon Island Preserve",
                new Trail("Mormon Island Preserve",
                        TrailCoords2.mormonPreserveLot, TrailCoords2.mormonPreservePts, "1.15 miles", "icon_mormonPreserve", "mormonPreserve", "mormonPreserve",
                        "Folsom Lake State Recreation Area",
                        "Waterbirds, Bluebirds, California Thrashers, Yellow-breasted Chats",
                        "Lake, Oak Woodland, Chaparral",
                        0, TrailBirds.folsomPoint));
        trailHashMap.put("Mormon Island Lake Access",
                new Trail("Mormon Island Lake Access",
                        TrailCoords2.mormonLakeLot, TrailCoords2.mormonLakePts, "0.8 miles", "icon_mormonLake", "mormonLake", "mormonLake",
                        "Folsom Lake State Recreation Area",
                        "Waterbirds, Bluebirds, California Thrashers, Yellow-breasted Chats",
                        "Lake, Oak Woodland, Chaparral",
                        0, TrailBirds.folsomPoint));
        trailHashMap.put("Brown’s Ravine",
                new Trail("Brown’s Ravine",
                        TrailCoords2.brownsLot, TrailCoords2.brownsPts, "", "icon_browns", "browns", "browns",
                        "Folsom Lake State Recreation Area",
                        "Waterbirds, Bluebirds, California Thrashers, Yellow-breasted Chats",
                        "Lake, Oak Woodland, Chaparral",
                        0, TrailBirds.folsomPoint));
        trailHashMap.put("Falcon Crest Lane",
                new Trail("Falcon Crest Lane",
                        TrailCoords2.falconLot, TrailCoords2.falconPts, "", "icon_falcon", "falcon", "falcon",
                        "Folsom Lake State Recreation Area",
                        "Waterbirds, Bluebirds, California Thrashers, Yellow-breasted Chats",
                        "Lake, Oak Woodland, Chaparral",
                        4, TrailBirds.folsomPoint));
        trailHashMap.put("Sweetwater Creek",
                new Trail("Sweetwater Creek",
                        TrailCoords2.sweetwaterCreekLot, TrailCoords2.sweetwaterCreekPts, "", "icon_sweetwaterCreek", "sweetwaterCreek", "sweetwaterCreek",
                        "Folsom Lake State Recreation Area",
                        "Waterbirds, Bluebirds, California Thrashers, Yellow-breasted Chats",
                        "Lake, Oak Woodland, Chaparral",
                        4, TrailBirds.sweetwater));
        trailHashMap.put("Sweetwater Trail",
                new Trail("Sweetwater Trail",
                        TrailCoords2.sweetwaterTrailLot, TrailCoords2.sweetwaterTrailPts, "", "icon_sweetwaterTrail", "sweetwaterTrail", "sweetwaterTrail",
                        "Folsom Lake State Recreation Area",
                        "Waterbirds, Bluebirds, California Thrashers, Yellow-breasted Chats",
                        "Lake, Oak Woodland, Chaparral",
                        4, TrailBirds.folsomPoint));
        trailHashMap.put("Beal’s Point",
                new Trail("Beal’s Point",
                        TrailCoords2.bealsLot, TrailCoords2.bealsPts, "", "icon_beals", "beals", "beals",
                        "7806 Folsom Auburn Road, Folsom, CA ",
                        "Gulls, Rock Wrens, Rufous-crowned Sparrows",
                        "Lake",
                        0, TrailBirds.beals));
//        trailHashMap.put("Granite Bay Entrance",
//                new Trail("Granite Bay Entrance",
//                        TrailCoords2.graniteLot, TrailCoords2.granitePts, "", "icon_granite", "granite", "granite",
//                        "TBA",
//                        "TBA",
//                        "TBA",
//                        false, false, TrailBirds.granite));
        trailHashMap.put("Beek’s Bight",
                new Trail("Beek’s Bight",
                        TrailCoords2.beeksLot, TrailCoords2.beeksPts, "", "icon_beeks", "beeks", "beeks",
                        "Park Rd, Granite Bay, CA 95746",
                        "Hummingbirds, Rock Wrens, Chats, Common Poorwills",
                        "Live Oak, Gray Pine, Blue Oak, Rock Outcroppings",
                        0, TrailBirds.beeks));
        trailHashMap.put("Pioneer Express Trail",
                new Trail("Pioneer Express Trail",
                        TrailCoords2.pioneerLot, TrailCoords2.pioneerPts, "", "icon_pioneer", "pioneer", "pioneer",
                        "7806 Auburn-Folsom Road, Folsom, CA ",
                        "Bald Eagles, Osprey, California Quail, Anna’s Hummingbird",
                        "Water Features, Oak Woodlands, Chaparral",
                        4, TrailBirds.pioneer));
        trailHashMap.put("Folsom Lake Peninsula",
                new Trail("Folsom Lake Peninsula",
                        TrailCoords2.folsomPeninsulaLot, TrailCoords2.folsomPeninsulaPts, "0.67 miles", "icon_folsomPeninsula", "folsomPeninsula", "folsomPeninsula",
                        "From Pilot Hill on Highway 49",
                        "Phainopeplas, Rock Wrens, Bald Eagles, Burrowing Owls",
                        "Lake, Chaparral, Oak Woodland",
                        0, TrailBirds.folsomPeninsula));

        ///////////////////////////////////////

        trailHashMap.put("Brewer Road",
                new Trail("Brewer Road",
                        TrailCoords2.brewerLot, TrailCoords2.brewerPts, "12.04 miles", "icon_brewer", "brewer", "brewer",
                        "Near Lincoln Wastewater Plant",
                        "Raptors, Snow Geese, Tundra Swans, Lark,  Longspurs, Ibis",
                        "Fields, Riparian, Water Features",
                        5, TrailBirds.brewer));
        trailHashMap.put("Bobelaine Audobon Sanctuary",
                new Trail("Bobelaine Audobon Sanctuary",
                        TrailCoords2.bobelaineLot, TrailCoords2.bobelainePts, "0.53 miles\u00b2", "icon_", "bobelaine", "bobelaine",
                        "Nicolaus, California",
                        "Swainson’s Hawks, Great Horned Owls, Herons, Egrets",
                        "Riparian Forest Habitat, Oak Woodland, Sycamores",
                        2, TrailBirds.bobelaine));
        trailHashMap.put("Sand Creek Road",
                new Trail("Sand Creek Road",
                        TrailCoords3.sandCreekLot, TrailCoords3.sandCreekPts, "14.81 miles", "icon_sandCreek", "sandCreek", "sandCreek",
                        "Sand Creek Road, Colusa County",
                        "Yellow-billed Magpies, Greater Roadrunner, Golden Eagles",
                        "Valley Oak Woodlands, Chaparral",
                        5, TrailBirds.sandCreek));
        trailHashMap.put("Bear Valley",
                new Trail("Bear Valley",
                        TrailCoords3.bearValleyLot, TrailCoords3.bearValleyPts, "21.99 miles", "icon_bearValley", "bearValley", "bearValley",
                        "Bear Valley Road Right Off Highway 16",
                        "Greater Roadrunner, Yellow-billed Magpies, Golden Eagles",
                        "Grasslands, Perennial Creek, Riparian, Chaparral",
                        5, TrailBirds.bearValley));
        trailHashMap.put("Gray Lodge Wildlife Area",
                new Trail("Gray Lodge Wildlife Area",
                        TrailCoords2.grayLodgeLot, TrailCoords2.grayLodgePts, "", "icon_grayLodge", "grayLodge", "grayLodge",
                        "3207 Rutherford Road, Gridley",
                        "Snow Geese, Ross's Geese Virginia Rail, Sora Rails, Ducks, Hawks",
                        "Marshlands",
                        4, TrailBirds.grayLodge));
        trailHashMap.put("Woodbridge Ecological Reserve",
                new Trail("Woodbridge Ecological Reserve",
                        TrailCoords2.woodbridgeEcoLot, TrailCoords2.woodbridgeEcoPts, "", "icon_woodbridgeEco", "woodbridgeEco", "woodbridgeEco",
                        "W Woodbridge Rd, Lodi, CA",
                        "Sandhill Cranes",
                        "Flooded Fields",
                        0, TrailBirds.woodbridgeEco));
        trailHashMap.put("Staten Island",
                new Trail("Staten Island",
                        TrailCoords2.statenLot, TrailCoords2.statenPts, "1.4 miles", "icon_staten", "staten", "staten",
                        "Island in the Sacramento-San Joaquin River Delta",
                        "Sandhill Cranes, Waterfowl",
                        "Flooded Fields",
                        5, TrailBirds.staten));
        trailHashMap.put("Woodbridge Regional Park",
                new Trail("Woodbridge Regional Park",
                        TrailCoords2.woodbridgeParkLot, TrailCoords2.woodbridgeParkPts, "", "icon_woodbridgePark", "woodbridgePark", "woodbridgePark",
                        "301 River Meadows Drive in Woodbridge",
                        "Wood Duck, Common Merganser, Hawks, Owl, Woodpeckers, Lazuli Bunting",
                        "Riparian Woodlands, River, Riparian Bush",
                        4, TrailBirds.woodbridgePark));
        trailHashMap.put("Lodi Lake",
                new Trail("Lodi Lake",
                        TrailCoords2.lodiLot, TrailCoords2.lodiPts, "0.52 miles", "icon_lodi", "lodi", "lodi",
                        "1101 W Turner Rd, Lodi",
                        "Shore Birds, Gulls, Ducks, Swift’s, Orioles, Raptors, Kingbird",
                        "Lake, Riparian, Open Woodlands, Grasslands",
                        0, TrailBirds.lodi));
        trailHashMap.put("Lake Solano Park",
                new Trail("Lake Solano Park",
                        TrailCoords2.solanoLot, TrailCoords2.solanoPts, "0.36 miles", "icon_solano", "solano", "solano",
                        "8685 Pleasants Valley Rd, Winters",
                        "Swainson's Hawks, Osprey, Great Horned Owls, Sapsucker",
                        "Riparian Habitat, Farmland, Fields, Lake, Creek",
                        0, TrailBirds.solano));
        trailHashMap.put("Stebbins Cold Canyon Reserve",
                new Trail("Stebbins Cold Canyon Reserve",
                        TrailCoords2.stebbinsLot, TrailCoords2.stebbinsPts, "0.23 miles", "icon_stebbins", "stebbins", "stebbins",
                        "CA-128, Winters, CA",
                        "Eagles, Western Bluebirds, Hawks, Owls, Swifts, Hummingbirds, Grosbeaks, Buntings, Poorwills",
                        "Riparian Oak, Scrub Woodland",
                        0, TrailBirds.stebbins));
        trailHashMap.put("Robinson Road",
                new Trail("Robinson Road",
                        TrailCoords3.robinsonLot, TrailCoords3.robinsonPts, "17.19 miles", "icon_robinson", "robinson", "robinson",
                        "South through Dixon",
                        "Hawks, Eagles, Falcons, Merlins, Mountain Plovers, Larks, Curlew, Shrikes, Pipits",
                        "Eucalyptus, Trees, Grasslands",
                        5, TrailBirds.robinson));
        trailHashMap.put("Lagoon Valley Regional Park",
                new Trail("Lagoon Valley Regional Park",
                        TrailCoords3.lagoonLot, TrailCoords3.lagoonPts, "1.34 miles", "icon_lagoon", "lagoon", "lagoon",
                        "Off Interstate 80 in Vacaville",
                        "Migrants, Songbirds, Pileated Woodpecker",
                        "Reservoir, Trees, Creek, Riparian",
                        0, TrailBirds.lagoon));
        trailHashMap.put("New York Creek, El Dorado Hills",
                new Trail("New York Creek, El Dorado Hills",
                        TrailCoords3.newYorkLot, TrailCoords3.newYorkPts, "1.14 miles", "icon_newYork", "newYork", "newYork",
                        "Francisco Drive in El Dorado Hills",
                        "Thrush, Hutton’s Vireo, Yellow-rumped Warbler, Sparrows, Acorn Woodpecker",
                        "Steam, Riparian, Poison Oak, Grassland",
                        0, TrailBirds.newYork));
        trailHashMap.put("Cronan Ranch Regional Trails Park",
                new Trail("Cronan Ranch Regional Trails Park",
                        TrailCoords3.cronanLot, TrailCoords3.cronanPts, "", "icon_cronan", "cronan", "cronan",
                        "State Highway 49 and the South Fork American River",
                        "Cooper’s Hawk, Band-tailed Pigeon, Acorn Woodpecker, Nuttall’s Woodpecker",
                        "Oak Woodland, Rolling Grasslands, Chaparral, Coniferous Forest",
                        4, TrailBirds.cronan));
        trailHashMap.put("Greenwood Unit",
                new Trail("Greenwood Unit",
                        TrailCoords3.greenwoodLot, TrailCoords3.greenwoodPts, "", "icon_greenwood", "greenwood", "greenwood",
                        "State Highway 49 and the South Fork American River",
                        "Cooper’s Hawk, Band-tailed Pigeon, Acorn Woodpecker, Nuttall’s Woodpecker,",
                        "Oak Woodland, Rolling Grasslands, Chaparral, Coniferous Forest",
                        4, TrailBirds.greenwood));
        trailHashMap.put("Marshall Gold Discovery State Historic Park",
                new Trail("Marshall Gold Discovery State Historic Park",
                        TrailCoords3.marshallLot, TrailCoords3.marshallPts, "", "icon_marshall", "marshall", "marshall",
                        "310 Back St, Coloma",
                        "Cooper’s Hawk, Band-tailed Pigeon, Acorn Woodpecker, Nuttall’s Woodpecker",
                        "Oak Woodland, Rolling Grasslands, Chaparral, Coniferous Forest",
                        4, TrailBirds.marshall));
        trailHashMap.put("Dave Moore Nature Area",
                new Trail("Dave Moore Nature Area",
                        TrailCoords3.daveLot, TrailCoords3.davePts, "", "icon_dave", "dave", "dave",
                        "CA-49, Lotus, CA",
                        "Cooper’s Hawk, Band-tailed Pigeon, Acorn Woodpecker, Nuttall’s Woodpecker",
                        "Oak Woodland, Rolling Grasslands, Chaparral, Coniferous Forest",
                        4, TrailBirds.dave));
        trailHashMap.put("Old Stage Road Trailhead",
                new Trail("Old Stage Road Trailhead",
                        TrailCoords3.oldStageLot, TrailCoords3.oldStagePts, "", "icon_oldStage", "oldStage", "oldStage",
                        "Auburn State Recreation Area",
                        "Hawks, Common Mergansers",
                        "Oak Woodland, Riverine",
                        4, TrailBirds.oldStage));
        trailHashMap.put("Old Foresthill Road",
                new Trail("Old Foresthill Road",
                        TrailCoords3.oldForesthillLot, TrailCoords3.oldForesthillPts, "", "icon_oldForesthill", "oldForesthill", "oldForesthill",
                        "Auburn State Recreation Area",
                        "Hawks, Common Mergansers",
                        "River, Creek, Douglas Firs",
                        4, TrailBirds.noBirds));
        trailHashMap.put("Old Quarry Road",
                new Trail("Old Quarry Road",
                        TrailCoords3.oldQuarryLot, TrailCoords3.oldQuarryPts, "", "icon_oldQuarry", "oldQuarry", "oldQuarry",
                        "Auburn State Recreation Area",
                        "Hawks, Common Mergansers",
                        "Oak Woodland, Riverine",
                        4, TrailBirds.noBirds));
        trailHashMap.put("No Hands Bridge",
                new Trail("No Hands Bridge",
                        TrailCoords3.noHandsLot, TrailCoords3.noHandsPts, "", "icon_noHands", "oldForesthill", "noHands",
                        "Auburn State Recreation Area",
                        "Hawks, Common Mergansers",
                        "Oak Woodland, Riverine",
                        0, TrailBirds.noHands));
        trailHashMap.put("Lake Clementine",
                new Trail("Lake Clementine",
                        TrailCoords3.clementineLot, TrailCoords3.clementinePts, "", "icon_clementine", "clementine", "clementine",
                        "Auburn State Recreation Area",
                        "Hawks, Common Mergansers",
                        "Riverine, Chaparral",
                        4, TrailBirds.clementine));
        trailHashMap.put("Driver’s Flat",
                new Trail("Driver’s Flat",
                        TrailCoords3.driversLot, TrailCoords3.driversPts, "", "icon_drivers", "drivers", "drivers",
                        "Auburn State Recreation Area",
                        "Yellow-breasted Chats, Band-tailed Pigeons",
                        "Riverine, Woodlands",
                        0, TrailBirds.drivers));
        trailHashMap.put("Mosquito Ridge Road",
                new Trail("Mosquito Ridge Road",
                        TrailCoords3.mosquitoLot, TrailCoords3.mosquitoPts, "6.27 miles", "icon_mosquito", "mosquito", "mosquito",
                        "Town of Foresthill",
                        "Flammulated Owls, Spotted Owls, Black Swifts",
                        "Sierran Habitat",
                        5, TrailBirds.mosquito));
        trailHashMap.put("Riverton-Crystal Basin Area",
                new Trail("Riverton-Crystal Basin Area",
                        TrailCoords3.rivertonLot, TrailCoords3.rivertonPts, "", "icon_riverton", "riverton", "riverton",
                        "Ice House Road east of Pollock Pines",
                        "Montane Habitats",
                        "Rufous Hummingbird, Western Kingbird, Vaux’s Swift",
                        5, TrailBirds.riverton));


        /////////////////////
        trailHashMap.put("Yolo Wildlife Area",
                new Trail("Yolo Wildlife Area",
                        TrailCoords3.yoloLot, TrailCoords3.yoloPts, "", "icon_yolo", "yolo", "yolo",
                        "45211 County Road 32B (Chiles Road)",
                        "American White Pelicans, Peregrine Falcon, Merlin, Swallows",
                        "Wetlands, Riparian Woodland, Grassland",
                        4, TrailBirds.yolo));
        trailHashMap.put("Wood Ducks Pond",
                new Trail("Wood Ducks Pond",
                        TrailCoords3.woodDucksLot, TrailCoords3.woodDucksPts, "0.03 miles\u00b2", "icon_woodDucks", "woodDucks", "woodDucks",
                        "South River Road West of the Sacramento River",
                        "Wood Ducks, Migrants, Warblers, Songbirds",
                        "Riparian, Ponds",
                        2, TrailBirds.woodDucks));
        trailHashMap.put("Babel Slough Road",
                new Trail("Babel Slough Road",
                        TrailCoords3.babelLot, TrailCoords3.babelPts, "0.49 miles", "icon_babel", "babel", "babel",
                        "Babel Slough Road 0.2 miles West of South River Road",
                        "Empidonax Flycatchers, Chestnut-Sided Warbler, Ovenbird, Rose-Breasted Grosbeak",
                        "Water Feature, Trees",
                        0, TrailBirds.babel));
        trailHashMap.put("UCD, Davis Arboretum",
                new Trail("UCD, Davis Arboretum",
                        TrailCoords3.arboretumLot, TrailCoords3.arboretumPts, "0.03 miles\u00b2", "icon_arboretum", "arboretum", "arboretum",
                        "448 La Rue Rd, Davis, CA 95616",
                        "Red-Breasted Nuthatches, Scissor-Tailed Flycatcher, Red Crossbills",
                        "Trees, Regional Plantings, Creek",
                        2, TrailBirds.arboretum));
        trailHashMap.put("Putah Creek Riparian Preserve",
                new Trail("Putah Creek Riparian Preserve",
                        TrailCoords3.putahLot, TrailCoords3.putahPts, "", "icon_putah", "putah", "putah",
                        "436 Mrak Hall One Shields Avenue",
                        "Chestnut-Backed Chickadees, Black-Crowned Night-Herons, Snowy Egrets",
                        "Stream, Riparian and Grassland",
                        0, TrailBirds.noBirds));
        trailHashMap.put("Slide Hill Park",
                new Trail("Slide Hill Park",
                        TrailCoords3.slideLot, TrailCoords3.slidePts, "", "icon_slide", "slide", "slide",
                        "2850 Temple Dr, Davis, CA",
                        "Mountain Chickadee, Cassin’s Finch, Red Crossbill, Evening Grosbeak",
                        "Trees",
                        0, TrailBirds.slide));
        trailHashMap.put("North Pond",
                new Trail("North Pond",
                        TrailCoords3.northPondLot, TrailCoords3.northPondPts, "0.19 miles", "icon_northPond", "northPond", "northPond",
                        "3434 Anderson Road Davis",
                        "Dowitchers, Yellowlegs, Ruff",
                        "Wetlands, Trees",
                        0, TrailBirds.northPond));
        trailHashMap.put("North Davis Farms",
                new Trail("North Davis Farms",
                        TrailCoords3.northDavisLot, TrailCoords3.northDavisPts, "0.46 miles", "icon_northDavis", "northDavis", "northDavis",
                        "North Davis Farms Rd., Davis",
                        "Migratory Birds",
                        "Trees, Ponds",
                        1, TrailBirds.noBirds));
        trailHashMap.put("Wildhorse Golf Course",
                new Trail("Wildhorse Golf Course",
                        TrailCoords3.wildhorseLot, TrailCoords3.wildhorsePts, "0.31 miles", "icon_wildhorse", "wildhorse", "wildhorse",
                        "Northeast of the Wildhorse Golf Course, Davis",
                        "Burrowing Owls",
                        "Burrows, Fields, Stream",
                        0, TrailBirds.wildhorse));
        trailHashMap.put("Willow Bank Ditch",
                new Trail("Willow Bank Ditch",
                        TrailCoords3.willowBankLot, TrailCoords3.willowBankPts, "0.18 miles", "icon_willowBank", "willowBank", "willowBank",
                        "Lillard Ave at El Campo Ave or Ohlone Street",
                        "Winter Wrens",
                        "Trees",
                        0, TrailBirds.willowBank));
        trailHashMap.put("Davis Wastewater Treatment Plant",
                new Trail("Davis Wastewater Treatment Plant",
                        TrailCoords3.wastewaterLot, TrailCoords3.wastewaterPts, "0.9 miles", "icon_wastewater", "wastewater", "wastewater",
                        "2727 2nd St, Davis",
                        "Pintails, American Widgeons, Shovelers,Phalaropes, Plovers, Gulls",
                        "Sewage Ponds, Settling Ponds, Levees",
                        1, TrailBirds.wastewater));
        trailHashMap.put("City of Davis Wetlands",
                new Trail("City of Davis Wetlands",
                        TrailCoords3.wetlandsLot, TrailCoords3.wetlandsPts, "2.38 miles", "icon_wetlands", "wetlands", "wetlands",
                        "2727 2nd St, Davis",
                        "Shorebirds, Waterfowl, Northern Harriers, Marsh Wrens, Yellow-headed Blackbirds",
                        "Wetlands, Upland",
                        0, TrailBirds.wetlands));
        trailHashMap.put("Yolo Egret and Heron Rookery",
                new Trail("Yolo Egret and Heron Rookery",
                        TrailCoords3.rookeryLot, TrailCoords3.rookeryPts, "", "icon_rookery", "rookery", "rookery",
                        "Near Yolo County Landfill",
                        "Nesting Egrets, Herons",
                        "Eucalyptus Trees",
                        0, TrailBirds.rookery));
        trailHashMap.put("Woodland Waste Water Treatment Plant",
                new Trail("Woodland Waste Water Treatment Plant",
                        TrailCoords3.woodlandLot, TrailCoords3.woodlandPts, "", "icon_woodland", "woodland", "woodland",
                        "Road 24 opposite Gibson Road",
                        "Shorebirds, Gulls, Pacific Golden-Plovers,  Semipalmated Sandpipers, Baird’s Sandpipers",
                        "Ponds",
                        0, TrailBirds.woodland));
        trailHashMap.put("Dunnigan Hills, Longspur Corner",
                new Trail("Dunnigan Hills, Longspur Corner",
                        TrailCoords3.dunniganLot, TrailCoords3.dunniganPts, "7.0 miles", "icon_dunnigan", "dunnigan", "dunnigan",
                        "Rds 16 and 90B are \"Longspur Corner\"",
                        "Golden Eagle, Northern Harrier, Hawks, Merlin,  Prairie Falcon, Burrowing Owls",
                        "Rolling Hills",
                        5, TrailBirds.dunnigan));
        trailHashMap.put("Rayhouse Road",
                new Trail("Rayhouse Road",
                        TrailCoords3.rayhouseLot, TrailCoords3.rayhousePts, "0.35 miles", "icon_rayhouse", "rayhouse", "rayhouse",
                        "5 Miles past Capay Valley",
                        "Common Poorwill, Mountain Quail, Sage Sparrow, Lawrence’s Goldfinch,  Pileated Woodpeckers",
                        "Steep Mountains, Oak Woodlands, Riparian, Chaparral",
                        5, TrailBirds.rayhouse));



    }
}