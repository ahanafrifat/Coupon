package com.appinionbd.coupon.view.adapter.couponsAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.couponsFragmentOptionListInterface.ICouponsFragmentOptionSubListInterface;
import com.appinionbd.coupon.model.tempModels.CouponsSubList;

import java.util.List;

public class RecyclerAdapterCouponsSubList extends RecyclerView.Adapter<RecyclerAdapterCouponsSubList.CouponsSubListViewHolder> {

    List<CouponsSubList> couponsSubLists;
    ICouponsFragmentOptionSubListInterface iCouponsFragmentOptionSubListInterface;

    public RecyclerAdapterCouponsSubList(List<CouponsSubList> couponsSubLists, ICouponsFragmentOptionSubListInterface iCouponsFragmentOptionSubListInterface) {
        this.couponsSubLists = couponsSubLists;
        this.iCouponsFragmentOptionSubListInterface = iCouponsFragmentOptionSubListInterface;
    }

    @NonNull
    @Override
    public CouponsSubListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_coupons_sub_list, parent , false);
        return new CouponsSubListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouponsSubListViewHolder holder, int position) {

        holder.imageViewCouponsSubList.setImageResource(couponsSubLists.get(position).getImage());
        iCouponsFragmentOptionSubListInterface.imageBlur(holder.imageViewCouponsSubList , holder.linearLayoutCouponsSubList);

        holder.textViewCouponsSubListTitle.setText(couponsSubLists.get(position).getTitle());
        holder.textViewCouponsSubListDes.setText(couponsSubLists.get(position).getDes());

        if(couponsSubLists.get(position).getFavourite() == 0){
            holder.imageViewCouponsFavourite.setImageResource(R.drawable.ic_favorite_border_24dp);
        }
        else if(couponsSubLists.get(position).getFavourite() == 1){
            holder.imageViewCouponsFavourite.setImageResource(R.drawable.ic_favorite_24dp);
        }

        holder.imageViewCouponsFavourite.setOnClickListener(v -> {
            if(couponsSubLists.get(position).getFavourite() == 0){
                couponsSubLists.get(position).setFavourite(1);
                holder.imageViewCouponsFavourite.setImageResource(R.drawable.ic_favorite_24dp);
            }
            else if(couponsSubLists.get(position).getFavourite() == 1){
                couponsSubLists.get(position).setFavourite(0);
                holder.imageViewCouponsFavourite.setImageResource(R.drawable.ic_favorite_border_24dp);
            }
        });
    }

    @Override
    public int getItemCount() {
        return couponsSubLists.size();
    }

    class CouponsSubListViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewCouponsSubList;
        TextView textViewCouponsSubListTitle;
        TextView textViewCouponsSubListDes;
        ImageView imageViewCouponsFavourite;
        LinearLayout linearLayoutCouponsSubList;

        public CouponsSubListViewHolder(View itemView) {
            super(itemView);

            imageViewCouponsSubList = itemView.findViewById(R.id.imageView_coupons_sub_list);
            textViewCouponsSubListTitle = itemView.findViewById(R.id.textView_coupons_sub_list_title);
            textViewCouponsSubListDes = itemView.findViewById(R.id.textView_coupons_sub_list_des);
            imageViewCouponsFavourite = itemView.findViewById(R.id.imageView_coupons_favourite);

            linearLayoutCouponsSubList = itemView.findViewById(R.id.linearLayout_coupons_sub_list);
        }
    }
}
