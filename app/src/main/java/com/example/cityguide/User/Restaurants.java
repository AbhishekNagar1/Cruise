package com.example.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.Common.LoginSignup.SignUp2ndClass;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClasses.HomeAdapter.RestaurantsAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.RestaurantsHelperClass;
import com.example.cityguide.R;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    RecyclerView restaurantsRecycler;
    RecyclerView.Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));
        restaurantsRecycler = findViewById(R.id.restaurants_recycler);
        restaurantsRecycler.setBackgroundResource(R.drawable.round_outline);

        RestaurantsRecycler();
    }

    private void RestaurantsRecycler() {

        restaurantsRecycler.setHasFixedSize(true);
        restaurantsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<RestaurantsHelperClass> LL = new ArrayList<>();

        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,5, "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,3,  "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,4,  "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,4, "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,4, "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,2, "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds, 3,"Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds, 3,"Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,3, "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds, 2,"Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds, 3,"Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));
        LL.add(new RestaurantsHelperClass(R.drawable.mc_donalds,3, "Mcdonald's", "fdfjdvdfjbdjkbdhvbdvhjbdhjd"));

        adapter = new RestaurantsAdapter(LL);
        restaurantsRecycler.setAdapter(adapter);

    }
    public void OnBackPressed(View view) {
        Restaurants.super.onBackPressed();
    }
}