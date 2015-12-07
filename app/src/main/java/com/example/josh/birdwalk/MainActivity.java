package com.example.josh.birdwalk;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //called when user clicks maps button
    public void goToMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("fromActivity", "MainActivity");
        startActivity(intent);
    }

    //called when user clicks list trails button
    public void goToList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }


    //called when user clicks how to use button
    public void goToHowToUse(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("fromActivity", "MainActivity");
        startActivity(intent);
    }
}