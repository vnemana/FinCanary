package com.fincanary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
    static TextView textView;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.article_fragment, container, false);
        textView = view.findViewById(R.id.articleText);
        return view;
    }

    public void updateArticleView(String content) {
        if (textView != null)
            textView.setText(content);
    }
}
