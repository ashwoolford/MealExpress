package com.mealexpress.mealexpress.details_data;

import android.widget.ImageView;

/**
 * Created by josh on 1/5/2018.
 */

public class ItemsData {
    private int imageView;
    private String title , des , price;

    public ItemsData(int imageView, String title, String des, String price) {
        this.imageView = imageView;
        this.title = title;
        this.des = des;
        this.price = price;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


