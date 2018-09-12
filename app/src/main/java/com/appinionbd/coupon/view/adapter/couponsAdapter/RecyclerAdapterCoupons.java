package com.appinionbd.coupon.view.adapter.couponsAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.couponsFragmentOptionListInterface.ICouponsFragmentOptionListInterface;
import com.appinionbd.coupon.model.tempModels.CouponsList;

import java.util.List;

public class RecyclerAdapterCoupons extends RecyclerView.Adapter<RecyclerAdapterCoupons.CouponsViewHolder> {

    List<CouponsList> couponsLists;
    ICouponsFragmentOptionListInterface iCouponsFragmentOptionListInterface;

    public RecyclerAdapterCoupons(List<CouponsList> couponsLists, ICouponsFragmentOptionListInterface iCouponsFragmentOptionListInterface) {
        this.couponsLists = couponsLists;
        this.iCouponsFragmentOptionListInterface = iCouponsFragmentOptionListInterface;
    }

    @NonNull
    @Override
    public CouponsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_coupons , parent , false);
        return new CouponsViewHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CouponsViewHolder holder, int position) {

        holder.textViewCouponsTopicTitle.setText(couponsLists.get(position).getTitle());
        holder.textViewCouponsSeeAll.setOnClickListener(v -> {

        });

        iCouponsFragmentOptionListInterface.showCouponsSubListOfOptions(couponsLists.get(position).getId() , holder.recyclerViewCouponsOptions);
    }

    @Override
    public int getItemCount() {
        return couponsLists.size();
    }

    class CouponsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewCouponsTopicTitle;
        TextView textViewCouponsSeeAll;
        RecyclerView recyclerViewCouponsOptions;

        public CouponsViewHolder(View itemView) {
            super(itemView);
            textViewCouponsTopicTitle = itemView.findViewById(R.id.textView_coupons_topic_title);
            textViewCouponsSeeAll = itemView.findViewById(R.id.textView_coupons_see_all);
            recyclerViewCouponsOptions = itemView.findViewById(R.id.recyclerView_coupons_options);
        }
    }
}
