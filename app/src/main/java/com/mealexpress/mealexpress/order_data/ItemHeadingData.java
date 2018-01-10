package com.mealexpress.mealexpress.order_data;

/**
 * Created by josh on 1/7/2018.
 */

public class ItemHeadingData {

    private String title , des;

    public ItemHeadingData(String title, String des) {
        this.title = title;
        this.des = des;
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
}
