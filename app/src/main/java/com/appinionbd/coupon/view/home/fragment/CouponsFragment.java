package com.appinionbd.coupon.view.home.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.presenterInterface.ICouponsFragment;
import com.appinionbd.coupon.presenter.CouponsFragmentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CouponsFragment extends Fragment implements ICouponsFragment.View {

    ICouponsFragment.Presenter couponsFragmentPresenter;

    public CouponsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coupons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        couponsFragmentPresenter = new CouponsFragmentPresenter(this);
    }
}