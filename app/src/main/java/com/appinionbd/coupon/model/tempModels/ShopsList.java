package com.appinionbd.coupon.model.tempModels;

public class ShopsList {
    private String id;
    private String title;
    private String des;

    public ShopsList() {
    }

    public ShopsList(String id, String title, String des) {
        this.id = id;
        this.title = title;
        this.des = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
