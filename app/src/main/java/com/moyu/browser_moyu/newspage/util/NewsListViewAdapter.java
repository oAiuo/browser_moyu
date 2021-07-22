package com.moyu.browser_moyu.newspage.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moyu.browser_moyu.R;
import com.moyu.browser_moyu.db.entity.HistoryRecord;
import com.moyu.browser_moyu.newspage.entity.Link;

import java.util.ArrayList;
import java.util.List;

public class NewsListViewAdapter extends BaseAdapter {

    Context context;
    private int itemLayoutId;
    private List<Link> itemList;

    public NewsListViewAdapter(Context context, int itemLayoutId, List<Link> itemlist){
        this.context = context;
        this.itemLayoutId = itemLayoutId;
        this.itemList = itemlist;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        TextView title;
        TextView url;
    }

    private static final String TAG = "NewsListViewAdapter";
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Link item = (Link) getItem(position);

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view = LayoutInflater.from(parent.getContext()).inflate(itemLayoutId, parent, false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder = new ViewHolder();
            viewHolder.title = view.findViewById(R.id.news_title);
            viewHolder.url = view.findViewById(R.id.news_url);

            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        // 获取控件实例，并调用set...方法使其显示出来
        viewHolder.title.setText(item.getTitle());
        viewHolder.url.setText(item.getUrl());
        return view;
    }

    public void clearList() {
        itemList.removeAll(itemList);
    }
}
