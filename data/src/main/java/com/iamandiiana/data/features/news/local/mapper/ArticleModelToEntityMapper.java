package com.iamandiiana.data.features.news.local.mapper;

import androidx.annotation.NonNull;

import com.iamandiiana.data.features.news.local.ArticleEntity;
import com.iamandiiana.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleModelToEntityMapper implements Function<List<Article>, List<ArticleEntity>> {
    @Override
    public List<ArticleEntity> apply(@NonNull List<Article> articles) throws Exception {
        List<ArticleEntity> articleEntities = new ArrayList<>();
        for(Article a : articles)
            articleEntities.add(new ArticleEntity(a.imageUrl, a.title, a.content, a.description));
        return articleEntities;
    }
}
