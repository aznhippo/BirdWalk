package com.example.josh.birdwalk;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Map;

public class MapActivity extends AppCompatActivity {

    private GoogleMap mMap;
    TrailData trailData;
    Trail trail;
    String trailName;
    Toolbar toolbar;
    String intentString;


     /* Request code for location permission request.
      * @see #onRequestPermissionsResult(int, String[], int[])   */
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        setUpMapIfNeeded();

        trailData = TrailData.getInstance();
        Intent intent = this.getIntent();
        if (intent != null) {
            intentString = intent.getExtras().getString("fromActivity");

            if (intentString.equals("MainActivity")) {
                toolbar = (Toolbar) findViewById(R.id.toolbar);
                toolbar.setTitle("Map Overview");
                setSupportActionBar(toolbar);
                showAllTrails();
            }
            if (intentString.equals("TrailActivity")) {
                trailName = intent.getExtras().getString("trailKey");
                trail = trailData.getValue(trailName);
                toolbar = (Toolbar) findViewById(R.id.toolbar);
                toolbar.setTitle(trailName);
                setSupportActionBar(toolbar);
                showSelectedTrail();
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (intentString.equals("MainActivity"))
            getMenuInflater().inflate(R.menu.menu_map, menu);
        if (intentString.equals("TrailActivity"))
            getMenuInflater().inflate(R.menu.menu_trail_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.normal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            case R.id.satellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.terrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;

            case R.id.directions:
                //convert the starting latlng into a string
                LatLng lotPoint = trail.getLotPoint();
                Double lat = lotPoint.latitude;
                Double lng = lotPoint.longitude;
                String latString = lat.toString();
                String lngString = lng.toString();
                String uriString = "google.navigation:q=".concat(latString).concat(",").concat(lngString);

                //launch navigation to trail in Google Maps Apps
                Uri gmmIntentUri = Uri.parse(uriString);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
//            showMissingPermissionError();
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        //https://github.com/googlemaps/android-samples/blob/master/ApiDemos/app/src/main/java/com/example/mapdemo/MyLocationDemoActivity.java
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            mMap.setMyLocationEnabled(true);
        } else {
            // Display the missing permission error dialog when the fragments resume.
        }
    }

    public void showAllTrails(){
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        Map<String, Trail> map = trailData.trailHashMap;

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //add each trail marker to map
        for (Map.Entry<String, Trail> entry : map.entrySet()) {
            String title = entry.getKey() + "   \u27A4";
            Trail trail = entry.getValue();
            LatLng start = trail.getStart();
            String dist = trail.getDistance();
            mMap.addMarker(new MarkerOptions().position(start).title(title).snippet(dist));

            builder.include(start);
        }

        //center to bounds, zoom when map loaded
        LatLngBounds bounds = builder.build();
        int padding = 100; // offset from edges of the map in pixels
        final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bounds.getCenter(), 10));
        mMap.getUiSettings().setAllGesturesEnabled(false);
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.animateCamera(cu, new GoogleMap.CancelableCallback() {
                    @Override
                    public void onFinish() {
                        mMap.getUiSettings().setAllGesturesEnabled(true);
                    }

                    @Override
                    public void onCancel() { mMap.getUiSettings().setAllGesturesEnabled(true); }
                });
            }
        });

        //launch trailActivity for clicked on marker
        mMap.setOnInfoWindowClickListener(
                new GoogleMap.OnInfoWindowClickListener() {
                    public void onInfoWindowClick(Marker marker) {
                        String str = marker.getTitle();
                        String trailName = str.substring(0, str.length() - 4);
                        Intent intent = new Intent(MapActivity.this, TrailActivity.class);
                        intent.putExtra("trailKey", trailName);
                        startActivity(intent);
                    }
                }
        );

    }


    public void showSelectedTrail(){
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.addMarker(new MarkerOptions().position(trail.getStart()).title("Start")).showInfoWindow();
        if (!trail.lotIsStart())
            mMap.addMarker(new MarkerOptions().position(trail.getLotPoint()).title("Parking"));

        //trail only has 1 point
        if (trail.getPoints().length == 1){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(trail.getStart(), 15));
        }
        //special case, disjointed points
        else if (trail.getTrailName().equals("Green Haven Lake")){
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            int numPoints = trail.getPoints().length;
            LatLng[] points = trail.getPoints();
            for (int i = 0; i < numPoints; i++) {
                mMap.addMarker(new MarkerOptions().position(points[i]).title("View Point #" + (i+1)));
                builder.include(points[i]);
            }
            LatLngBounds bounds = builder.build();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bounds.getCenter(), 14));

        }
        //trail has multiple points
        else {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            int numPoints = trail.getPoints().length;
            LatLng[] points = trail.getPoints();

            //polygon or polyline
            if (trail.isArea()){
                PolygonOptions trailPolygon = new PolygonOptions().fillColor(0x7F00FF00)
                        .strokeColor(Color.GREEN).strokeWidth(0);
                for (int i = 0; i < numPoints; i++) {
                    trailPolygon.add(points[i]);
                    builder.include(points[i]);
                }
                mMap.addPolygon(trailPolygon);
            } else {
                PolylineOptions trailLine = new PolylineOptions().color(Color.GREEN).width(5);
                for (int i = 0; i < numPoints; i++) {
                    trailLine.add(points[i]);
                    builder.include(points[i]);
                }
                mMap.addPolyline(trailLine);
            }

            //center to bounds, zoom when map loaded
            LatLngBounds bounds = builder.build();
            //int padding = 200; // offset from edges of the map in pixels
            //final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bounds.getCenter(), 14));
//            mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
//                @Override
//                public void onMapLoaded() {
//                    mMap.animateCamera(cu);
//                }
//            });
        }
    }
}
