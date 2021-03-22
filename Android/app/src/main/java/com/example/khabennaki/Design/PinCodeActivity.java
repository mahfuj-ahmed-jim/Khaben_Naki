package com.example.khabennaki.Design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.khabennaki.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class PinCodeActivity extends AppCompatActivity {

    // buttons
    private Button back_button,submit_button,shade_button;

    //pin view
    private PinView pinView;

    // firebase
    private PhoneAuthProvider.ForceResendingToken forceResendingToken; // resend otp when fail
    private FirebaseAuth firebaseAuth;
    private String verifyCode; // will hold otp to verify
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_code);

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

        // get values from intent
        verifyCode = getIntent().getExtras().getString("Verify Code");
        phoneNumber = getIntent().getExtras().getString("Phone Number");

        // get token for resend code
        BuyerSignInActivity buyerSignInActivity = new BuyerSignInActivity();
        forceResendingToken = buyerSignInActivity.getForceResendingToken();

        // for buttons
        back_button = findViewById(R.id.back_button_id);
        submit_button = findViewById(R.id.submit_button_id);
        shade_button = findViewById(R.id.shade_button_id);
        // pin view
        pinView = findViewById(R.id.pinview_id);

        firebaseAuth = FirebaseAuth.getInstance(); // initialize firebase

        pinView.requestFocus(); // request for select pincode

        // for keyboard
        InputMethodManager imm = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==6){
                    shade_button.setVisibility(View.GONE); // hide shade button
                }else{
                    shade_button.setVisibility(View.VISIBLE); // show shade button
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyWithCode(verifyCode,pinView.getText().toString().trim());
            }
        });

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        // if the code works successfully
        firebaseAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                finish();
            }
        });
        // if the code doesn't works
        firebaseAuth.signInWithCredential(credential).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Fail try again",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void verifyWithCode(String verifyCode, String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifyCode,code);
        signInWithPhoneAuthCredential(credential);
    }

}