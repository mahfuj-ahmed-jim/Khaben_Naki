package com.example.khabennaki.Design.SignUp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khabennaki.Design.Database.Buyer;
import com.example.khabennaki.Design.Database.MainDatabase;
import com.example.khabennaki.Design.ImageFromGallery.GridAdapter;
import com.example.khabennaki.Design.ImageFromGallery.ImageFolders;
import com.example.khabennaki.Design.ImageFromGallery.ImageRecyclerViewAdapter;
import com.example.khabennaki.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InformationActivity extends AppCompatActivity {

    // for permission
    private int IMAGE_PERMISSION_CODE = 1;

    // for bottom sheet
    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheet, imageCoordinateLayout;
    private TextView cancelButton, albumButton; // use as button
    private Button arrowButton;
    private TextView selectedFolderName;

    // for GridView
    private GridView gridView;
    private GridAdapter gridAdapter;
    private List <String> images = new ArrayList<>();
    private List <String> tempImages = new ArrayList<>();

    // for folder RecyclerView
    private List <String> allFolderPaths = new ArrayList<>();
    private List <ImageFolders> imageFoldersList = new ArrayList<>();
    private View layoutView;
    private RecyclerView recyclerView;
    private ImageRecyclerViewAdapter adapter;
    private static String selectedFolderPath = "/All Photos";
    private BroadcastReceiver receiver;

    // profile picture
    public static CircleImageView profileImageView;
    private TextView changePictureButton; // textView use ase button

    // scrollViews
    private ScrollView scrollView;
    private EditText nameEditText, emailEditText, locationEditText, favouriteItemEditText;
    private Button saveButton;

    // firebase
    private static String imageUri;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;

    // room databse
    private MainDatabase mainDatabase;
    private String userType;

    public static void setImageUri(String imageUri) {
        InformationActivity.imageUri = imageUri;
    }

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

        // for checking which category is selected
        try{
            userType = getIntent().getExtras().getString("UserType");
        }catch (Exception e){

        }

        // set up firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); // get current user
        String userId = user.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("Buyer").child(userId); // set for real time database
        storageReference = FirebaseStorage.getInstance().getReference("Buyer").child(userId); // set for image storage

        // for bottom sheet
        bottomSheet = findViewById(R.id.bottom_sheet_id);
        cancelButton = findViewById(R.id.canel_button_id);
        albumButton = findViewById(R.id.album_button_id);
        arrowButton = findViewById(R.id.arrow_button_id);
        selectedFolderName = findViewById(R.id.selectedFolderName_textView_Id);
        imageCoordinateLayout = findViewById(R.id.imageCoordinator_layout_id);
        // for recyclerView
        layoutView = findViewById(R.id.recyclerView_layout_id);
        recyclerView = findViewById(R.id.recyclerView_id);
        // for gridView
        gridView = findViewById(R.id.gridView_id);
        // profile picture
        profileImageView = findViewById(R.id.profileImage_id);
        changePictureButton = findViewById(R.id.chnagePictureButton_id);
        //editTexts
        scrollView = findViewById(R.id.scrollView4);
        nameEditText = findViewById(R.id.nameEditText_id);
        emailEditText = findViewById(R.id.emailEditText_id);
        locationEditText = findViewById(R.id.locationEditText_id);
        favouriteItemEditText = findViewById(R.id.favouriteItemEditText_id);
        saveButton = findViewById(R.id.saveButton_id);

        initialization(); // initialize activity on start

        // recyclerView action return
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // Get extra data included in the Intent
                selectedFolderPath = intent.getStringExtra("FolderPath");
                selectedFolderName.setText(intent.getStringExtra("FolderName"));
                /*gridAdapter.setImageList(tempImages, selectedFolderPath);
                gridAdapter.notifyDataSetChanged();*/
                gridAdapter = (GridAdapter) gridView.getAdapter();
                gridAdapter.setImageList(tempImages, selectedFolderPath);
                int index = gridView.getFirstVisiblePosition();
                gridView.smoothScrollToPosition(index);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    gridView.setNestedScrollingEnabled(true);
                }
                arrowButton.performClick();
            }
        };

        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,
                new IntentFilter("custom-message"));


        favouriteItemEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollView.smoothScrollTo(0, favouriteItemEditText.getBottom());
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        favouriteItemEditText.requestFocus();
                    }
                }
                );
                return false;
            }
        }
        );

        // on click listener for buttons

        // profile pictures
        changePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideUp(imageCoordinateLayout);
            }
        });

        // for bottom sheet buttons
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideDown(imageCoordinateLayout); // hide coordinator layout
                // thread to make smooth
                Thread background = new Thread() {
                    public void run() {
                        try {
                            sleep(500);
                            imageCoordinateLayout.setVisibility(View.GONE); // hide layout
                            gridView.setVisibility(View.GONE);
                        } catch (Exception e) {
                        }
                    }
                };
                background.start();
            }
        });

        albumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideUp(layoutView); // slide up animation for recyclerView

                // thread to make smooth
                Thread background = new Thread() {
                    public void run() {
                        try {
                            sleep(500);
                            gridView.setVisibility(View.GONE); // hide gridView
                        } catch (Exception e) {
                        }
                    }
                };
                background.start();
                albumButton.setVisibility(View.GONE); // hide the button
                arrowButton.setVisibility(View.VISIBLE); // show the arrow button
            }
        });

        arrowButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                slideDown(layoutView); // slide down animation for recyclerView
                gridView.setVisibility(View.VISIBLE); // show gridView
                arrowButton.setVisibility(View.GONE); // hide the button
                albumButton.setVisibility(View.VISIBLE); // show the album button

                // thread to make smooth
                Thread background = new Thread() {
                    public void run() {
                        try {
                            sleep(500);
                            recyclerView.setVisibility(View.GONE);
                        } catch (Exception e) {
                        }
                    }
                };
                background.start();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFirebase();
            }
        });

    }

    // method for initialize activity on start
    public void initialization(){
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet); // bottom sheet behavior
        albumButton.setVisibility(View.GONE); // hide album button

        // hide imageView slider
        imageCoordinateLayout.setVisibility(View.GONE);

        // for recyclerView
        //layoutView.setVisibility(View.GONE); // hide recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ImageRecyclerViewAdapter(getApplicationContext(), imageFoldersList, selectedFolderPath);
        recyclerView.setAdapter(adapter);

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

    // methods for firebase

    private void saveToFirebase() {

        /*File f = new File(imageUri);
        Uri yourUri = Uri.fromFile(f);

        // save to firebase storage
        StorageReference reference = null;
        try{
            reference = storageReference.child(System.currentTimeMillis()+"."+getFileExtension(yourUri));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage().toString().trim(),Toast.LENGTH_LONG).show();
        }
        reference.putFile(yourUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isSuccessful());
                Uri uri = uriTask.getResult();*/

                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String location = locationEditText.getText().toString().trim();
                String item = favouriteItemEditText.getText().toString().trim();
                String picture = imageUri;
                int point = 0;
                List <String> searchList = new ArrayList<>();
                List <String> orderList = new ArrayList<>();

                searchList.add("Burger");
                searchList.add("Pizza");
                searchList.add("Chap");

                orderList.add("Order 1");
                orderList.add("Order 2");
                orderList.add("Order 3");

                Buyer buyer = new Buyer(name, email, location, item, picture, point, searchList, orderList);

                databaseReference.setValue(buyer);

                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
/*
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Upload Fail",Toast.LENGTH_LONG).show();
            }
        });*/

    }

    // getting the extension of the image
    public String getFileExtension (Uri imageUri){
        String string = null;
        try{
            ContentResolver contentResolver = getContentResolver();
            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
            string = mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return string;
    }

    // methods for recyclerView
    // slide the view from below itself to the current position
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        gridView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
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
        view.setVisibility(View.GONE);
        gridView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        Log.d("RecyclerView", "Yes");
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
            tempImages.add(imageUrl); // add to temp list

            String folderPath = getFolderPath(imageUrl);

            // set for "All Photos"
            if(i==0){
                allFolderPaths.add("All Photos");
                imageFoldersList.add(new ImageFolders("/All Photos", imageCursor.getCount(), imageUrl));
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
                initialization(); // initialization
            }else{
                Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
            }

        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBackPressed() {
        if(imageCoordinateLayout.getVisibility()==0){
            slideDown(imageCoordinateLayout);
            try{
                // thread to make smooth
                Thread background = new Thread() {
                    public void run() {
                        try {
                            sleep(500);
                            imageCoordinateLayout.setVisibility(View.GONE);
                        } catch (Exception e) {
                        }
                    }
                };
                background.start();
            }catch (Exception e){

            }
        }else{
            super.onBackPressed();
        }
    }
}