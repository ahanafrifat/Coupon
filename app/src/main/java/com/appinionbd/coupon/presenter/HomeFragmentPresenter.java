package com.appinionbd.coupon.presenter;

import com.appinionbd.coupon.interfaces.presenterInterface.IHomeFragment;

public class HomeFragmentPresenter implements IHomeFragment.Presenter {
    private IHomeFragment.View view;

    public HomeFragmentPresenter() {
    }

    public HomeFragmentPresenter(IHomeFragment.View view) {
        this.view = view;
    }
}
