package com.example.josh.birdwalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("How To Use");
        setSupportActionBar(toolbar);

        setUpInfo();
    }

    public void setUpInfo(){
        Intent intent = getIntent();
        String infoName = "file:///android_asset/" + intent.getStringExtra(MainActivity.EXTRA_INFO) + ".html";
        WebView webView = (WebView) this.findViewById(R.id.webView);
        webView.loadUrl(infoName);

    }
}
