package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    public void OnBackPressed(View view) {
        ForgetPassword.super.onBackPressed();
    }

    public void CallNextActivity(View view) {
        startActivity(new Intent(getApplicationContext(), MakeSelection.class));
        finish();
    }
}