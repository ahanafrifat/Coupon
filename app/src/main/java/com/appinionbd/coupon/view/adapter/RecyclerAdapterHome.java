package com.appinionbd.coupon.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appinionbd.coupon.R;
import com.appinionbd.coupon.interfaces.homeFragmentInterface.IHomeFragmentOptionListInterface;
import com.appinionbd.coupon.model.tempModels.ListOptions;

import java.util.List;

public class RecyclerAdapterHome extends RecyclerView.Adapter<RecyclerAdapterHome.HomeViewHolder> {

    List<ListOptions> listOptions ;
    IHomeFragmentOptionListInterface iHomeFragmentOptionListInterface;

    public RecyclerAdapterHome(List<ListOptions> listOptions, IHomeFragmentOptionListInterface iHomeFragmentOptionListInterface) {
        this.listOptions = listOptions;
        this.iHomeFragmentOptionListInterface = iHomeFragmentOptionListInterface;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_options , parent , false);
        return new HomeViewHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        holder.textViewTitle.setText(listOptions.get(position).getTitle());
        holder.textViewSeeAll.setOnClickListener(v -> {

        });

        iHomeFragmentOptionListInterface.showSubListOfOptions(listOptions.get(position).getId() , holder.recyclerViewHomeOptions);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager();

    }

    @Override
    public int getItemCount() {
        return listOptions.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle;
        TextView textViewSeeAll;
        RecyclerView recyclerViewHomeOptions;

        public HomeViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textView_topic_title);
            textViewSeeAll = itemView.findViewById(R.id.textView_see_all);
            recyclerViewHomeOptions = itemView.findViewById(R.id.recyclerView_home_options);
        }
    }
}
