package com.iamandiiana.data.features.news.local;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "articles")
public class ArticleEntity {
    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String imageUrl;
    public String title;
    public String content;
    public String description;

    public ArticleEntity(String imageUrl, String title, String content, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }
}
