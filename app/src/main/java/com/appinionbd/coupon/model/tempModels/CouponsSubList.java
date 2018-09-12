package com.appinionbd.coupon.model.tempModels;

public class CouponsSubList {
    private String id;
    private String  option_id;
    private String title;
    private String des;
    private int image;
    private int favourite;

    public CouponsSubList() {
    }

    public CouponsSubList(String id, String option_id, String title, String des, int image, int favourite) {
        this.id = id;
        this.option_id = option_id;
        this.title = title;
        this.des = des;
        this.image = image;
        this.favourite = favourite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOption_id() {
        return option_id;
    }

    public void setOption_id(String option_id) {
        this.option_id = option_id;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}
