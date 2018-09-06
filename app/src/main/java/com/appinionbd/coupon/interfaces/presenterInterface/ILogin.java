package com.appinionbd.coupon.interfaces.presenterInterface;

public interface ILogin {
    interface View{
        void loginSuccessful(String message);
        void loginFailed(String message);
        void wrongUsername(String message);
        void wrongPassword(String message);
        void connectionError(String message);
        void wrongUserNameOrPasswordShowInView(String message);
    }
    interface Presenter{
        void loginVerification(String pin, String password);
    }
}
