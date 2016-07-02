package com.jle.josh.birdwalk;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapActivity extends AppCompatActivity {
    private GoogleMap mMap;
    Trail trail;
    String trailName;
    Toolbar toolbar;
    String intentString;

    Map<String, Trail> trailMap;
    ArrayList<Trail> trailList;


     /* Request code for location permission request.
      * @see #onRequestPermissionsResult(int, String[], int[])   */
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.search_text);
        Button clearBtn = (Button) findViewById(R.id.clear_search);

        trailMap = TrailData.trailHashMap;

        setUpMapIfNeeded();
        Intent intent = this.getIntent();
        if (intent != null) {
            intentString = intent.getExtras().getString("fromActivity");
            if (intentString.equals("MainActivity")) {
                toolbar = (Toolbar) findViewById(R.id.toolbar);
                toolbar.setTitle("Map Overview");
                setSupportActionBar(toolbar);
                ImageButton legend = (ImageButton) findViewById(R.id.legend);
                legend.setVisibility(View.VISIBLE);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);

                trailList = new ArrayList<Trail>(TrailData.trailHashMap.values());

                setUpSearchField();
                showTrails(false);
            }
            else if (intentString.equals("TrailActivity")) {
                actv.setVisibility(View.GONE);
                clearBtn.setVisibility(View.GONE);
                trailName = intent.getExtras().getString("trailKey");
                trail = TrailData.getValue(trailName);
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

    public void showTrails(boolean searched){
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.marker_info, null);
                TextView title = (TextView) v.findViewById(R.id.trailName);
                TextView lengthText = (TextView) v.findViewById(R.id.trailLength);
                ImageView len_icon = (ImageView) v.findViewById(R.id.len_icon);
                title.setText(marker.getTitle());

                Trail t = TrailData.getValue(marker.getTitle());
                int typeCode = t.getTypeCode();

                switch (typeCode) {
                    case 0: if (t.singlePoint()){
                        len_icon.setImageResource(R.drawable.icon_pin);
                        lengthText.setText("   Birding Viewpoint");
                    }
                    else {
                        len_icon.setImageResource(R.drawable.icon_oneway_1);
                        lengthText.setText("   ".concat(t.getLength()));
                    }
                        break;
                    case 1: len_icon.setImageResource(R.drawable.icon_loop_1);
                            lengthText.setText("   ".concat(t.getLength()));
                            break;
                    case 2: len_icon.setImageResource(R.drawable.icon_area3_1);
                            lengthText.setText("   ".concat(t.getLength()));
                            break;
                    case 3: len_icon.setImageResource(R.drawable.icon_pin);
                            lengthText.setText("   Birding Viewpoints");
                            break;
                    case 4: len_icon.setImageResource(R.drawable.icon_trailhead_1);
                            lengthText.setText("   Trailhead");
                            break;
                    case 5: len_icon.setImageResource(R.drawable.icon_drive_1);
                            lengthText.setText("   ".concat(t.getLength()));
                            break;
                }

                return v;
            }
        });


        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        //add each trail marker to map
        for (Trail entry : trailList) {
            LatLng start = entry.getStart();

            mMap.addMarker(new MarkerOptions().position(start).title(entry.getTrailName()));
            builder.include(start);
        }

        //launch trailActivity for clicked on marker
        mMap.setOnInfoWindowClickListener(
                new GoogleMap.OnInfoWindowClickListener() {
                    public void onInfoWindowClick(Marker marker) {
                        String trailName = marker.getTitle();
                        Intent intent = new Intent(MapActivity.this, TrailActivity.class);
                        intent.putExtra("trailKey", trailName);
                        startActivity(intent);
                    }
                }
        );

        //only change camera zoom for initialization
        if (!searched){
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
                        public void onCancel() {
                            mMap.getUiSettings().setAllGesturesEnabled(true);
                        }
                    });
                }
            });
        }


    }



    public void showSelectedTrail(){
        ImageButton legend = (ImageButton) findViewById(R.id.legend);
        legend.setVisibility(View.GONE);
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.addMarker(new MarkerOptions().position(trail.getStart()).title("Start")).showInfoWindow();
        if (!trail.lotIsStart())
            mMap.addMarker(new MarkerOptions().position(trail.getLotPoint()).title("Parking"));

        //trail only has 1 point
        if (trail.singlePoint()){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(trail.getStart(), 15));
        }
        //special case, disjointed points
        else if (trail.getTypeCode() == 3){
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (int i = 0; i < trail.numPoints(); i++) {
                mMap.addMarker(new MarkerOptions().position(trail.getPoints()[i])
                        .title("View Point #" + (i + 1)));
                builder.include(trail.getPoints()[i]);
            }
            LatLngBounds bounds = builder.build();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bounds.getCenter(), 14));
        }
        //trail has multiple points
        else {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            //polygon or polyline
            if (trail.getTypeCode() == 2){
                PolygonOptions trailPolygon = new PolygonOptions().fillColor(0x7F00FF00)
                        .strokeColor(Color.GREEN).strokeWidth(0);
                for (LatLng l : trail.getPoints()) {
                    trailPolygon.add(l);
                    builder.include(l);
                }
                mMap.addPolygon(trailPolygon);
            }
            else {
                PolylineOptions trailLine = new PolylineOptions().color(Color.GREEN).width(5);
                for (LatLng l : trail.getPoints()) {
                    trailLine.add(l);
                    builder.include(l);
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


    public void setUpSearchField(){
        //set up search field listeners
        final Button clearButton = (Button) findViewById(R.id.clear_search);
        clearButton.setVisibility(View.GONE);


        Set<String> keys = trailMap.keySet();
        String[] trails = keys.toArray(new String[keys.size()]);
        String[] birdsAndTrails = new String[trails.length + TrailBirds.allBirds.length];
        for (int i=0; i<trails.length;i++){
            birdsAndTrails[i] = trails[i];
        }
        int k = trails.length;
        for (int j=0; j<TrailBirds.allBirds.length; j++){
            birdsAndTrails[k] = TrailBirds.allBirds[j];
            k++;
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, birdsAndTrails);
        final AutoCompleteTextView input = (AutoCompleteTextView) findViewById(R.id.search_text);
        input.setAdapter(adapter);
        input.setThreshold(1);
        input.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);


        //hide button, when field is empty
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (input.getText().toString().equals(""))
                    clearButton.setVisibility(View.GONE);
                else
                    clearButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //perform search for selected suggestion
        input.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                performSearch(input.getText().toString());
                if (getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        });
        //perform search, hide keyboard when 'search' is clicked
        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            //perform search, and hide keyboard
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                performSearch(input.getText().toString());
                if (getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                return false;
            }
        });
    }

    //search trails for the query string
    public void performSearch(String query){
        trailList.clear();
        mMap.clear();

        //check each trail's title, birds
        for (Map.Entry<String, Trail> entry : trailMap.entrySet()) {
            String title = entry.getKey();
            String birds = entry.getValue().birdText();
            Boolean inTitle = title.toLowerCase().contains(query.toLowerCase());
            Boolean inBirds = birds.toLowerCase().contains(query.toLowerCase());
            if (inBirds || inTitle) {
                trailList.add(entry.getValue());
            }
        }

        showTrails(true);
    }

    //delete the editText field, and show all trails
    public void clearText(View v){
        EditText input = (EditText) findViewById(R.id.search_text);
        input.setText("");
        performSearch("");
    }


    public void showLegend(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.legend, null);
        builder.setView(v);
        AlertDialog ad = builder.create();
        ad.show();

    }
}
