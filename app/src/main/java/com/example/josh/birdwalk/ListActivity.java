package com.example.josh.birdwalk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

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



