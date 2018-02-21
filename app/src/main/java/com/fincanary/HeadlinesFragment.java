package com.fincanary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HeadlinesFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.headlines_fragment, container, false);
        Button button = view.findViewById(R.id.headlineButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onArticleClicked("Headline button clicked");
            }
        });
        return view;
    }

    public OnHeadlineClickedListener mCallback;
    public interface OnHeadlineClickedListener {
        void onArticleClicked(String content);
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnHeadlineClickedListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineClickedListener");
        }
    }

}
