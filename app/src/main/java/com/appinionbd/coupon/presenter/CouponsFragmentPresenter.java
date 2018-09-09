package com.appinionbd.coupon.presenter;

import com.appinionbd.coupon.interfaces.presenterInterface.ICouponsFragment;

public class CouponsFragmentPresenter implements ICouponsFragment.Presenter {

    private ICouponsFragment.View view;

    public CouponsFragmentPresenter() {
    }

    public CouponsFragmentPresenter(ICouponsFragment.View view) {
        this.view = view;
    }
}
