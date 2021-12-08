package com.iamandiiana.newsreader.feature.newslist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.iamandiiana.newsreader.R;
import com.iamandiiana.newsreader.feature.newslist.fragment.NewsListFragment;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }
    }
}