package com.example.khabennaki.Design.SignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.khabennaki.Design.Home.ImageFromGallery.GridAdapter;
import com.example.khabennaki.Design.Home.ImageFromGallery.ImageFolders;
import com.example.khabennaki.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

    // for permission
    private int IMAGE_PERMISSION_CODE = 1;

    // for bottom sheet
    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheet;
    private Button crossButton, arrowButton;
    private boolean CHECK_ARROW_BUTTON_ROTATION_STATE = false;
    private View layoutView;
    private RecyclerView recyclerView;

    // for GridView
    private GridView gridView;
    private GridAdapter gridAdapter;
    private List <String> images = new ArrayList<>();

    // for folder RecyclerView
    private List <String> allFolderPaths = new ArrayList<>();
    private List <ImageFolders> imageFoldersList = new ArrayList<>();

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
        crossButton = findViewById(R.id.cross_button_id);
        arrowButton = findViewById(R.id.arrow_button_id);
        layoutView = findViewById(R.id.recyclerViewLayout_id);
        recyclerView = findViewById(R.id.recyclerView_id);

        // for gridView
        gridView = findViewById(R.id.gridView_id);

        initialization(); // initialize activity on start

        for(ImageFolders imageFolders : imageFoldersList){
            int total = imageFolders.getTotalImages();
            Log.d("FolderNames", imageFolders.getFolderName()+" "+total);
        }

        // on click listener for buttons

        // for bottom sheet buttons
        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setHideable(true); // make bottom sheet hideAble
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN); // hide the bottom sheet
            }
        });

        arrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CHECK_ARROW_BUTTON_ROTATION_STATE==false){
                    arrowButton.setRotation(180); // rotate the button
                    CHECK_ARROW_BUTTON_ROTATION_STATE = true; // change the state
                    slideUp(layoutView); // slide up animation for recyclerView
                }else{
                    arrowButton.setRotation(0); // rotate to initial position
                    CHECK_ARROW_BUTTON_ROTATION_STATE = false; // change the state
                    slideDown(layoutView); // slide down animation for recyclerView
                }
            }
        });

    }


    // method for initialize activity on start
    public void initialization(){
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet); // bottom sheet behavior
        layoutView.setVisibility(View.GONE); // hide the recyclerView

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

        // set up gridView
        gridAdapter = new GridAdapter(getApplicationContext(), images); // send the images list to gridView
        gridView.setAdapter(gridAdapter);
    }

    // methods for recyclerView
    // slide the view from below itself to the current position
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    // slide the view from its current position to below itself
    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    // methods for
    // permission for fetch all the image from gallery
    // get all the image from gallery
    public void fetchGalleryImages() {

        final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID}; //get all columns of type images
        final String orderBy = MediaStore.Images.Media.DATE_TAKEN; //order data by date

        //get all data in Cursor by sorting in DESC order
        Cursor imageCursor = managedQuery(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
                null, orderBy + " DESC");

        for (int i = 0; i < imageCursor.getCount(); i++) {
            imageCursor.moveToPosition(i); // check all the image from the phone
            int dataColumnIndex = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA); //get column index
            String imageUrl = imageCursor.getString(dataColumnIndex); // get image url off every images

            images.add(imageUrl); // add to imageList

            String folderPath = getFolderPath(imageUrl);

            // set for "All Photos"
            if(i==0){
                allFolderPaths.add("All Photos");
                imageFoldersList.add(new ImageFolders("All Photos", imageCursor.getCount(), imageUrl));
            }

            // if already the folder exists in the list update the total number of images
            if(allFolderPaths.contains(folderPath)){
                int index = 0; // to get the actual index of the folder in  imageFoldersList

                for(ImageFolders imageFolders : imageFoldersList){

                    if(folderPath.equals(imageFolders.getFolderName())){ // find out the original index number
                        ImageFolders updateFolderDetails = new ImageFolders(folderPath,
                                imageFolders.getTotalImages()+1, imageFolders.getLastImageUrl()); // update the image total number only

                        imageFoldersList.set(index, updateFolderDetails); // set the update
                        break;
                    }

                    index++;

                }
            }else{ // if the folder don't exists in the list
                allFolderPaths.add(folderPath); // at to the name checker list
                imageFoldersList.add(new ImageFolders(folderPath, 1, imageUrl)); // set the folderPath, initial image, first imageUrl
            }

        }

    }

    public String getFolderPath(String imageUrl){
        String reversePath = "";
        String folderPath = "";

        // get the path in a reverse order
        for(int i=imageUrl.length()-1; i>=0; i--){
            if(imageUrl.charAt(i)=='/'){
                i--;
                while(i>=0){
                    reversePath = reversePath + imageUrl.charAt(i);
                    i--;
                }
                break;
            }
        }

        // get the actual pathh
        for(int i=reversePath.length()-1; i>=0; i--){
            folderPath = folderPath + reversePath.charAt(i);
        }

        return folderPath;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == IMAGE_PERMISSION_CODE){

            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_LONG).show();
                fetchGalleryImages(); // if permission granted fetch all the images from gallery
            }else{
                Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
            }

        }
    }

}