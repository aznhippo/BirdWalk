package com.example.josh.birdwalk;

import android.content.Intent;
import android.os.Bundle;
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

        Intent intent = this.getIntent();
        if (intent != null) {
            String intentString = intent.getExtras().getString("fromActivity");

            if (intentString.equals("MainActivity")) {
                toolbar.setTitle("How To Use");
                setSupportActionBar(toolbar);
                setWebView("HowToUse");
            }
            if (intentString.equals("TrailActivity")) {
                String trailName = intent.getExtras().getString("trailName");
                toolbar.setTitle(trailName);
                setSupportActionBar(toolbar);

                String excName = intent.getExtras().getString("excName");
                setWebView(excName);
            }
        }
    }

    private void setWebView(String assetName){
        String assetPath = "file:///android_asset/" + assetName + ".html";
        WebView webView = (WebView) this.findViewById(R.id.webView);
        webView.loadUrl(assetPath);
    }
}
