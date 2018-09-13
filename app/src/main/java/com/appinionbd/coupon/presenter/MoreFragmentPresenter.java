package com.appinionbd.coupon.presenter;

import com.appinionbd.coupon.interfaces.presenterInterface.IMore;

public class MoreFragmentPresenter implements IMore.Presenter {
    private IMore.View view;

    public MoreFragmentPresenter() {
    }

    public MoreFragmentPresenter(IMore.View view) {
        this.view = view;
    }
}
