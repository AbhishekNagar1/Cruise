package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUp3rdClass extends AppCompatActivity {

    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd_class);
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));

        phoneNumber = findViewById(R.id.phone_no);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.phone_no);
    }

    public void welcomeOTPScreen(View view) {
        String password = getIntent().getStringExtra("password");
        if (!validatePhoneNumber()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
        startActivity(intent);


//        startActivity(new Intent(getApplicationContext(), VerifyOTP.class));
//        finish();

//        String _fullName = getIntent().getStringExtra("fullName");
//        String _email = getIntent().getStringExtra("email");
//        String _username = getIntent().getStringExtra("username");
//        String _password = getIntent().getStringExtra("password");
//        String _date = getIntent().getStringExtra("date");
//        String _gender = getIntent().getStringExtra("gender");
//
//        String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
//        String _phoneNo = "+"+countryCodePicker.getSelectedCountryCode()+_getUserEnteredPhoneNumber;

//        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);

//        intent.putExtra("fullName", _fullName);
//        intent.putExtra("email", _email);
//        intent.putExtra("username", _username);
//        intent.putExtra("password", _password);
//        intent.putExtra("date", _date);
//        intent.putExtra("gender", _gender);
//        intent.putExtra("phoneNo", _phoneNo);

//        startActivity(intent);

    }

    public void OnBackPressed(View view) {
        SignUp3rdClass.super.onBackPressed();
    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        String checkspaces = "Aw{1,10}z";
        if (val.isEmpty()) {
            phoneNumber.setError("Field Can't be empty!");
            return false;
        } else if (val.length() > 10) {
            phoneNumber.setError("Enter valid phone number");
            return false;
        } else if (val.length() < 10) {
            phoneNumber.setError("Enter valid phone number");
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }
}