package com.example.cityguide.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.cityguide.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyOTP extends AppCompatActivity {

    TextView display;
    PinView pinFromUser;
    String CodeBySystem;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));

        display = findViewById(R.id.box);
        pinFromUser = findViewById(R.id.pin_view);

        //String _phoneNo = getIntent().getStringExtra("phoneNo");
        //sendVerificationCodeToUser(_phoneNo);
    }

//    private void sendVerificationCodeToUser(String phoneNo) {
//        // [START start_phone_auth]
//        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth) //mAuth is defined on top
//                .setPhoneNumber(phoneNo)       // Phone number to verify
//                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                .setActivity(this)                 // Activity (for callback binding)
//                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
//                .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//        // [END start_phone_auth]
//    }

//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
//            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                @Override
//                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                    super.onCodeSent(s, forceResendingToken);
//                    CodeBySystem = s;
//                }
//
//                @Override
//                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                    String code = phoneAuthCredential.getSmsCode();
//                    if (code!=null) {
//                        pinFromUser.setText(code);
//                        verifyCode(code);
//                    }
//                }
//
//                @Override
//                public void onVerificationFailed(@NonNull FirebaseException e) {
//                    Toast.makeText(VerifyOTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(CodeBySystem, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(VerifyOTP.this, "Verification Completed", Toast.LENGTH_SHORT).show();
                        } else {

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(VerifyOTP.this, "Verification Not Completed! Try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    public void OnBackPressed(View view) {
        VerifyOTP.super.onBackPressed();
    }

//    public void callNextScreenFromOTP(View view) {
//        String code = pinFromUser.getText().toString();
//        if (!code.isEmpty()) {
//            verifyCode(code);
//        }
//    }
}