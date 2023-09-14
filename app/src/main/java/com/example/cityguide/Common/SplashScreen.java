package com.example.cityguide.Common;

import static com.example.cityguide.R.id.powered_by_line;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    //variables
    ImageView backgroundImage;
    TextView poweredByLine;
    LinearLayout mainTxt;

    //Animations
    Animation sideAnim, bottomAnim, crop;

    SharedPreferences onBoardingScreen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
        setContentView(R.layout.activity_main);

        //Hooks
        //backgroundImage = findViewById(R.id.background_image);
        //poweredByLine = findViewById(R.id.powered_by_line);

        mainTxt = findViewById(R.id.app_h);

        //Animations
        //sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        //bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        crop = AnimationUtils.loadAnimation(this, R.anim.crop);

        //set Animations on elements
        //backgroundImage.setAnimation(sideAnim);
        //poweredByLine.setAnimation(bottomAnim);

        mainTxt.setAnimation(crop);
        mainTxt.setVisibility(View.VISIBLE);


        new Handler().postDelayed(() -> {

            onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
            boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

            if (isFirstTime) {

                SharedPreferences.Editor editor = onBoardingScreen.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();

                Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }

        },SPLASH_TIMER);

    }
}