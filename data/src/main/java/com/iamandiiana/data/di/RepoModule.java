package com.iamandiiana.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.iamandiiana.data.NewsRepository;
import com.iamandiiana.data.features.news.NewsRepositoryImpl;
import com.iamandiiana.data.features.news.local.NewsLocalSource;
import com.iamandiiana.data.features.news.remote.NewsRemoteSource;
import com.iamandiiana.data.remote.HttpClientFactory;
import com.iamandiiana.data.store.local.NewsDatabase;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private final HttpClientFactory httpClientFactory;
    @NonNull
    private Context context;

    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    NewsLocalSource provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new NewsLocalSource(database.articleDao());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context,
                            NewsDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }
}
