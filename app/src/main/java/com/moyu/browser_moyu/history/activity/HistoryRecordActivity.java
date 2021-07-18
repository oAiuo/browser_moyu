package com.moyu.browser_moyu.history.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ListView;


import com.moyu.browser_moyu.BR;
import com.moyu.browser_moyu.R;

import com.moyu.browser_moyu.db.MyDataBase;
import com.moyu.browser_moyu.db.entity.HistoryRecord;
import com.moyu.browser_moyu.history.adapter.ListViewAdapter;
import com.moyu.browser_moyu.history.bean.HistoryBean;
import com.moyu.browser_moyu.db.viewmodel.HistoryViewModel;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class HistoryRecordActivity extends AppCompatActivity {

    HistoryViewModel mViewModel;
    ListView listView;
    List<HistoryBean> historyList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        setContentView(R.layout.activity_history_record);
        listView = findViewById(R.id.historyListView);

        initData();
        ListViewAdapter<HistoryBean> HistoryListViewAdapter = new ListViewAdapter<>(this,
                getLayoutInflater(),
                R.layout.history_list_item,
                BR.historyBean,
                historyList);
//        listView.setAdapter(HistoryListViewAdapter);


//        mViewModel.getLiveDataHistoryRecord().observe(this, new Observer<List<HistoryRecord>>() {
//            @Override
//            public void onChanged(List<HistoryRecord> historyRecords) {
//                historyList.clear();
//                historyList.addAll(historyRecords);
//                HistoryListViewAdapter.notifyDataSetChanged();
//            }
//        });

    }

    public void initData(){
        for(int i=0;i<3;i++){
//            Date d = new Date(1000000);
//            HistoryRecord historyRecord = new HistoryRecord("this is a title","www.www",d);
//            historyList.add(historyRecord);
            HistoryBean historyBean = new HistoryBean("this is a title","www.wwww");
            historyList.add(historyBean);
        }
    }



}