package com.example.cityguide.HelperClasses.HomeAdapter;

public class RestaurantsHelperClass {

    int image;
    float RB;
    String title, description;

    public RestaurantsHelperClass(int image, float RB, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.RB = RB;
    }

    public float getRB() {
        return RB;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
