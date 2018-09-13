package com.appinionbd.coupon.view.home.fragment;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.homeFragmentInterface.IHomeFragmentOptionListInterface;
import com.appinionbd.coupon.interfaces.homeFragmentInterface.IHomeFragmentOptionSubListInterface;
import com.appinionbd.coupon.interfaces.presenterInterface.IHomeFragment;
import com.appinionbd.coupon.model.tempModels.ListOptions;
import com.appinionbd.coupon.model.tempModels.ListSubOptions;
import com.appinionbd.coupon.presenter.HomeFragmentPresenter;
import com.appinionbd.coupon.view.adapter.RecyclerAdapterHome;
import com.appinionbd.coupon.view.adapter.RecyclerAdapterHomeOptionsList;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.blurry.Blurry;

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
        listSubOptions.add(new ListSubOptions("0" , "0" , "Sushi Place" , "Buy 1 Get 1 of any platter" , R.drawable.food_1 , 0));
        listSubOptions.add(new ListSubOptions("1" , "0" , "Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_2 , 0));
        listSubOptions.add(new ListSubOptions("2" , "0" , "Burger Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_3, 0));
        listSubOptions.add(new ListSubOptions("3" , "0" , "Pizza Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_4 , 0));

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

            RecyclerAdapterHomeOptionsList recyclerAdapterHomeOptionsList = new RecyclerAdapterHomeOptionsList(listSubOptions, new IHomeFragmentOptionSubListInterface() {
                @Override
                public void imageBlur(ImageView imageView, LinearLayout linearLayoutSubList) {
                    applyBlur(imageView , linearLayoutSubList);
                }

                @Override
                public void favouriteIconClick(int favourite) {

                }

                @Override
                public void linearLayoutSubListClicked(ListSubOptions listSubOptions) {
                    openIndividualCouponOfHome(listSubOptions);
                }

            });
            recyclerViewHomeOptions.setAdapter(recyclerAdapterHomeOptionsList);
            recyclerAdapterHomeOptionsList.notifyDataSetChanged();
            recyclerViewHomeOptions.setHasFixedSize(true);
        }
        catch (Exception e){

            Log.d("HomeFragment" , e.getMessage());
        }
    }


    private void applyBlur(ImageView imageView, LinearLayout linearLayoutSubList) {

        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                imageView.buildDrawingCache();
                Bitmap bitmap = imageView.getDrawingCache();
                blur(bitmap , linearLayoutSubList);
                return false;
            }
        });
    }

    private void blur(Bitmap bkg, View view) {
        long startMs = System.currentTimeMillis();

        float radius = 25;

        Bitmap overlay = Bitmap.createBitmap((int) (view.getMeasuredWidth()),
                (int) (view.getMeasuredHeight()), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(overlay);

        canvas.translate(-view.getLeft(), -view.getTop());
        canvas.drawBitmap(bkg, 0, 0, null);

        RenderScript rs = RenderScript.create(getActivity());

        Allocation overlayAlloc = Allocation.createFromBitmap(
                rs, overlay);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(
                rs, overlayAlloc.getElement());

        blur.setInput(overlayAlloc);

        blur.setRadius(radius);

        blur.forEach(overlayAlloc);

        overlayAlloc.copyTo(overlay);

        view.setBackground(new BitmapDrawable(
                getResources(), overlay));

        rs.destroy();
        Log.d("HomeFragment" , System.currentTimeMillis() - startMs + "ms");
    }

    @Override
    public String toString() {
        return "RenderScript";
    }

    private void openIndividualCouponOfHome(ListSubOptions listSubOptions) {

    }

}
