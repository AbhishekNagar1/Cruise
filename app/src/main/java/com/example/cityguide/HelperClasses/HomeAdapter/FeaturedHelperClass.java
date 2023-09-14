package com.example.cityguide.HelperClasses.HomeAdapter;

public class FeaturedHelperClass {

    int image;
    String title, description;
    float RB;

    public FeaturedHelperClass(int image, float RB, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.RB = RB;
    }

    public int getImage() {
        return image;
    }

    public float getRB() {
        return RB;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
