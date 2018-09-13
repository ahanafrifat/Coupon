package com.appinionbd.coupon.view.home.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.presenterInterface.IShops;
import com.appinionbd.coupon.presenter.ShopsFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFragment extends Fragment implements IShops.View{


    IShops.Presenter iShopsPresenter;
    public ShopsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shops, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iShopsPresenter = new ShopsFragmentPresenter(this);
    }
}
