package com.jle.josh.birdwalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

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