package com.moyu.browser_moyu.history.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.moyu.browser_moyu.R;
import com.moyu.browser_moyu.db.entity.HistoryRecord;

import java.util.List;


public class ListViewAdapter<T> extends BaseAdapter {
    Context context;
    private LayoutInflater inflater;
    private List<HistoryRecord> historyRecordList;

    public ListViewAdapter(Context context,List<HistoryRecord> list){
        this.context = context;
        this.historyRecordList = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return historyRecordList.size();
    }

    @Override
    public Object getItem(int position){
        return historyRecordList.get(position);
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
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.history_list_item
                    , null);
            viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.title);
            viewHolder.url = convertView.findViewById(R.id.url);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(historyRecordList.get(position).getTitle());
        viewHolder.url.setText(historyRecordList.get(position).getUrl());
        return convertView;
    }


}
