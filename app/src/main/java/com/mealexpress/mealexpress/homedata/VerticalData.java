package com.mealexpress.mealexpress.homedata;

/**
 * Created by josh on 1/3/2018.
 */

public class VerticalData {


    private int images;
    private String title;
    private String type;
    private String time;
    private String rating;

    public VerticalData(){

    }

    public VerticalData(int images, String title, String type, String time , String rating) {
        this.images = images;
        this.title = title;
        this.type = type;
        this.time = time;
        this.rating = rating;
    }


    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
