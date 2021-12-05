package com.iamandiiana.data.features.news.local;

import com.iamandiiana.data.features.news.local.mapper.ArticleEntityToModelMapper;
import com.iamandiiana.data.features.news.local.mapper.ArticleModelToEntityMapper;
import com.iamandiiana.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalSource {
    private final ArticleDao dao;


    public NewsLocalSource(ArticleDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getArticles() {
        return dao.queryArticles().map(new ArticleEntityToModelMapper());
    }

    public Completable saveArticle(ArticleEntity article){
        return dao.insertArticle(article);
    }

    public void saveArticles(List<Article> articles) throws Exception {
        dao.insertArticles(new ArticleModelToEntityMapper().apply(articles))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
