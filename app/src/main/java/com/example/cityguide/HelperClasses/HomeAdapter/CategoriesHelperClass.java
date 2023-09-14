package com.example.cityguide.HelperClasses.HomeAdapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {
    int image;
    String title;
    GradientDrawable color;

    public CategoriesHelperClass(GradientDrawable color, int image, String title) {
        this.image = image;
        this.title = title;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public Drawable getGradient() {
        return color;
    }
}
