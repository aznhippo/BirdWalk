package com.jle.josh.birdwalk;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class UploadActivity extends AppCompatActivity {


    public static final String UPLOAD_URL = "http://birdwalk.hopto.org/upload.php";
    public static final String UPLOAD_KEY = "image";

    private int PICK_IMAGE_REQUEST = 1;

    private ImageView imageView;

    private Bitmap bitmap;
    private Uri filePath;

    private Boolean imagePicked = false;

    private static final int READ_EXTERNAL_STORAGE_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Upload Your Trail Picture");

        imageView = (ImageView) findViewById(R.id.imageView);

        requestStoragePermission();
        setUpSearchField();
    }

    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            return;
        } else {
            // Show rationale and request permission.
//            showMissingPermissionError();
            PermissionUtils.requestPermission(this, READ_EXTERNAL_STORAGE_PERMISSION_CODE,
                    Manifest.permission.READ_EXTERNAL_STORAGE, true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        //https://github.com/googlemaps/android-samples/blob/master/ApiDemos/app/src/main/java/com/example/mapdemo/MyLocationDemoActivity.java
        if (requestCode != READ_EXTERNAL_STORAGE_PERMISSION_CODE) {
            return;
        }
//
//        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
//                Manifest.permission.READ_EXTERNAL_STORAGE)) {
//
//        } else {
//            // Display the missing permission error dialog when the fragments resume.
//        }
    }

    public void showFileChooser(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
                imagePicked = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void uploadImage(View v){
        if (!imagePicked) {
            Toast.makeText(getApplicationContext(),"No image selected",Toast.LENGTH_SHORT).show();
            return;
        }


        class UploadImage extends AsyncTask<Bitmap,Void,String>{
            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(UploadActivity.this, "Uploading Image", "Please wait...",true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);

                HashMap<String,String> data = new HashMap<>();
                data.put(UPLOAD_KEY, uploadImage);

                File myFile = new File(filePath.toString());
                String fileNameSegs[] = myFile.getAbsolutePath().split("/");
                data.put("filename", fileNameSegs[fileNameSegs.length-1]);

                String result = rh.sendPostRequest(UPLOAD_URL,data);

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }


    public void setUpSearchField(){
        //set up search field listeners
        final Button clearButton = (Button) findViewById(R.id.clear_search);
        clearButton.setVisibility(View.GONE);

        Map<String, Trail> map = TrailData.trailHashMap;
        Set<String> keys = map.keySet();
        String[] trails = keys.toArray(new String[keys.size()]);
//        String[] birdsAndTrails = new String[trails.length + TrailBirds.allBirds.length];
//        for (int i=0; i<trails.length;i++){
//            birdsAndTrails[i] = trails[i];
//        }
//        int k = trails.length;
//        for (int j=0; j<TrailBirds.allBirds.length; j++){
//            birdsAndTrails[k] = TrailBirds.allBirds[j];
//            k++;
//        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, trails);
        final AutoCompleteTextView input = (AutoCompleteTextView) findViewById(R.id.search_trail);
        input.setAdapter(adapter);
        input.setThreshold(1);
        input.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);


        //hide button, when field is empty
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (input.getText().toString().equals(""))
                    clearButton.setVisibility(View.GONE);
                else
                    clearButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //perform search for selected suggestion
        input.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        });
//        //perform search, hide keyboard when 'search' is clicked
//        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            //perform search, and hide keyboard
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (getCurrentFocus() != null) {
//                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//                }
//                return false;
//            }
//        });
    }
}
