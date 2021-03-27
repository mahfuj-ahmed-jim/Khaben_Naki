package com.example.khabennaki.Design.SignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.Toast;

import com.example.khabennaki.Design.Home.GridAdapter;
import com.example.khabennaki.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
    private List <String> images = new ArrayList<>();

    // handler for runtime error
    private Handler handler = new Handler();

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

        gridAdapter = new GridAdapter(getApplicationContext(), images); // send the images list to gridView
        gridView.setAdapter(gridAdapter);

    }

    // methods for
    // permission for fetch all the image from gallery
    // get all the image from gallery

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
            String imageUrl = imageCursor.getString(dataColumnIndex); // get image url off every images

            images.add(imageUrl); // add to lis
        }

        try{

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
        }

        return images;
    }

    public void getFilderName(String imageUrl){
        String reverseName = "";
        String folderName = "";

        for(int i=imageUrl.length()-1; i>=0; i--){
            if(imageUrl.charAt(i)=='/'){
                i--;
                while(imageUrl.charAt(i)!='/'){
                    reverseName = reverseName + imageUrl.charAt(i);
                    i--;
                }
                break;
            }
        }

        for(int i=reverseName.length()-1; i>=0; i--){
            folderName = folderName + reverseName.charAt(i);
        }

        Log.d("FolderName", folderName);
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