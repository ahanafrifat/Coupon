package com.appinionbd.coupon.view.logInAndSignUp;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.presenterInterface.ILogin;
import com.appinionbd.coupon.presenter.LoginPresenter;
import com.appinionbd.coupon.view.home.HomeActivity;

import es.dmoral.toasty.Toasty;

public class LogInAndSignUpActivity extends AppCompatActivity implements ILogin.View {

    private TextView textViewSignUp, textViewLogin;

    private TextView textViewForgetPassword;

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;

    private AnimatorSet mSetLeftOut;
    private AnimatorSet mSetRightIn;

    private View frameLayoutLogIn;
    private View frameLayoutSignUp;

    private EditText editTextSignUpReTypePassword;
    private EditText editTextLogInReTypePassword;

    private Button buttonLogInAndSignUp;
    private static int check =0 ;

    private final int LOGIN = 0 ;
    private final int SIGNUP = 1 ;

    ILogin.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_and_sign_up);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        textViewSignUp = findViewById(R.id.textView_sign_up);
        textViewLogin = findViewById(R.id.textView_log_in);

        textViewForgetPassword = findViewById(R.id.textView_forget_password);

        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);

        mSetLeftOut = (AnimatorSet) AnimatorInflater.loadAnimator(this , R.animator.out_right_to_left_animation);
        mSetRightIn = (AnimatorSet) AnimatorInflater.loadAnimator(this , R.animator.in_left_to_right_animation);

        frameLayoutSignUp = findViewById(R.id.frameLayout_sign_up);
        frameLayoutLogIn = findViewById(R.id.frameLayout__log_in);

        changeCameraDistance();

        buttonLogInAndSignUp = findViewById(R.id.button_log_in_and_sign_up);


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(check == LOGIN) {
//                        new FlipHorizontalToAnimation(loginCardView).setFlipToView(signUpCardView)
//                                .setInterpolator(new LinearInterpolator()).animate();

                        frameLayoutSignUp.setVisibility(View.VISIBLE);
                        flipCardFromLeftToRight(frameLayoutLogIn , frameLayoutSignUp);

                        check = SIGNUP;

                        textViewSignUp.setTextColor(getResources().getColor(R.color.white));
                        textViewLogin.setTextColor(getResources().getColor(R.color.white_shade));

                        textViewForgetPassword.setVisibility(View.GONE);

                        buttonLogInAndSignUp.setText("SIGN UP");
                    }
                    else
                        Toasty.info(getApplicationContext() , "You are already Sign up page!" , Toast.LENGTH_SHORT , true).show();
                }
            });


        textViewLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(check == SIGNUP) {

//                        new FlipHorizontalToAnimation(signUpCardView).setFlipToView(loginCardView)
//                                .setInterpolator(new LinearInterpolator()).animate();
//                        new FlipHorizontalToAnimation(signUpCardView);

                        flipCardFromRightToLeft(frameLayoutSignUp, frameLayoutLogIn);
                        check = LOGIN;

                        textViewForgetPassword.setVisibility(View.VISIBLE);

                        textViewSignUp.setTextColor(getResources().getColor(R.color.white_shade));
                        textViewLogin.setTextColor(getResources().getColor(R.color.white));
                        buttonLogInAndSignUp.setText("LOG IN");
                    }
                    else
                        Toasty.info(getApplicationContext() , "You are already in Log in page!" , Toast.LENGTH_SHORT , true).show();
                }
            });

        buttonLogInAndSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHomeActivity();
            }
        });

    }

    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        frameLayoutLogIn.setCameraDistance(scale);
        frameLayoutSignUp.setCameraDistance(scale);
    }

    public void flipCardFromLeftToRight(View frameLayoutFrom, View frameLayoutTo) {
            mSetRightOut.setTarget(frameLayoutFrom);
            mSetLeftIn.setTarget(frameLayoutTo);
            mSetRightOut.start();
            mSetLeftIn.start();
    }

    public void flipCardFromRightToLeft(View frameLayoutFrom, View frameLayoutTo) {
        mSetLeftOut.setTarget(frameLayoutFrom);
        mSetRightIn.setTarget(frameLayoutTo);
        mSetLeftOut.start();
        mSetRightIn.start();
    }

    private void gotoHomeActivity(){
        Intent intent = new Intent(this , HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginSuccessful(String message) {

    }

    @Override
    public void loginFailed(String message) {

    }

    @Override
    public void wrongUsername(String message) {

    }

    @Override
    public void wrongPassword(String message) {

    }

    @Override
    public void connectionError(String message) {

    }

    @Override
    public void wrongUserNameOrPasswordShowInView(String message) {

    }
}
