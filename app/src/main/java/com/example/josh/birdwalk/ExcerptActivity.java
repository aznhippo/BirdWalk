package com.example.josh.birdwalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class ExcerptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excerpt);

        Intent intent = getIntent();
        String trailName = intent.getStringExtra(TrailActivity.EXTRA_TRAILNAME);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(trailName);
        setSupportActionBar(toolbar);

        String excName = "file:///android_asset/" + intent.getStringExtra(TrailActivity.EXTRA_EXCNAME) + ".html";
        WebView webView = (WebView) this.findViewById(R.id.webView);
        webView.loadUrl(excName);


    }


}
