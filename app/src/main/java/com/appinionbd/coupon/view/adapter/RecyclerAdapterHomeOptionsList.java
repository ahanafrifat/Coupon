package com.appinionbd.coupon.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        iHomeFragmentOptionSubListInterface.imageBlur(holder.imageViewSubList , holder.linearLayoutSubList);

        holder.textViewSubListTitle.setText(listSubOptions.get(position).getTitle());
        holder.textViewSubListDes.setText(listSubOptions.get(position).getDes());

        if(listSubOptions.get(position).getFavourite() == 0){
            holder.imageViewFavourite.setImageResource(R.drawable.ic_favorite_border_24dp);
        }
        else if(listSubOptions.get(position).getFavourite() == 1){
            holder.imageViewFavourite.setImageResource(R.drawable.ic_favorite_24dp);
        }

        holder.imageViewFavourite.setOnClickListener(v -> {
            if(listSubOptions.get(position).getFavourite() == 0){
                listSubOptions.get(position).setFavourite(1);
                holder.imageViewFavourite.setImageResource(R.drawable.ic_favorite_24dp);
            }
            else if(listSubOptions.get(position).getFavourite() == 1){
                listSubOptions.get(position).setFavourite(0);
                holder.imageViewFavourite.setImageResource(R.drawable.ic_favorite_border_24dp);
            }
        });

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
        LinearLayout linearLayoutSubList;

        public SubListViewHolder(View itemView) {
            super(itemView);
            imageViewSubList = itemView.findViewById(R.id.imageView_sub_list);
            textViewSubListTitle = itemView.findViewById(R.id.textView_sub_list_title);
            textViewSubListDes = itemView.findViewById(R.id.textView_sub_list_des);
            imageViewFavourite = itemView.findViewById(R.id.imageView_favourite);

            linearLayoutSubList = itemView.findViewById(R.id.linearLayout_sub_list);


        }
    }
}
