package com.example.cityguide.HelperClasses.HomeAdapter;

public class MostViewedHelperClass {
    int image;
    String title, description;

    public MostViewedHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public String getTextView() {
        return title;
    }

    public int getImageView() {
        return image;
    }

}
