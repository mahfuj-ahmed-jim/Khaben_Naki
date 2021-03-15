package com.example.khabennaki.Design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import com.example.khabennaki.R;

import java.util.ArrayList;
import java.util.List;

public class BuyerSignInActivity extends AppCompatActivity {

    // editText
    private ConstraintLayout editText_layout;
    private EditText editText;
    private Button cross_button;

    // buttons
    private Button continue_button, shade_button, back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_sign_in);

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

        // for edittext
        editText_layout = findViewById(R.id.editText_layout_id); // editText layout
        editText = findViewById(R.id.editText_id); // edittex
        cross_button = findViewById(R.id.cross_button_id); // editText cross button

        // for buttons
        back_button = findViewById(R.id.back_button_id);
        continue_button = findViewById(R.id.continue_button_id);
        shade_button = findViewById(R.id.shade_button_id);

        cross_button.setVisibility(View.GONE); // hide cross button

        editText_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    editText.requestFocus(); // request for select edittext

                    // for keyboard
                    InputMethodManager imm = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    }
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    cross_button.setVisibility(View.GONE); // hide cross button
                }else{
                    cross_button.setVisibility(View.VISIBLE); // show cross button
                }
                if(s.toString().length()==10){
                    shade_button.setVisibility(View.GONE); // hide shade button
                }else{
                    shade_button.setVisibility(View.VISIBLE); // show shade button
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cross_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}