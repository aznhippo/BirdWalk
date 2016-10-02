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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Josh on 11/4/15.
 * Activity for uploading pics to remote server
 *
 */

public class UploadActivity extends AppCompatActivity {

    public static final String UPLOAD_URL = "http://birdwalk.hopto.org/upload.php";

    private int PICK_IMAGE_REQUEST = 1;

    private ImageView imageView;

    private Bitmap bitmap;
    private Uri filePath;

    private Boolean imagePicked = false;
    private Boolean trailPicked = false;

    private static final int READ_EXTERNAL_STORAGE_PERMISSION_CODE = 1;

    private AutoCompleteTextView input;
    private EditText contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Upload Your Trail Picture");

        imageView = (ImageView) findViewById(R.id.imageView);
        input = (AutoCompleteTextView) findViewById(R.id.search_trail);
        contact = (EditText) findViewById(R.id.contact);

        Intent intent = this.getIntent();
        if (intent != null) {
            String intentString = intent.getExtras().getString("fromActivity");

            if (intentString.equals("TrailActivity")) {
                trailPicked = true;
                input.setText(intent.getExtras().getString("trailName"));
            }
        }

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


    public void showFileChooser(View v) {
//        requestStoragePermission();

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

    //encode image bitmap to base64 bytes to string
    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    //upload image to using AsyncTask
    public void uploadImage(View v){
        if (!imagePicked) {
            Toast.makeText(getApplicationContext(),"No image selected",Toast.LENGTH_SHORT).show();
            return;
        }
        else if (!trailPicked){
            Toast.makeText(getApplicationContext(),"No trail selected",Toast.LENGTH_SHORT).show();
            return;
        }

        final String trailName = input.getText().toString();
        final String contactName = contact.getText().toString();


        //AsyncTask subclass for sending bmp and info to server
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
                data.put("image", uploadImage);

                File myFile = new File(filePath.toString());
                String fileNameSegs[] = myFile.getAbsolutePath().split("/");
                data.put("imagename", fileNameSegs[fileNameSegs.length-1]);
                data.put("trailname", trailName);
                data.put("contactname", contactName);

                return rh.sendPostRequest(UPLOAD_URL,data);
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }

    //set up search bar for trails
    public void setUpSearchField(){
        //set up search field listeners
        final Button clearButton = (Button) findViewById(R.id.clear_search);
        clearButton.setVisibility(View.GONE);

        Map<String, Trail> map = TrailData.trailHashMap;
        Set<String> keys = map.keySet();
        String[] trails = keys.toArray(new String[keys.size()]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, trails);

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
        //set trailpicked to true, hide keyboard
        input.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                trailPicked = true;
            }
        });
        //hide keyboard when 'done' is clicked
        input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            //perform search, and hide keyboard
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                return false;
            }
        });
    }

    //clear search bar
    public void clearText(View v){
        input.setText("");
    }
}
