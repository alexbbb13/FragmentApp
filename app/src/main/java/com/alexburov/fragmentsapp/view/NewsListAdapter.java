package com.alexburov.fragmentsapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alexburov.fragmentsapp.R;
import com.alexburov.fragmentsapp.model.News;

import java.util.ArrayList;

/**
 * Created by Acer on 30.09.2016.
 */
public class NewsListAdapter extends ArrayAdapter<News>{
        public NewsListAdapter(Context context, ArrayList<News> news) {
            super(context,0, news);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            // Check if an existing view is being reused, otherwise inflate the view
            News item  = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_row, parent, false);
            }
            TextView tvNewsRow = (TextView) convertView.findViewById(R.id.tvNewsRow);
            tvNewsRow.setText(item.getTitle());
            return convertView;
        }


}
