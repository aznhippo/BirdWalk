package com.jle.josh.birdwalk;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Josh
 * Info Activity for displaying trail narratives, and app info
 * Donate, submit, show pic button
 */
public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        p.setAnchorId(View.NO_ID);
        fab.setLayoutParams(p);
        fab.setVisibility(View.GONE);
        fab2.setVisibility(View.GONE);

        //set buttons based on calling activity
        Intent intent = this.getIntent();
        if (intent != null) {
            String intentString = intent.getExtras().getString("fromActivity");

            if (intentString.equals("MainActivity")) {
                toolbar.setTitle("About");
                setSupportActionBar(toolbar);
                setWebView("about");
                fab.setVisibility(View.VISIBLE);
                fab2.setVisibility(View.VISIBLE);
            }
            else if (intentString.equals("TrailActivity")) {
                String trailName = intent.getExtras().getString("trailName");
                toolbar.setTitle(trailName);
                setSupportActionBar(toolbar);

                String excName = intent.getExtras().getString("resName");
                setWebView(excName);
            }
        }
    }

    //show html file in webview
    private void setWebView(String assetName){
        String assetPath = "file:///android_asset/" + assetName + ".html";
        WebView webView = (WebView) this.findViewById(R.id.webView);
        webView.loadUrl(assetPath);
    }

    //launch donate link in browser
    public void launchDonate(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.sacramentoaudubon.org/payments.html"));
        startActivity(browserIntent);
    }

    //launch email addressed to devs
    public void launchEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"birdwalk.app@gmail.com"});
        startActivity(intent);
    }

    //launch share intent
    public void launchShare(View view){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "https://play.google.com/store/apps/details?id=com.jle.josh.birdwalk";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "BirdWalk App");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    //show dubmit dialog
    public void showSubmit(View view){
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.submit_pics, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(v);
        AlertDialog ad = builder.create();
        ad.show();
    }

    //launch upload activity
    public void launchSubmit(View view){
        Intent intent = new Intent(this, UploadActivity.class);
        intent.putExtra("fromActivity", "InfoActivity");
        startActivity(intent);
    }
}
