package com.example.josh.birdwalk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_INFO = "com.example.josh.birdwalk.INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    //called when user clicks maps button
    public void goToMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("fromActivity", "MainActivity");
        startActivity(intent);
    }

    //called when user clicks list trails button
    public void goToList(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    //called when user clicks Info button
    public void goToIntro(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(EXTRA_INFO, "Intro");
        startActivity(intent);
    }

    //called when user clicks how to use button
    public void goToHowToUse(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(EXTRA_INFO, "HowToUse");
        startActivity(intent);
    }
}