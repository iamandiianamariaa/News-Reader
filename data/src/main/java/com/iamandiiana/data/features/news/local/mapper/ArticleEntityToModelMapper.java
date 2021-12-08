package com.iamandiiana.data.features.news.local.mapper;

import androidx.annotation.NonNull;

import com.iamandiiana.data.features.news.local.ArticleEntity;
import com.iamandiiana.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntityToModelMapper implements Function<List<ArticleEntity>, List<Article>> {
    @Override
    public List<Article> apply(@NonNull List<ArticleEntity> articleEntities) {
        List<Article> articles = new ArrayList<>();
        for (ArticleEntity a : articleEntities)
            articles.add(new Article(a.imageUrl, a.title, a.content, a.description));
        return articles;
    }
}
