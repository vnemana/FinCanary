package com.fincanary;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

class NewsArticleActivity extends AppCompatActivity
    implements HeadlinesFragment.OnHeadlineClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles_view);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null)
                return;

            HeadlinesFragment firstFragment = new HeadlinesFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                    firstFragment).commit();
        }
    }

    @Override
    public void onArticleClicked(String content) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.article_fragment);
        if (articleFragment != null) {
            articleFragment.updateArticleView(content);
        }
        else {
            ArticleFragment newFragment = new ArticleFragment();
            newFragment.setArguments(getIntent().getExtras());
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, newFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
