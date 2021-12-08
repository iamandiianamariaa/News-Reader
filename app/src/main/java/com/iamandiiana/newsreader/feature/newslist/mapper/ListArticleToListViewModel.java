package com.iamandiiana.newsreader.feature.newslist.mapper;

import androidx.annotation.NonNull;

import com.iamandiiana.data.features.news.model.Article;
import com.iamandiiana.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ListArticleToListViewModel implements Function<List<Article>, List<ArticleItemViewModel>>{

    @Override
    public List<ArticleItemViewModel> apply(@NonNull List<Article> articles) throws Exception {
        List<ArticleItemViewModel> articlesViewModel = new ArrayList<>();

        for (Article art : articles) {
            ArticleItemViewModel article = new ArticleItemViewModel(//Adding default values for business model
                    art.title != null ? art.title : "",
                    art.content != null ? art.content : "",
                    art.imageUrl != null ? art.imageUrl : ""
                    //dto.description != null ? dto.description : ""
            );

            articlesViewModel.add(article);
        }

        return articlesViewModel;
    }
}
