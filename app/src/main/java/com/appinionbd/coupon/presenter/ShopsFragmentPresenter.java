package com.appinionbd.coupon.presenter;

import com.appinionbd.coupon.interfaces.presenterInterface.IShops;

public class ShopsFragmentPresenter implements IShops.Presenter {
    private IShops.View view;

    public ShopsFragmentPresenter() {
    }

    public ShopsFragmentPresenter(IShops.View view) {
        this.view = view;
    }
}
