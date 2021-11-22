package com.iamandiiana.newsreader.feature.newslist.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.iamandiiana.data.NewsRepository;
import com.iamandiiana.newsreader.feature.newslist.mapper.ListArticleToListViewModel;
import com.iamandiiana.newsreader.feature.newslist.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends AndroidViewModel implements DefaultLifecycleObserver {

    @NonNull
    public ObservableList<ArticleItemViewModel> newsList;
    public final SingleLiveEvent<Throwable> error;

    private final NewsRepository repo;

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.newsList = new ObservableArrayList();
        this.error = new SingleLiveEvent<>();
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        newsList.clear();
        newsList.addAll(articles);
    }

    private void onNewsArticlesError(Throwable throwable) {
        error.setValue(throwable);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onCreate(LifecycleOwner owner) {
        repo.getNewsArticles()
                .map(new ListArticleToListViewModel())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

}