package com.iamandiiana.newsreader.feature.newslist.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

public class NewsListViewModel extends ViewModel implements DefaultLifecycleObserver {

    private static final String imageUrl = "https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-mediumSquareAt3X-v2.jpg";
    @NonNull
    public ObservableList<ArticleItemViewModel> newsList;

    public NewsListViewModel() {
        this.newsList = new ObservableArrayList();
    }

    @Override
    public void onCreate(LifecycleOwner owner) {

        if (newsList.isEmpty()) {
            newsList.add(new ArticleItemViewModel("title", "description", imageUrl));
            newsList.add(new ArticleItemViewModel("title1", "description1", imageUrl));
            newsList.add(new ArticleItemViewModel("title2", "description2", imageUrl));
            newsList.add(new ArticleItemViewModel("title", "description", imageUrl));
            newsList.add(new ArticleItemViewModel("title1", "description1", imageUrl));
            newsList.add(new ArticleItemViewModel("title2", "description2", imageUrl));
        }
    }

}