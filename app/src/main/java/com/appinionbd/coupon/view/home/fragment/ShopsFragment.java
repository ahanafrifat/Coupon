package com.appinionbd.coupon.view.home.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.presenterInterface.IShops;
import com.appinionbd.coupon.model.tempModels.ShopsList;
import com.appinionbd.coupon.presenter.ShopsFragmentPresenter;
import com.appinionbd.coupon.view.adapter.shopsAdapter.RecyclerAdapterShops;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFragment extends Fragment implements IShops.View{

    RecyclerView recyclerViewShop;
    List<ShopsList> shopsLists;

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

        recyclerViewShop = getActivity().findViewById(R.id.recyclerView_shop);

        start();

    }

    private void start() {
        shopsLists = new ArrayList<>();
        shopsLists.add(new ShopsList("0" ,"Buy 1 Get 1" , "Get Extra 10% Off Selected Drinks"));
        shopsLists.add(new ShopsList("1" ,"Up To 30% Off" , "Get Extra 20% Off Selected Drinks"));
        shopsLists.add(new ShopsList("2" ,"Up To 50% Off" , "Get Extra 15% Off Selected Drinks"));
        shopsLists.add(new ShopsList("3" ,"Up To 10% Off" , "Get Extra 5% Off Selected Drinks"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false);
        recyclerViewShop.setLayoutManager(layoutManager);
        recyclerViewShop.setHasFixedSize(true);

        RecyclerAdapterShops recyclerAdapterShops = new RecyclerAdapterShops(shopsLists);
        recyclerViewShop.setAdapter(recyclerAdapterShops);
        recyclerAdapterShops.notifyDataSetChanged();
    }
}
