package com.example.khabennaki.Design;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.khabennaki.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PinCodeActivity extends AppCompatActivity {

    // buttons
    private Button back_button,submit_button,shade_button;

    //pin view
    private PinView pinView;
    private TextView resend_textView;

    // firebase
    private PhoneAuthProvider.ForceResendingToken forceResendingToken; // resend otp when fail
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack; // send otp
    private FirebaseAuth firebaseAuth;
    private String verifyCode; // will hold otp to verify
    private String phoneNumber;

    // for keyboard
    InputMethodManager imm = null;

    // for test
    private int c = 0;
    private boolean resendCode = false;

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
        resend_textView = findViewById(R.id.resend_textView_id);

        firebaseAuth = FirebaseAuth.getInstance(); // initialize firebase

        pinView.requestFocus(); // request for select pincode

        // for keyboard
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        timerForResendCode();

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
                resendCode = false; // to change textView
                verifyCode = verifyCode;
                forceResendingToken = forceResendingToken;
                pinView.setText("");
                timerForResendCode();
            }
        };

        resend_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resendCode==true){
                    resendVerificationCode(phoneNumber,forceResendingToken);
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    // hide keyboard
                    imm.hideSoftInputFromWindow(pinView.getWindowToken(), 0);
                }catch (Exception e){

                }
                onBackPressed();
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyWithCode(verifyCode,pinView.getText().toString().trim());
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

    }

    private void timerForResendCode() {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                resendCode = false;
                if(millisUntilFinished / 1000 < 10){
                    resend_textView.setText("Resend code in 00:0" + millisUntilFinished / 1000);
                }else{
                    resend_textView.setText("Resend code in 00:" + millisUntilFinished / 1000);
                }
            }

            public void onFinish() {
                resendCode = true;
                resend_textView.setText("Resend Code");
            }
        }.start();
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        // if the code works successfully
        firebaseAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                c++;
                finish();
            }
        });
        // if the code doesn't works
        firebaseAuth.signInWithCredential(credential).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(c==0){
                    Toast.makeText(getApplicationContext(),"Fail try again",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void verifyWithCode(String verifyCode, String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifyCode,code);
        signInWithPhoneAuthCredential(credential);
    }

    private void resendVerificationCode(String phoneNumber, PhoneAuthProvider.ForceResendingToken forceResendingToken){
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phoneNumber) // set phone number
                .setTimeout(60L, TimeUnit.SECONDS) // set timer for submit the code
                .setActivity(this)
                .setCallbacks(mCallBack) // call back action
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

}