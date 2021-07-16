package com.moyu.browser_moyu.history.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ListView;

import com.moyu.browser_moyu.BR;
import com.moyu.browser_moyu.R;

import com.moyu.browser_moyu.history.adapter.ListViewAdapter;
import com.moyu.browser_moyu.history.bean.HistoryBean;
import com.moyu.browser_moyu.history.viewmodel.HistoryViewModel;

import java.util.ArrayList;
import java.util.List;


public class HistoryRecordActivity extends AppCompatActivity {

    HistoryViewModel mViewModel;
    ListView listView;
    List<HistoryBean> history= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        listView = findViewById(R.id.historyListView);


        ListViewAdapter<HistoryBean> HistoryListViewAdapter = new ListViewAdapter<>(this,
                getLayoutInflater(),
                R.layout.history_list_item,
                BR.history,
                history);
        listView.setAdapter(HistoryListViewAdapter);
    }


}