package com.jle.josh.birdwalk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
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
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        p.setAnchorId(View.NO_ID);
        fab.setLayoutParams(p);
        fab.setVisibility(View.GONE);

        Intent intent = this.getIntent();
        if (intent != null) {
            String intentString = intent.getExtras().getString("fromActivity");

            if (intentString.equals("MainActivity")) {
                toolbar.setTitle("About");
                setSupportActionBar(toolbar);
                setWebView("about");
                fab.setVisibility(View.VISIBLE);
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

    private void setWebView(String assetName){
        String assetPath = "file:///android_asset/" + assetName + ".html";
        WebView webView = (WebView) this.findViewById(R.id.webView);
        webView.loadUrl(assetPath);
    }

    public void launchDonate(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.sacramentoaudubon.org/payments.html"));
        startActivity(browserIntent);
    }

    public void launchEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"birdwalk.app@gmail.com"});
        startActivity(intent);
    }

    public void launchShare(View view){
//        Context context = getApplicationContext();
//        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
//        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//        // To count with Play market backstack, After pressing back button,
//        // to taken back to our application, we need to add following flags to intent.
//        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
//                Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
//                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//        try {
//            startActivity(goToMarket);
//        } catch (ActivityNotFoundException e) {
//            startActivity(new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
//        }

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "https://play.google.com/store/apps/details?id=com.jle.josh.birdwalk";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "BirdWalk App");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
