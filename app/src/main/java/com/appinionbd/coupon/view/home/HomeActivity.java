package com.appinionbd.coupon.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.view.home.fragment.CouponsFragment;
import com.appinionbd.coupon.view.home.fragment.GiftCardsFragment;
import com.appinionbd.coupon.view.home.fragment.HomeFragment;
import com.appinionbd.coupon.view.home.fragment.MoreFragment;
import com.appinionbd.coupon.view.home.fragment.ShopsFragment;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Fragment fragment;
    final int FRAGMENT_HOME = 1;
    final int FRAGMENT_COUPONS = 2;
    final int FRAGMENT_GIFT_CARDS = 3;
    final int FRAGMENT_SHOPS = 4;
    final int FRAGMENT_MORE = 5;
    private RelativeLayout relativeLayoutHomeActivity;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startFragment(FRAGMENT_HOME);
                    return true;
                case R.id.navigation_coupons:
                    startFragment(FRAGMENT_COUPONS);
                    return true;
                case R.id.navigation_gift_card:
                    startFragment(FRAGMENT_GIFT_CARDS);
                    return true;
                case R.id.navigation_shops:
                    startFragment(FRAGMENT_SHOPS);
                    return true;
                case R.id.navigation_more:
                    startFragment(FRAGMENT_MORE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragment = null;
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        relativeLayoutHomeActivity = findViewById(R.id.relativeLayout_home_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startFragment(FRAGMENT_HOME);
    }

    private void startFragment(int fragmentCheck) {

        if (fragmentCheck == FRAGMENT_HOME)
        {
            fragment = new HomeFragment();
            relativeLayoutHomeActivity.setVisibility(View.VISIBLE);
        }
        else if (fragmentCheck == FRAGMENT_COUPONS)
        {
            fragment = new CouponsFragment();
            relativeLayoutHomeActivity.setVisibility(View.VISIBLE);
        }
        else if (fragmentCheck == FRAGMENT_GIFT_CARDS)
        {
            fragment = new GiftCardsFragment();
            relativeLayoutHomeActivity.setVisibility(View.VISIBLE);
        }
        else if (fragmentCheck == FRAGMENT_SHOPS)
        {
            fragment = new ShopsFragment();
            relativeLayoutHomeActivity.setVisibility(View.GONE);
        }
        else if (fragmentCheck == FRAGMENT_MORE)
        {
            fragment = new MoreFragment();
            relativeLayoutHomeActivity.setVisibility(View.GONE);
        }

        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout_home , fragment);
            fragmentTransaction.commit();
        }
    }

}
