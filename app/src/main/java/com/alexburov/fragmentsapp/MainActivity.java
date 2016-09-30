package com.alexburov.fragmentsapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.alexburov.fragmentsapp.presenter.NewsFeedPresenter;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setSupportActionBar(toolbar);
        NewsFeedPresenter.getInstance().startPresenting(this);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }
}