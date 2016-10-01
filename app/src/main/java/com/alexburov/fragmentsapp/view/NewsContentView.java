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

import com.alexburov.fragmentsapp.R;
import com.alexburov.fragmentsapp.model.News;
import com.alexburov.fragmentsapp.model.NewsFeedModel;
import com.alexburov.fragmentsapp.presenter.NewsFeedPresenter;

import java.util.ArrayList;

/**
 * Created by Acer on 30.09.2016.
 */
public class NewsContentView extends Fragment implements NewsContentI{
    NewsListAdapter mAdapter;
    ListView lvNews;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        lvNews = (ListView) view.findViewById(R.id.lvNews);
        ArrayList<News> list =  new ArrayList<>();
        mAdapter = new NewsListAdapter(getActivity().getApplicationContext(), NewsFeedPresenter.getInstance().getNewsList());
        lvNews.setAdapter(mAdapter);

        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mAdapter.notifyDataSetChanged();
                //lvNews.setAdapter(mAdapter);
                swipeLayout.setRefreshing(false);
            }
        });

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });


        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // Create new fragment and transaction
                NewsFeedPresenter.getInstance().showNewsText(position);

            }
      });
        return view;
    }

    @Override
    public void updateContentView() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
