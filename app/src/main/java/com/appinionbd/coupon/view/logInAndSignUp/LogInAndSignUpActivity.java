package com.appinionbd.coupon.view.logInAndSignUp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appinionbd.coupon.R;
import com.easyandroidanimations.library.FlipHorizontalAnimation;
import com.easyandroidanimations.library.FlipHorizontalToAnimation;
import com.easyandroidanimations.library.ParallelAnimator;
import com.easyandroidanimations.library.ParallelAnimatorListener;
import com.easyandroidanimations.library.ScaleInAnimation;

import es.dmoral.toasty.Toasty;

public class LogInAndSignUpActivity extends AppCompatActivity {

    private CardView signUpCardView;
    private CardView loginCardView;
    private TextView textViewSignUp, textViewLogin;

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
        signUpCardView = findViewById(R.id.cardView_sign_up);
        loginCardView = findViewById(R.id.cardView_login);
        textViewSignUp = findViewById(R.id.textView_sign_up);
        textViewLogin = findViewById(R.id.textView_log_in);

        editTextSignUpReTypePassword = findViewById(R.id.editText_sign_up_re_type_password);
        editTextLogInReTypePassword = findViewById(R.id.editText_log_in_re_type_password);

        buttonLogInAndSignUp = findViewById(R.id.button_log_in_and_sign_up);


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(check == 0) {
                        new FlipHorizontalToAnimation(loginCardView).setFlipToView(signUpCardView)
                                .setInterpolator(new LinearInterpolator()).animate();

                        signUpCardView.setCardElevation(8);
                        loginCardView.setElevation(0);
                        check = 1;
                        editTextSignUpReTypePassword.setVisibility(View.VISIBLE);
                        editTextLogInReTypePassword.setVisibility(View.VISIBLE);
                        textViewSignUp.setTextColor(getResources().getColor(R.color.white));
                        textViewLogin.setTextColor(getResources().getColor(R.color.white_shade));
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
                        new FlipHorizontalToAnimation(signUpCardView).setFlipToView(loginCardView)
                                .setInterpolator(new LinearInterpolator()).animate();
                        new FlipHorizontalToAnimation(signUpCardView);
                        signUpCardView.setCardElevation(0);
                        loginCardView.setElevation(8);

                        check = 0;

                        editTextSignUpReTypePassword.setVisibility(View.GONE);
                        editTextLogInReTypePassword.setVisibility(View.GONE);
                        textViewSignUp.setTextColor(getResources().getColor(R.color.white_shade));
                        textViewLogin.setTextColor(getResources().getColor(R.color.white));
                        buttonLogInAndSignUp.setText("LOG IN");
                    }
                    else
                        Toasty.info(getApplicationContext() , "You are already in Log in page!" , Toast.LENGTH_SHORT , true).show();
                }
            });

        //CardView.LayoutParams layoutParams = ()
    }
}
