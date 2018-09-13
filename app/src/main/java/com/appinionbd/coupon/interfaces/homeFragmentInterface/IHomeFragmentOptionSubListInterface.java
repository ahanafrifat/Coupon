package com.appinionbd.coupon.interfaces.homeFragmentInterface;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.appinionbd.coupon.model.tempModels.ListSubOptions;

public interface IHomeFragmentOptionSubListInterface {
    void imageBlur(ImageView imageView, LinearLayout linearLayoutSubList);
    void favouriteIconClick(int favourite);
    void linearLayoutSubListClicked(ListSubOptions listSubOptions);
}
