package com.example.josh.birdwalk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class ListActivity extends AppCompatActivity {
    TrailData trailData;
    ListView listView;
    ArrayList<Trail> trailList;
    TrailAdapter trailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("List of Trails");
        setSupportActionBar(toolbar);

        //put trails into arraylist, sort alpha
        trailList = new ArrayList<Trail>(trailData.trailHashMap.values());
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
            holder.distText = (TextView)row.findViewById(R.id.trailDistance);
            holder.nameText = (TextView)row.findViewById(R.id.trailName);
            holder.trailIcon = (ImageView)row.findViewById(R.id.trailIcon);

            row.setTag(holder);
        }
        else {
            holder = (ViewHolder)row.getTag();
        }

        Trail trail = data.get(position);
        holder.distText.setText(trail.getDistance());
        holder.nameText.setText(trail.getTrailName());



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
        TextView distText;
        TextView nameText;
        ImageView trailIcon;
    }
}



