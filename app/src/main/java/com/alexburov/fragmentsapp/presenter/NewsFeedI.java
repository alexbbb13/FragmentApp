package com.alexburov.fragmentsapp.presenter;

import android.support.v7.app.AppCompatActivity;

import com.alexburov.fragmentsapp.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 30.09.2016.
 */
public interface NewsFeedI {
    ArrayList<News> getNewsList();
    void startPresenting(AppCompatActivity activity);
    void updateNewsList();
    //void showNewsText(int newsID);
}
