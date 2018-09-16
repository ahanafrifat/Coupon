package com.appinionbd.coupon.view.adapter.shopsAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.model.tempModels.ShopsList;

import java.util.List;

public class RecyclerAdapterShops extends RecyclerView.Adapter<RecyclerAdapterShops.ShopsViewHolder> {

    private List<ShopsList> shopsLists;

    public RecyclerAdapterShops(List<ShopsList> shopsLists) {
        this.shopsLists = shopsLists;
    }

    @NonNull
    @Override
    public ShopsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shops , parent , false);
        return new ShopsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopsViewHolder holder, int position) {

        holder.textViewShopOfferTitle.setText(shopsLists.get(position).getTitle());
        holder.textViewShopOfferDes.setText(shopsLists.get(position).getDes());
    }

    @Override
    public int getItemCount() {
        return shopsLists.size();
    }

    class ShopsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewShopOfferTitle;
        TextView textViewShopOfferDes;
        ImageView imageViewShopOfferShare;
        ImageView imageViewShopOfferPhone;
        ImageView imageViewShopOfferFavorite;
        Button buttonShopOffer;

        public ShopsViewHolder(View itemView) {
            super(itemView);

            textViewShopOfferTitle = itemView.findViewById(R.id.textView_shop_offer_title);
            textViewShopOfferDes = itemView.findViewById(R.id.textView_shop_offer_des);
            imageViewShopOfferShare = itemView.findViewById(R.id.imageView_shop_offer_share);
            imageViewShopOfferPhone = itemView.findViewById(R.id.imageView_shop_offer_phone);
            imageViewShopOfferFavorite = itemView.findViewById(R.id.imageView_shop_offer_favorite);
            buttonShopOffer = itemView.findViewById(R.id.button_shop_offer);
        }
    }
}
