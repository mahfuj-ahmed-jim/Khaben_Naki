package com.example.khabennaki.Design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import com.example.khabennaki.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuyerSignInActivity extends AppCompatActivity {

    // editText
    private ConstraintLayout editText_layout;
    private EditText editText;
    private Button cross_button;

    // buttons
    private Button continue_button, shade_button, back_button;

    // firebase
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack; // send otp
    private PhoneAuthProvider.ForceResendingToken forceResendingToken; // resend otp when fail
    private static final String TAG = "Main_Tag";
    private FirebaseAuth firebaseAuth;

    // for keyboard
    InputMethodManager imm = null;

    public PhoneAuthProvider.ForceResendingToken getForceResendingToken() {
        return forceResendingToken;
    }

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
        firebaseAuth = FirebaseAuth.getInstance(); // initialize firebase

        mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                // instant verification
                // no need to send the code
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

            }

            @Override
            public void onCodeSent(@NonNull String verifyCode, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(verifyCode, forceResendingToken);
                // sms verification
                Intent intent = new Intent(getApplicationContext(),PinCodeActivity.class);
                intent.putExtra("Verify Code",verifyCode);
                intent.putExtra("Phone Number","+880"+editText.getText().toString().trim());
                startActivity(intent);
            }
        };

        editText_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    editText.requestFocus(); // request for select edittext

                    // for keyboard
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

        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPhoneNumberVerification();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    // hide keyboard
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                }catch (Exception e){

                }
                onBackPressed();
            }
        });

    }

    private void startPhoneNumberVerification() {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber("+880"+editText.getText().toString().trim()) // set phone number
                .setTimeout(60L, TimeUnit.SECONDS) // set timer for submit the code
                .setActivity(this)
                .setCallbacks(mCallBack) // call back action
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

}