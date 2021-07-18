package com.moyu.browser_moyu.history.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moyu.browser_moyu.R;
import com.moyu.browser_moyu.db.entity.HistoryRecord;



import java.util.List;


public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<HistoryRecord> historyRecordList;


    public ListViewAdapter(Context context,List<HistoryRecord> historyRecordList){
        this.historyRecordList = historyRecordList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    class ViewHolder{
        TextView tvtitle;
        TextView tvurl;
    }

    @Override
    public int getCount(){
        if(historyRecordList == null){
            return 0;
        }
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView =layoutInflater.inflate(R.layout.history_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.tvtitle =convertView.findViewById(R.id.tvtitle);
            viewHolder.tvurl =convertView.findViewById(R.id.tvurl);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvtitle.setText(String.valueOf(historyRecordList.get(position).title));
        viewHolder.tvurl.setText(String.valueOf(historyRecordList.get(position).url));
        return convertView;
    }
}
