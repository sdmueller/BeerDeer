package com.beerdeer.model;

/**
 * Created by tim on 13.12.15.
 */
public class BeerRowItem {
    public String name;
    public int imageId;


    public BeerRowItem(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
