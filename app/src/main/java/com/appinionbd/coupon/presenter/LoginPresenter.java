package com.appinionbd.coupon.presenter;

import com.appinionbd.coupon.interfaces.presenterInterface.ILogin;

public class LoginPresenter implements ILogin.Presenter {
    private ILogin.View view;

    public LoginPresenter() {
    }

    public LoginPresenter(ILogin.View view) {
        this.view = view;
    }

    @Override
    public void loginVerification(String pin, String password) {

    }
}
