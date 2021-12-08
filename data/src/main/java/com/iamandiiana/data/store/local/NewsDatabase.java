package com.iamandiiana.data.store.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.iamandiiana.data.features.news.local.ArticleDao;
import com.iamandiiana.data.features.news.local.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();

}
