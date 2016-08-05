package com.jle.josh.birdwalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private String EULA_PREFIX = "eula_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showEULA();
    }

    private void showEULA(){
        PackageInfo versionInfo = null;
        try {
            versionInfo = this.getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_ACTIVITIES);
        }
        catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }

        final String eulaKey = EULA_PREFIX + versionInfo.versionCode;
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean shown = prefs.getBoolean(eulaKey, false);
        if (shown == false){
            String title = "BirdWalk v" + versionInfo.versionName;
            String assetPath = "file:///android_asset/eula.html";




            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle(title)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Mark this version as read.
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean(eulaKey, true);
                            editor.commit();
                            dialogInterface.dismiss();
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Close the activity as they have declined the EULA
                            finish();
                            System.exit(0);
                        }

                    });

            WebView wv = new WebView(this);
            wv.loadUrl(assetPath);


            builder.setView(wv);
            builder.create().show();
        }



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
