package com.example.khabennaki.Design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.khabennaki.R;

public class SelectActivity extends AppCompatActivity {

    private ConstraintLayout buyer_layout, restaurant_layout, delivery_layout; // layouts
    private RadioButton buyer_button, restaurant_button, delivery_button; // radio buttons
    private TextView buyer_textView, restaurant_textView, delivery_textView; // textviews
    private Button button; // next Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

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

        // layouts
        buyer_layout = findViewById(R.id.buyer_layout_id);
        restaurant_layout = findViewById(R.id.restaurent_layout_id);
        delivery_layout = findViewById(R.id.delivery_layout_id);
        // radio buttons
        buyer_button = findViewById(R.id.buyer_button_id);
        restaurant_button = findViewById(R.id.restaurent_button_id);
        delivery_button = findViewById(R.id.delivery_button_id);
        // textviews
        buyer_textView = findViewById(R.id.buyer_text_id);
        restaurant_textView = findViewById(R.id.restaurent_text_id);
        delivery_textView = findViewById(R.id.delivery_text_id);
        // next button
        button = findViewById(R.id.button_id);

        // next button on click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buyer_button.isChecked()){
                    startActivity(new Intent(getApplicationContext(),BuyerSignInActivity.class));
                }
            }
        });

        // for on click on layouts
        buyer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // radio button changes
                buyer_button.setChecked(true); // setting checked
                restaurant_button.setChecked(false); // setting unchecked
                delivery_button.setChecked(false); // setting unchecked

                // layout changes
                buyer_layout.setBackgroundResource(R.drawable.radio_selected_button); // setting checked
                restaurant_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                delivery_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked\

                // textview changes
                buyer_textView.setTextSize(16); // set checked
                restaurant_textView.setTextSize(15); // set unchecked
                delivery_textView.setTextSize(15); // set unchecked
            }
        });

        restaurant_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // radio button changes
                buyer_button.setChecked(false); // setting unchecked
                restaurant_button.setChecked(true); // setting checked
                delivery_button.setChecked(false); // setting unchecked

                // layout changes
                buyer_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                restaurant_layout.setBackgroundResource(R.drawable.radio_selected_button); // setting checked
                delivery_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked

                // textview changes
                buyer_textView.setTextSize(15); // set unchecked
                restaurant_textView.setTextSize(16); // set checked
                delivery_textView.setTextSize(15); // set unchecked
            }
        });

        delivery_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // radio button changes
                buyer_button.setChecked(false); // setting unchecked
                restaurant_button.setChecked(false); // setting unchecked
                delivery_button.setChecked(true); // setting checked

                // layout changes
                buyer_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                restaurant_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                delivery_layout.setBackgroundResource(R.drawable.radio_selected_button); // setting checked

                // textview changes
                buyer_textView.setTextSize(15); // set unchecked
                restaurant_textView.setTextSize(15); // set unchecked
                delivery_textView.setTextSize(16); // set checked
            }
        });

        // for on click on layouts
        buyer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // radio button changes
                buyer_button.setChecked(true); // setting checked
                restaurant_button.setChecked(false); // setting unchecked
                delivery_button.setChecked(false); // setting unchecked

                // layout changes
                buyer_layout.setBackgroundResource(R.drawable.radio_selected_button); // setting checked
                restaurant_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                delivery_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked\

                // textview changes
                buyer_textView.setTextSize(16); // set checked
                restaurant_textView.setTextSize(15); // set unchecked
                delivery_textView.setTextSize(15); // set unchecked
            }
        });

        restaurant_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // radio button changes
                buyer_button.setChecked(false); // setting unchecked
                restaurant_button.setChecked(true); // setting checked
                delivery_button.setChecked(false); // setting unchecked

                // layout changes
                buyer_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                restaurant_layout.setBackgroundResource(R.drawable.radio_selected_button); // setting checked
                delivery_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked

                // textview changes
                buyer_textView.setTextSize(15); // set unchecked
                restaurant_textView.setTextSize(16); // set checked
                delivery_textView.setTextSize(15); // set unchecked
            }
        });

        delivery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // radio button changes
                buyer_button.setChecked(false); // setting unchecked
                restaurant_button.setChecked(false); // setting unchecked
                delivery_button.setChecked(true); // setting checked

                // layout changes
                buyer_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                restaurant_layout.setBackgroundResource(R.drawable.radio_unselect_button); // setting unchecked
                delivery_layout.setBackgroundResource(R.drawable.radio_selected_button); // setting checked

                // textview changes
                buyer_textView.setTextSize(15); // set unchecked
                restaurant_textView.setTextSize(15); // set unchecked
                delivery_textView.setTextSize(16); // set checked
            }
        });

    }
}