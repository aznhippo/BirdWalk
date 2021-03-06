package com.jle.josh.birdwalk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
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
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Josh
 * List of all trail activity
 * Shows all trails, allows users to search by trail name or bird
 */


public class ListActivity extends AppCompatActivity {
    ListView listView;
    TrailAdapter trailAdapter;
    Map<String, Trail> map;
    ArrayList<Trail> trailList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("List of Trails");
        setSupportActionBar(toolbar);

        map = TrailData.trailHashMap;
        trailList= new ArrayList<Trail>(TrailData.trailHashMap.values());
        Collections.sort(trailList, Trail.TrailComparatorName);

        //set listview to trailadapter using trailList
        trailAdapter = new TrailAdapter(this, R.layout.list_item, trailList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(trailAdapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Trail trail = (Trail) (listView.getItemAtPosition(position));
                Intent intent = new Intent(ListActivity.this, TrailActivity.class);
                intent.putExtra("trailKey", trail.getTrailName());
                startActivity(intent);
            }
        });

        setUpSearchField();
    }


    //set up the search bar
    public void setUpSearchField(){
        final Button clearButton = (Button) findViewById(R.id.clear_search);
        clearButton.setVisibility(View.GONE);

        // create array containing all trail and bird names
        Set<String> keys = map.keySet();
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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (input.getText().toString().equals(""))
                    clearButton.setVisibility(View.GONE);
                else
                    clearButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {}
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

        //check each trail's title, birds
        for (Map.Entry<String, Trail> entry : map.entrySet()) {
            String title = entry.getKey();
            String birds = entry.getValue().birdText();
            Boolean inTitle = title.toLowerCase().contains(query.toLowerCase());
            Boolean inBirds = birds.toLowerCase().contains(query.toLowerCase());
            if (inBirds || inTitle) {
                trailList.add(entry.getValue());
            }
        }
        Collections.sort(trailList, Trail.TrailComparatorName);
        trailAdapter.notifyDataSetChanged();

    }

    //delete the editText field, and show all trails
    public void clearText(View v){
        EditText input = (EditText) findViewById(R.id.search_text);
        input.setText("");
        performSearch("");
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
            case R.id.length:
                Collections.sort(trailList, Trail.TrailComparatorLength);
                trailAdapter.notifyDataSetChanged();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

    }

    //show the legend of icons
    public void showLegend(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.legend, null);
        builder.setView(v);
        AlertDialog ad = builder.create();
        ad.show();

    }

    //show the submit pics dialog
    public void showSubmit(View view){
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.submit_pics, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(v);
        AlertDialog ad = builder.create();
        ad.show();
    }

    //launch upload activity
    public void launchSubmit(View view){
        Intent intent = new Intent(this, UploadActivity.class);
        intent.putExtra("fromActivity", "ListActivity");
        startActivity(intent);
    }

    //array adapter for Trail class
    static class TrailAdapter extends ArrayAdapter<Trail> {
        private final Context context;
        private final ArrayList<Trail> data;
        private final int layoutResourceId;

        public TrailAdapter(Context context, int layoutResourceId, ArrayList<Trail> data) {
            super(context, layoutResourceId, data);
            this.context = context;
            this.data = data;
            this.layoutResourceId = layoutResourceId;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder = null;

            if(row == null) {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new ViewHolder();
                holder.lengthText = (TextView)row.findViewById(R.id.trailLength);
                holder.nameText = (TextView)row.findViewById(R.id.trailName);
                holder.trailIcon = (ImageView)row.findViewById(R.id.trailIcon);

                row.setTag(holder);
            }
            else {
                holder = (ViewHolder)row.getTag();
            }

            Trail trail = data.get(position);
            holder.nameText.setText(trail.getTrailName());

            //set length icon for loop, area, site, one-way
            ImageView len_icon = (ImageView)row.findViewById(R.id.len_icon);
            len_icon.setVisibility(View.VISIBLE);

            int typeCode = trail.getTypeCode();
            switch (typeCode) {
                case 0: if (trail.singlePoint()){
                            len_icon.setImageResource(R.drawable.icon_pin);
                            holder.lengthText.setText("   Birding Viewpoint");
                        }
                        else {
                            len_icon.setImageResource(R.drawable.icon_oneway);
                            holder.lengthText.setText("   ".concat(trail.getLength()));
                        }
                        break;
                case 1: len_icon.setImageResource(R.drawable.icon_loop);
                        holder.lengthText.setText("   ".concat(trail.getLength()));
                        break;
                case 2: len_icon.setImageResource(R.drawable.icon_area3);
                        holder.lengthText.setText("   ".concat(trail.getLength()));
                        break;
                case 3: len_icon.setImageResource(R.drawable.icon_pin);
                        holder.lengthText.setText("   Birding Viewpoints");
                        break;
                case 4: len_icon.setImageResource(R.drawable.icon_trailhead);
                        holder.lengthText.setText("   Trailhead");
                        break;
                case 5: len_icon.setImageResource(R.drawable.icon_drive);
                        holder.lengthText.setText("   ".concat(trail.getLength()));
                        break;
            }



            //if a trailicon exists, set it as the item image
            try {
                Class res = R.drawable.class;
                Field field = res.getField(trail.getIconName());
                int drawableId = field.getInt(null);
                holder.trailIcon.setImageResource(drawableId);
            }
            catch (Exception e) {
                //Log.e("MyTag", "Failure to get drawable id.", e);
                holder.trailIcon.setImageResource(R.drawable.icon_app);
            }

            return row;
        }

        static class ViewHolder {
            TextView lengthText;
            TextView nameText;
            ImageView trailIcon;
        }
    }
}






