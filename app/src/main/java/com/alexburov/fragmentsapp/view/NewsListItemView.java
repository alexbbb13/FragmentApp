package com.alexburov.fragmentsapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alexburov.fragmentsapp.R;
import com.alexburov.fragmentsapp.model.News;
import com.alexburov.fragmentsapp.presenter.NewsFeedPresenter;

import java.util.ArrayList;

/**
 * Created by Acer on 30.09.2016.
 */
public class NewsListItemView extends Fragment {
    String text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tvText);
        textView.setText(text);
        return view;
    }

    public void setText(String text) {
        this.text = text;
    }

}
