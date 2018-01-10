package com.mealexpress.mealexpress.homedata;

/**
 * Created by josh on 1/3/2018.
 */

public class HorizontalData {

    private int images;
    private String title;
    private String type;
    private String time;

    public HorizontalData(){

    }

    public HorizontalData(int images, String title, String type, String time) {
        this.images = images;
        this.title = title;
        this.type = type;
        this.time = time;
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
}
