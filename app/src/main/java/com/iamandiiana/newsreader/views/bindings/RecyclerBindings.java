package com.iamandiiana.newsreader.views.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iamandiiana.newsreader.feature.newslist.adapter.NewsListAdapter;
import com.iamandiiana.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> items) {
        NewsListAdapter newsAdapter = (NewsListAdapter) recyclerView.getAdapter();

        if (newsAdapter == null) {
            newsAdapter = new NewsListAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(newsAdapter);
        }

        newsAdapter.setItems(items);
    }
}
