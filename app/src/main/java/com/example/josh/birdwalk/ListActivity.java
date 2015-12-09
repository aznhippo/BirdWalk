package com.example.josh.birdwalk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {
    TrailData trailData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("List of Trails");
        setSupportActionBar(toolbar);

        //put trails into arraylist
        ArrayList<Trail> trailList = new ArrayList<Trail>(trailData.trailHashMap.values());
        Collections.sort(trailList, Trail.TrailComparator);
        TrailAdapter trailAdapter = new TrailAdapter(this, R.layout.list_item, trailList);
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
            holder.textView1 = (TextView)row.findViewById(R.id.trailDistance);
            holder.textView2 = (TextView)row.findViewById(R.id.trailName);

            row.setTag(holder);
        }
        else {
            holder = (ViewHolder)row.getTag();
        }

        Trail trail = data.get(position);

        holder.textView1.setText(trail.getDistance());
        holder.textView2.setText(trail.getTrailName());

        return row;
    }

    static class ViewHolder {
        TextView textView1;
        TextView textView2;

    }
}



