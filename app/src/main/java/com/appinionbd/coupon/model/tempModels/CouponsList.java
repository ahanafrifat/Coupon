package com.appinionbd.coupon.model.tempModels;

public class CouponsList {
    private String id;
    private String title;

    public CouponsList() {
    }

    public CouponsList(String id, String title) {
        this.id = id;
        this.title = title;
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
}
