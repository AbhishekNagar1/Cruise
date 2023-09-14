package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.cityguide.Common.LoginSignup.Login;
import com.example.cityguide.Common.LoginSignup.RetailerStartUpScreen;
import com.example.cityguide.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedAdpater;
import com.example.cityguide.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;

    public GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    LinearLayout contentView;
    ImageView menuIcon;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);

        //Image Slider
        ImageSlider imageSlider = findViewById(R.id.img_slider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.slider_img_1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider_img_2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider_img_3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider_img_5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider_img_abcd, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider_img_4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slider_img_njff, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Navigation Drawer
        navigationDrawer();

        //Recycler View Function calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }
    //Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

//        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
//        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                break;
            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), Login.class));
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Login First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_add_missing_place:
                startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
                break;
            case R.id.nav_profile:
                Toast.makeText(this, "Create an Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_restaurants:
                startActivity(new Intent(getApplicationContext(), Restaurants.class));
                break;
        }
        return true;
    }


    //Recycler View Functions
    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.burj_khalifa, 3,"Burj Khalifa", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.al_arab, 3,"Burj Al Arab", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.dubai_frame,3,  "Dubai Frame", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.museum,3,  "Future Museum", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.dubai_mall, 3, "Dubai Mall", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.marine_drive, "Marine Drive"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.atlantis, "Atlantis"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.dubai_aqua, "Aquarium"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.marine_restro, "Marina Hotel"));

        adapter = new MostViewedAdpater(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
    }

    private void categoriesRecycler() {
        //All Gradients
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFF7CC8C, 0xFFF7CC8C});
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xFFFDA2A2, 0xFFFDA2A2});

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();

        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.book, "Education"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hospital, "HOSPITAL"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.rest, "Restaurant"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.mall, "Shopping"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient5, R.drawable.vehicles, "Transport"));

        categoriesRecycler.setHasFixedSize(false);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }


    //Normal Functions
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    public void callRetailerScreens(View view) {
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }

    public void call_menu_restro(View view) {
        startActivity(new Intent(getApplicationContext(), Restaurants.class));
    }

    public void CNA(View view) {
        startActivity(new Intent(getApplicationContext(), AllCategories.class));
    }

}