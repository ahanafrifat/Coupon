package com.appinionbd.coupon.view.home.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.homeFragmentInterface.IHomeFragmentOptionListInterface;
import com.appinionbd.coupon.interfaces.presenterInterface.IHomeFragment;
import com.appinionbd.coupon.model.tempModels.ListOptions;
import com.appinionbd.coupon.model.tempModels.ListSubOptions;
import com.appinionbd.coupon.presenter.HomeFragmentPresenter;
import com.appinionbd.coupon.view.adapter.RecyclerAdapterHome;
import com.appinionbd.coupon.view.adapter.RecyclerAdapterHomeOptionsList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements IHomeFragment.View {


    IHomeFragment.Presenter homeFragmentPresenter;
    RecyclerView recyclerViewHome;
    List<ListSubOptions> listSubOptions;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeFragmentPresenter = new HomeFragmentPresenter(this);

        List<ListOptions> listOptions = new ArrayList<>();
        listOptions.add(new ListOptions("0" , "Great Deal for Today"));
        listOptions.add(new ListOptions("1" , "Appinion Gift Card"));
        listOptions.add(new ListOptions("2" , "Recommended for you"));

        listSubOptions = new ArrayList<>();
        listSubOptions.add(new ListSubOptions("0" , "0" , "Sushi Place" , "Buy 1 Get 1 of any platter" , R.drawable.food_1));
        listSubOptions.add(new ListSubOptions("1" , "0" , "Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_2));
        listSubOptions.add(new ListSubOptions("2" , "0" , "Burger Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_3));
        listSubOptions.add(new ListSubOptions("3" , "0" , "Pizza Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_4));

        recyclerViewHome = getActivity().findViewById(R.id.recyclerView_home);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewHome.setLayoutManager(layoutManager);
        recyclerViewHome.setHasFixedSize(true);

        RecyclerAdapterHome recyclerAdapterHome = new RecyclerAdapterHome(listOptions, new IHomeFragmentOptionListInterface() {
            @Override
            public void showSubListOfOptions(String optionId, RecyclerView recyclerViewHomeOptions) {
                createSubListOfOptions(optionId , recyclerViewHomeOptions);
            }
        });
        recyclerViewHome.setAdapter(recyclerAdapterHome);
        recyclerAdapterHome.notifyDataSetChanged();

    }

    private void createSubListOfOptions(String optionId, RecyclerView recyclerViewHomeOptions) {
        try {
            RecyclerView.LayoutManager layoutManagerforOptions = new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , true );
            recyclerViewHomeOptions.setLayoutManager(layoutManagerforOptions);
            recyclerViewHomeOptions.setHasFixedSize(true);

            RecyclerAdapterHomeOptionsList recyclerAdapterHomeOptionsList = new RecyclerAdapterHomeOptionsList(listSubOptions);
            recyclerViewHomeOptions.setAdapter(recyclerAdapterHomeOptionsList);
            recyclerViewHomeOptions.setHasFixedSize(true);
        }
        catch (Exception e){
            Log.d("HomeFragment" , e.getMessage());
        }
    }


}
