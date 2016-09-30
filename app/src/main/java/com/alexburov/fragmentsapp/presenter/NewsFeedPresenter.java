package com.alexburov.fragmentsapp.presenter;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.alexburov.fragmentsapp.R;
import com.alexburov.fragmentsapp.model.News;
import com.alexburov.fragmentsapp.model.NewsFeedModel;
import com.alexburov.fragmentsapp.model.NewsModelI;
import com.alexburov.fragmentsapp.view.NewsContentI;
import com.alexburov.fragmentsapp.view.NewsContentView;

import java.util.ArrayList;

/**
 * Created by Acer on 30.09.2016.
 */
public class NewsFeedPresenter implements NewsFeedI{
    static NewsFeedPresenter instance;
    static int FRAGMENT_LIST =1;
    static int FRAGMENT_NEWS_TEXT =2;


    private NewsFeedPresenter(){
    }

    public static NewsFeedPresenter getInstance(){
        if (null==instance) instance= new NewsFeedPresenter();
        return instance;
    }

    @Override
    public ArrayList<News> getNewsList() {
        return NewsFeedModel.getInstance().getNewsList();
    }

    @Override
    public void startPresenting(AppCompatActivity activity) {
       Fragment fragment = activity.getSupportFragmentManager().findFragmentById(R.id.container);
       if (fragment == null) {
           NewsFeedModel.getInstance().setNewsListFragment(new NewsContentView());
            activity.getSupportFragmentManager().
                    beginTransaction().add(R.id.container, NewsFeedModel.getInstance().getNewsListFragment())
                    .commit();
        }
    }

    @Override
    public void updateNewsList() {
        NewsFeedModel.getInstance().getNewsListFragment().updateContentView();
    }
}
