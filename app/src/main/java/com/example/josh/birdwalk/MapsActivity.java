package com.example.josh.birdwalk;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TrailData trailData;
    Trail currTrail;
    String trailName;
    Toolbar toolbar;
    public final static String EXTRA_TRAILKEY = "com.example.josh.birdwalk.TRAIL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }

        trailData = TrailData.getInstance();

        Intent intent = this.getIntent();
        if (intent !=null){
            String intentString = intent.getExtras().getString("fromActivity");

            if(intentString.equals("MainActivity")){
//                toolbar = (Toolbar) findViewById(R.id.toolbar);
//                toolbar.setTitle("Map Overview");
//                setSupportActionBar(toolbar);
                showAllTrails();
            }
            if(intentString.equals("TrailActivity")){
                trailName = intent.getStringExtra(TrailActivity.EXTRA_TRAILKEY);
                currTrail = trailData.getValue(trailName);
//                toolbar = (Toolbar) findViewById(R.id.toolbar);
//                toolbar.setTitle(trailName);
//                setSupportActionBar(toolbar);
                showSelectedTrail();
            }
        }
    }


    //display all trail markers on map
    public void showAllTrails(){
        Map<String, Trail> map = trailData.trailHashMap;

        //calculate the avg lat/lng of all markers
        Double avgLat = 0.0;
        Double avgLng = 0.0;
        int numTrails = 0;

        //add each trail marker to map
        for (Map.Entry<String, Trail> entry : map.entrySet()) {
            String title = entry.getKey();
            Trail trail = entry.getValue();
            LatLng start = trail.getStart();

            avgLat += start.latitude;
            avgLng += start.longitude;
            numTrails += 1;

            mMap.addMarker(new MarkerOptions().position(start).title(title));
        }

        //center the camera to the avg position
        avgLat = avgLat/numTrails;
        avgLng = avgLng/numTrails;
        LatLng CENTER = new LatLng(avgLat, avgLng);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTER, 11));

        //launch trailActivity for clicked on marker
        mMap.setOnInfoWindowClickListener(
                new GoogleMap.OnInfoWindowClickListener(){
                    public void onInfoWindowClick(Marker marker){
                        Intent intent = new Intent(MapsActivity.this,TrailActivity.class);
                        intent.putExtra(EXTRA_TRAILKEY, marker.getTitle());
                        startActivity(intent);
                    }
                }
        );

    }

    //add the trail's polyline onto the map
    public void showSelectedTrail(){
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //calculate the avg lat/lng of the trail markers
        Double avgLat = 0.0;
        Double avgLng = 0.0;

        //add points to the polyline
        int numPoints = currTrail.points.length;
        mMap.addMarker(new MarkerOptions().position(currTrail.lotPoint).title("Parking Lot"));
        mMap.addMarker(new MarkerOptions().position(currTrail.points[0]).title("Trail Start"));
        PolylineOptions TrailPoints = new PolylineOptions().color(Color.GREEN).width(5);
        for (int i = 0; i < numPoints; i++){
            TrailPoints.add(currTrail.points[i]);
            avgLat += currTrail.points[i].latitude;
            avgLng += currTrail.points[i].longitude;
        }
        mMap.addPolyline(TrailPoints);

        //center the camera to the avg position
        avgLat += currTrail.lotPoint.latitude;
        avgLng += currTrail.lotPoint.longitude;
        avgLat = avgLat/(numPoints+1);
        avgLng = avgLng/(numPoints+1);
        LatLng CENTER = new LatLng(avgLat, avgLng);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTER, 15));
    }

}
