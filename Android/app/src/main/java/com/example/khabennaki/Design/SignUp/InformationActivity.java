package com.example.khabennaki.Design.SignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.khabennaki.Design.Home.GridAdapter;
import com.example.khabennaki.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    // for permission
    private int IMAGE_PERMISSION_CODE = 1;

    // for bottom sheet
    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheet;

    // for Gridview
    private GridView gridView;
    private GridAdapter gridAdapter;
    private List<String> imageUriList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        // set light mode by default
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // status bar color
        try{
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColor(this.getResources().getColor(R.color.background_color));
            }
        }catch (Exception e){
        }

        // for bottom sheet
        bottomSheet = findViewById(R.id.bottom_sheet_id);
        // for gridView
        gridView = findViewById(R.id.gridView_id);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet); // bottom sheet behavior
        //bottomSheetBehavior.setPeekHeight(500);



        // permission for storage
        if(ContextCompat.checkSelfPermission(InformationActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(InformationActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED ){

            // if permission is granted fetch pic from gallery
            fetchGalleryImages();

        }else{
            // permission request
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE},IMAGE_PERMISSION_CODE);
        }

        // set gridView adapter
        gridAdapter = new GridAdapter(getApplicationContext(),imageUriList);
        gridView.setAdapter(gridAdapter);

    }

    public List <String> fetchGalleryImages() {
        final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID}; //get all columns of type images
        final String orderBy = MediaStore.Images.Media.DATE_TAKEN; //order data by date

        //get all data in Cursor by sorting in DESC order
        Cursor imageCursor = managedQuery(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
                null, orderBy + " DESC");

        for (int i = 0; i < imageCursor.getCount(); i++) {
            imageCursor.moveToPosition(i);
            int dataColumnIndex = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA); //get column index
            imageUriList.add(imageCursor.getString(dataColumnIndex)); //get Image from column index
        }

        return imageUriList;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == IMAGE_PERMISSION_CODE){

            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_LONG).show();
                fetchGalleryImages();
            }else{
                Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
            }

        }
    }

}