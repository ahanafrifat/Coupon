package com.appinionbd.coupon.view.home.fragment;


import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import com.appinionbd.coupon.interfaces.couponsFragmentOptionListInterface.ICouponsFragmentOptionListInterface;
import com.appinionbd.coupon.interfaces.couponsFragmentOptionListInterface.ICouponsFragmentOptionSubListInterface;
import com.appinionbd.coupon.interfaces.homeFragmentInterface.IHomeFragmentOptionListInterface;
import com.appinionbd.coupon.interfaces.presenterInterface.ICouponsFragment;
import com.appinionbd.coupon.model.tempModels.CouponsList;
import com.appinionbd.coupon.model.tempModels.CouponsSubList;
import com.appinionbd.coupon.model.tempModels.ListOptions;
import com.appinionbd.coupon.model.tempModels.ListSubOptions;
import com.appinionbd.coupon.presenter.CouponsFragmentPresenter;
import com.appinionbd.coupon.view.adapter.RecyclerAdapterHome;
import com.appinionbd.coupon.view.adapter.couponsAdapter.RecyclerAdapterCoupons;
import com.appinionbd.coupon.view.adapter.couponsAdapter.RecyclerAdapterCouponsSubList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CouponsFragment extends Fragment implements ICouponsFragment.View {

    RecyclerView recyclerViewCoupons;
    List<CouponsSubList> couponsSubLists;


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

        List<CouponsList> couponsLists = new ArrayList<>();
        couponsLists.add(new CouponsList("0" , "Great Coupons Deal for Today"));
        couponsLists.add(new CouponsList("1" , "Appinion Coupons Gift Card"));
        couponsLists.add(new CouponsList("2" , "Recommended Coupons for you"));

        couponsSubLists = new ArrayList<>();
        couponsSubLists.add(new CouponsSubList("0" , "0" , "Sushi Place" , "Buy 1 Get 1 of any platter" , R.drawable.food_1 , 0));
        couponsSubLists.add(new CouponsSubList("1" , "0" , "Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_2 , 0));
        couponsSubLists.add(new CouponsSubList("2" , "0" , "Burger Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_3, 0));
        couponsSubLists.add(new CouponsSubList("3" , "0" , "Pizza Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_4 , 0));
        couponsSubLists.add(new CouponsSubList("4" , "0" , "Burger Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_3, 0));
        couponsSubLists.add(new CouponsSubList("5" , "0" , "Pizza Palace" , "Buy 1 Get 1 of any platter", R.drawable.food_4 , 0));

        recyclerViewCoupons = getActivity().findViewById(R.id.recyclerView_coupons);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCoupons.setLayoutManager(layoutManager);
        recyclerViewCoupons.setHasFixedSize(true);

//        RecyclerAdapterHome recyclerAdapterHome = new RecyclerAdapterHome(listOptions, new IHomeFragmentOptionListInterface() {
//            @Override
//            public void showSubListOfOptions(String optionId, RecyclerView recyclerViewHomeOptions) {
//                createSubListOfOptions(optionId , recyclerViewHomeOptions);
//            }
//        });

        RecyclerAdapterCoupons recyclerAdapterCoupons = new RecyclerAdapterCoupons(couponsLists, new ICouponsFragmentOptionListInterface() {
            @Override
            public void showCouponsSubListOfOptions(String optionId, RecyclerView recyclerViewCouponsOptions) {
                createCouponsSubList(optionId , recyclerViewCouponsOptions);
            }
        });
        recyclerViewCoupons.setAdapter(recyclerAdapterCoupons);
        recyclerAdapterCoupons.notifyDataSetChanged();
    }

    private void createCouponsSubList(String optionId, RecyclerView recyclerViewCouponsOptions) {
        try{
            RecyclerView.LayoutManager layoutManagerforOptions = new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , true );
            recyclerViewCouponsOptions.setLayoutManager(layoutManagerforOptions);
            recyclerViewCouponsOptions.setHasFixedSize(true);

            RecyclerAdapterCouponsSubList recyclerAdapterCouponsSubList = new RecyclerAdapterCouponsSubList(couponsSubLists, new ICouponsFragmentOptionSubListInterface() {
                @Override
                public void imageBlur(ImageView imageView, LinearLayout linearLayoutSubList) {
                    applyBlur(imageView , linearLayoutSubList);
                }

                @Override
                public void favouriteIconClick(int favourite) {

                }
            });

            recyclerViewCouponsOptions.setAdapter(recyclerAdapterCouponsSubList);
            recyclerAdapterCouponsSubList.notifyDataSetChanged();
            recyclerViewCouponsOptions.setHasFixedSize(true);

        }
        catch (Exception e){
            Log.d("CouponsFragment" , e.getMessage());
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
}
