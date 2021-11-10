package com.iamandiiana.newsreader.feature.newslist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iamandiiana.newsreader.databinding.NewsItemBinding;
import com.iamandiiana.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<ArticleItemViewModel> itemModelList;

    public NewsListAdapter() {
        this.itemModelList = new ArrayList<>();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsItemBinding binder = NewsItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new NewsViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.binding.setViewModel(itemModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public void setItems(List<ArticleItemViewModel> items) {
        this.itemModelList = items;
        notifyDataSetChanged();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        final NewsItemBinding binding;

        public NewsViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

