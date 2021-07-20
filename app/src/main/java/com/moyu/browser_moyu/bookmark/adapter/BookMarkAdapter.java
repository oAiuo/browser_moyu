package com.moyu.browser_moyu.bookmark.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moyu.browser_moyu.R;
import com.moyu.browser_moyu.db.entity.BookmarkRecord;

import java.util.List;

public class BookMarkAdapter extends BaseAdapter {
    Context context;
    private LayoutInflater inflater;
    private List<BookmarkRecord> bookmarkRecordList;

    public BookMarkAdapter(Context context,List<BookmarkRecord> list){
        this.context = context;
        this.bookmarkRecordList = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return bookmarkRecordList.size();
    }

    @Override
    public Object getItem(int position){
        return bookmarkRecordList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    class ViewHolder{
        TextView title;
        TextView url;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.bookmark_list_item
                    , null);
            viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.title);
            viewHolder.url = convertView.findViewById(R.id.url);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(bookmarkRecordList.get(position).getTitle());
        viewHolder.url.setText(bookmarkRecordList.get(position).getUrl());
        return convertView;
    }
}
