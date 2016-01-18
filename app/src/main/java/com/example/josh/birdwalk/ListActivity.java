package com.example.josh.birdwalk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
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
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

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



    public void setUpSearchField(){
        //set up search field listeners
        //final EditText input = (EditText) findViewById(R.id.search_text);
        //input.setTypeface(null, Typeface.ITALIC);
        final Button clearButton = (Button) findViewById(R.id.clear_search);
        clearButton.setVisibility(View.GONE);

        final AutoCompleteTextView input = (AutoCompleteTextView) findViewById(R.id.search_text);
        Set<String> keys = map.keySet();
        String[] trails = keys.toArray(new String[keys.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, trails);
        input.setAdapter(adapter);
        input.setThreshold(1);



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

                //performSearch(input.getText().toString());
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
            if (inBirds || inTitle){
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

    public void showLegend(View view){
        // custom dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.legend);
        dialog.setTitle("Icon Legend");
//
//        Button dialogButton = (Button) dialog.findViewById(R.id.dialogok);
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });

        dialog.show();
    }
}


class TrailAdapter extends ArrayAdapter<Trail> {
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
        if (trail.isLoop()){
            len_icon.setImageResource(R.drawable.icon_loop);
            holder.lengthText.setText("   ".concat(trail.getLength()));
        }
        else if (trail.isArea()){
            len_icon.setImageResource(R.drawable.icon_area3);
            holder.lengthText.setText("Birding Area");
        }
        else if (trail.singlePoint()){
            len_icon.setImageResource(R.drawable.icon_pin);
            holder.lengthText.setText("Birding Viewpoint");
        }
        //special case
        else if (trail.getTrailName().equals("Green Haven Lake")) {
            len_icon.setImageResource(R.drawable.icon_pin);
            holder.lengthText.setText("Birding Viewpoints");
        }
        else {
            //len_icon.setVisibility(View.GONE);
            len_icon.setImageResource(R.drawable.icon_oneway);
            holder.lengthText.setText("   ".concat(trail.getLength()));
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



