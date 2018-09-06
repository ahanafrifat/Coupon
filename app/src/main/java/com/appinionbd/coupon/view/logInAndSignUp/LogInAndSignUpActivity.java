package com.appinionbd.coupon.view.logInAndSignUp;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appinionbd.coupon.R;

import es.dmoral.toasty.Toasty;

public class LogInAndSignUpActivity extends AppCompatActivity {

    private TextView textViewSignUp, textViewLogin;

    private TextView textViewForgetPassword;

    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;

    private View frameLayoutLogIn;
    private View frameLayoutSignUp;

    private EditText editTextSignUpReTypePassword;
    private EditText editTextLogInReTypePassword;

    private Button buttonLogInAndSignUp;
    private static int check =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_and_sign_up);
    }

    @Override
    protected void onStart() {
        super.onStart();

        textViewSignUp = findViewById(R.id.textView_sign_up);
        textViewLogin = findViewById(R.id.textView_log_in);

        textViewForgetPassword = findViewById(R.id.textView_forget_password);

        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);

        frameLayoutSignUp = findViewById(R.id.frameLayout_sign_up);
        frameLayoutLogIn = findViewById(R.id.frameLayout__log_in);

        changeCameraDistance();

        buttonLogInAndSignUp = findViewById(R.id.button_log_in_and_sign_up);


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(check == 0) {
//                        new FlipHorizontalToAnimation(loginCardView).setFlipToView(signUpCardView)
//                                .setInterpolator(new LinearInterpolator()).animate();

                        frameLayoutSignUp.setVisibility(View.VISIBLE);
                        flipCard(frameLayoutLogIn , frameLayoutSignUp);

                        check = 1;

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
                    if(check == 1) {
//                        new FlipHorizontalToAnimation(signUpCardView).setFlipToView(loginCardView)
//                                .setInterpolator(new LinearInterpolator()).animate();
//                        new FlipHorizontalToAnimation(signUpCardView);

                        flipCard(frameLayoutSignUp, frameLayoutLogIn);
                        check = 0;

                        textViewForgetPassword.setVisibility(View.VISIBLE);

                        textViewSignUp.setTextColor(getResources().getColor(R.color.white_shade));
                        textViewLogin.setTextColor(getResources().getColor(R.color.white));
                        buttonLogInAndSignUp.setText("LOG IN");
                    }
                    else
                        Toasty.info(getApplicationContext() , "You are already in Log in page!" , Toast.LENGTH_SHORT , true).show();
                }
            });

    }

    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        frameLayoutLogIn.setCameraDistance(scale);
        frameLayoutSignUp.setCameraDistance(scale);
    }

    public void flipCard(View frameLayoutFrom, View frameLayoutTo) {
            mSetRightOut.setTarget(frameLayoutFrom);
            mSetLeftIn.setTarget(frameLayoutTo);
            mSetRightOut.start();
            mSetLeftIn.start();
    }

//    public void flipCard(int check, View frameLayoutFrom, View frameLayoutTo) {
//        if (check == 0) {
//            mSetRightOut.setTarget(this.frameLayoutLogIn);
//            mSetLeftIn.setTarget(this.frameLayoutSignUp);
//            mSetRightOut.start();
//            mSetLeftIn.start();
//        } else {
//            mSetRightOut.setTarget(this.frameLayoutSignUp);
//            mSetLeftIn.setTarget(this.frameLayoutLogIn);
//            mSetRightOut.start();
//            mSetLeftIn.start();
//        }
//    }
}
