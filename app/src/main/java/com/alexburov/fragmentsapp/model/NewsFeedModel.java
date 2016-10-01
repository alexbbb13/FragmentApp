package com.alexburov.fragmentsapp.model;

import com.alexburov.fragmentsapp.presenter.NewsFeedI;
import com.alexburov.fragmentsapp.view.NewsContentView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 30.09.2016.
 */
public class NewsFeedModel implements NewsModelI{
private ArrayList<News> cachedNews;
    private static NewsFeedModel instance;
    NewsContentView newsContentView;

    NewsFeedModel(){
        //Create test news feed model
        createTempModel();
    }

    public static NewsFeedModel getInstance() {
        if (null==instance) instance = new NewsFeedModel();
        return instance;
    }
    @Override
    public ArrayList<News> getNewsList() {
        createTempModel();
        return cachedNews;
    }

    @Override
    public void setNewsListFragment(NewsContentView fragment) {
        newsContentView=fragment;
    }

    @Override
    public NewsContentView getNewsListFragment() {
        return newsContentView;
    }

    void createTempModel(){
        cachedNews= new ArrayList<>();
        News testnew;
        for(int i = 1; i<20;i++ ) {
            testnew = new News();
            testnew.setTitle("Title "+ String.valueOf(i));
            testnew.setText("Text " + String.valueOf(i));
            cachedNews.add(testnew);
        }
    }
}
