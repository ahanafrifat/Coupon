package com.appinionbd.coupon.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.homeFragmentInterface.IHomeFragmentOptionSubListInterface;
import com.appinionbd.coupon.model.tempModels.ListSubOptions;

import java.util.List;

public class RecyclerAdapterHomeOptionsList extends  RecyclerView.Adapter<RecyclerAdapterHomeOptionsList.SubListViewHolder>{

    List<ListSubOptions> listSubOptions;
    IHomeFragmentOptionSubListInterface iHomeFragmentOptionSubListInterface;

    public RecyclerAdapterHomeOptionsList(List<ListSubOptions> listSubOptions, IHomeFragmentOptionSubListInterface iHomeFragmentOptionSubListInterface) {
        this.listSubOptions = listSubOptions;
        this.iHomeFragmentOptionSubListInterface = iHomeFragmentOptionSubListInterface;
    }

    @NonNull
    @Override
    public SubListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home_sub_options, parent , false);
        return new SubListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubListViewHolder holder, int position) {

        iHomeFragmentOptionSubListInterface.imageBlur(holder.imageViewSubList);

    }


    @Override
    public int getItemCount() {
        return listSubOptions.size();
    }

    class SubListViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewSubList;
        TextView textViewSubListTitle;
        TextView textViewSubListDes;
        ImageView imageViewFavourite;

        public SubListViewHolder(View itemView) {
            super(itemView);
            imageViewSubList = itemView.findViewById(R.id.imageView_sub_list);
            textViewSubListTitle = itemView.findViewById(R.id.textView_sub_list_title);
            textViewSubListDes = itemView.findViewById(R.id.textView_sub_list_des);
            imageViewFavourite = itemView.findViewById(R.id.imageView_favourite);
        }
    }
}
