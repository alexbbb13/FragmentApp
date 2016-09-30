package com.alexburov.fragmentsapp.model;

import com.alexburov.fragmentsapp.view.NewsContentView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 30.09.2016.
 */
public interface NewsModelI {
//    String getNewsHeader(int newsID);
//    String getNewsText(int newsID);
//    void updateNews(JSONObject jsonNews);
    public ArrayList<News> getNewsList();
    public void setNewsListFragment(NewsContentView fragment);
    public NewsContentView getNewsListFragment();
}
