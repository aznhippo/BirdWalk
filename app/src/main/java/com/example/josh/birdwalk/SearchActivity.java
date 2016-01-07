package com.example.josh.birdwalk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {
    TrailData trailData;
    ListView listView;
    TrailAdapter trailAdapter;
    Map<String, Trail> searchMap;
    ArrayList<Trail> trailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("List of Trails");
        setSupportActionBar(toolbar);

        searchMap = trailData.trailHashMap;

        trailList= new ArrayList<Trail>(trailData.trailHashMap.values());
        Collections.sort(trailList, Trail.TrailComparatorName);

        trailAdapter = new TrailAdapter(this, R.layout.list_item, trailList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(trailAdapter);



        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Trail trail = (Trail) (listView.getItemAtPosition(position));
                Intent intent = new Intent(SearchActivity.this, TrailActivity.class);
                intent.putExtra("trailKey", trail.getTrailName());
                startActivity(intent);
            }
        });


        EditText input = (EditText) findViewById(R.id.search_text);
        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                performSearch();

                return false;
            }
        });


    }

    public void performSearch(){
        EditText input = (EditText) findViewById(R.id.search_text);
        String query = input.getText().toString();
        trailList.clear();


        //check each trail's title, birds
        for (Map.Entry<String, Trail> entry : searchMap.entrySet()) {
            String title = entry.getKey();
            String birds = entry.getValue().getBirds();
            Boolean inTitle = title.toLowerCase().contains(query.toLowerCase());
            Boolean inBirds = birds.toLowerCase().contains(query.toLowerCase());
            if (inBirds || inTitle){
                trailList.add(entry.getValue());
            }
        }
        Collections.sort(trailList, Trail.TrailComparatorName);
        trailAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.alpha:
                Collections.sort(trailList, Trail.TrailComparatorName);
                trailAdapter.notifyDataSetChanged();
                return true;
            case R.id.dist:
                Collections.sort(trailList, Trail.TrailComparatorDist);
                trailAdapter.notifyDataSetChanged();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }
}


