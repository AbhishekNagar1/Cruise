package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cityguide.R;
import com.example.cityguide.User.AllCategories;

public class Login extends AppCompatActivity {

    ImageView backBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
        setContentView(R.layout.activity_retailer_login);
        //Hooks
        backBtn = findViewById(R.id.login_back_button);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.super.onBackPressed();;
            }
        });
    }

    public void callSignUPFromLogin(View view) {
        startActivity(new Intent(getApplicationContext(), SignUp.class));
        finish();
    }

    public void CallNextActivity(View view) {
        startActivity(new Intent(getApplicationContext(), ForgetPassword.class));
        finish();
    }
}