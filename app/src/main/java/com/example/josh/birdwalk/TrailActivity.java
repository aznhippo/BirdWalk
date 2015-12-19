package com.example.josh.birdwalk;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TrailActivity extends AppCompatActivity {

    GoogleMap mMap;
    TrailData trailData;
    Trail trail;
    String trailName;
    Marker lastOpened = null;
    float distance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);

        Intent intent = getIntent();
        trailName = intent.getExtras().getString("trailKey");
        trailData = TrailData.getInstance();
        trail = trailData.getValue(trailName);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(trailName);
        setSupportActionBar(toolbar);

        Button button = (Button) this.findViewById(R.id.excerpt);
        button.setText("More About " + trailName);

        //if a trail pic exists, set it as the background image
        ImageView iv = (ImageView) this.findViewById(R.id.trail_image);
        try {
            Class res = R.drawable.class;
            Field field = res.getField(trail.getBgName());

            int drawableId = field.getInt(null);
            iv.setImageResource(drawableId);
        }
        catch (Exception e) {
            //Log.e("MyTag", "Failure to get drawable id.", e);
            iv.setImageResource(R.drawable.bg_trail);
        }

        setUpMapIfNeeded();
        setUpInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
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


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //suppress all map gestures
        //turn off current location button
        mMap.getUiSettings().setAllGesturesEnabled(false);
        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }

        //override the markerclicklistener
        //suppress automatic pan onclick
        //http://stackoverflow.com/questions/14497734/dont-snap-to-marker-after-click-in-android-map-v2
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                // Check if there is an open info window
                if (lastOpened != null) {
                    // Close the info window
                    lastOpened.hideInfoWindow();
                    // Is the marker the same marker that was already open
                    if (lastOpened.equals(marker)) {
                        // Nullify the lastOpened object
                        lastOpened = null;
                        // Return so that the info window isn't opened again
                        return true;
                    }
                }
                // Open the info window for the marker
                marker.showInfoWindow();
                // Re-assign the last opened such that we can close it later
                lastOpened = marker;
                // Event was handled by our code do not launch default behaviour.
                return true;
            }
        });
        //override click and longclick listeners, direct to full page map
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng position) {
                Intent intent = new Intent(TrailActivity.this, MapActivity.class);
                intent.putExtra("trailKey", trailName);
                intent.putExtra("fromActivity", "TrailActivity");
                startActivity(intent);
            }
        });
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng position) {
                Intent intent = new Intent(TrailActivity.this, MapActivity.class);
                intent.putExtra("trailKey", trailName);
                intent.putExtra("fromActivity", "TrailActivity");
                startActivity(intent);
            }
        });

        createTrailLine();
    }

    private void createTrailLine(){
        mMap.addMarker(new MarkerOptions().position(trail.getStart()).title("Trail Start")).showInfoWindow();
        if (!trail.lotIsStart())
            mMap.addMarker(new MarkerOptions().position(trail.getLotPoint()).title("Parking"));


        //trail only has 1 point
        if (trail.getPoints().length == 1){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(trail.getStart(), 15));
        }
        //trail has multiple points
        else{
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            int numPoints = trail.getPoints().length;
            LatLng[] points = trail.getPoints();
            distance = 0;

            //polygon or polyline
            if (trail.getTrailName().equals("William Land Park")){
                PolygonOptions trailPolygon = new PolygonOptions().fillColor(0x7F00FF00)
                        .strokeColor(Color.GREEN).strokeWidth(0);
                for (int i = 0; i < numPoints; i++) {
                    trailPolygon.add(points[i]);
                    builder.include(points[i]);

                    if (i < numPoints - 1)
                        distance += distanceBetween(points[i], points[i + 1]);
                }
                mMap.addPolygon(trailPolygon);
            }
            else {
                PolylineOptions trailLine = new PolylineOptions().color(Color.GREEN).width(5);
                for (int i = 0; i < numPoints; i++) {
                    trailLine.add(points[i]);
                    builder.include(points[i]);

                    if (i < numPoints - 1)
                        distance += distanceBetween(points[i], points[i + 1]);
                }
                mMap.addPolyline(trailLine);
            }

            //center to bounds, zoom when map loaded
            LatLngBounds bounds = builder.build();
            int padding = 200; // offset from edges of the map in pixels
            final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bounds.getCenter(), 14));
            mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                @Override
                public void onMapLoaded() {
                    mMap.animateCamera(cu);
                }
            });

        }
    }

    private float distanceBetween(LatLng latLng1, LatLng latLng2) {
        Location loc1 = new Location(LocationManager.GPS_PROVIDER);
        Location loc2 = new Location(LocationManager.GPS_PROVIDER);
        loc1.setLatitude(latLng1.latitude);
        loc1.setLongitude(latLng1.longitude);
        loc2.setLatitude(latLng2.latitude);
        loc2.setLongitude(latLng2.longitude);
        return loc1.distanceTo(loc2);
    }

    private static double round(double value, int places) {
        //http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void setUpInfo(){
//        String addrString = "<b>"+"Address: "+"</b>" + trail.getAddress();
        String addrString = trail.getAddress();
        TextView tv1 = (TextView) findViewById(R.id.addrText);
        tv1.setText(Html.fromHtml(addrString));

        double miles = round(distance * .000621371,2);
        //String distString = "<b>"+"Trail Distance: "+"</b>"+Double.toString(miles)+" miles";
        String distString = Double.toString(miles)+" miles";
        TextView tv2 = (TextView) findViewById(R.id.distText);
        tv2.setText(Html.fromHtml(distString));

        //String birdsString = "<b>"+"Highlights: "+"</b>"+ trail.getBirds();
        String birdsString = trail.getBirds();
        TextView tv3 = (TextView) findViewById(R.id.birdsText);
        tv3.setText(Html.fromHtml(birdsString));

        //String typeString = "<b>"+"Habitats: "+"</b>"+ trail.getHabitats();
        String typeString = trail.getHabitats();
        TextView tv4 = (TextView) findViewById(R.id.typeText);
        tv4.setText(Html.fromHtml(typeString));
    }

    public void launchDirections(View view){
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
    }

    public void launchExcerpt(View view){
        Intent intent = new Intent(TrailActivity.this, InfoActivity.class);
        intent.putExtra("fromActivity", "TrailActivity");
        intent.putExtra("resName", trail.getExcName());
        intent.putExtra("trailName", trailName);
        startActivity(intent);
    }

}
