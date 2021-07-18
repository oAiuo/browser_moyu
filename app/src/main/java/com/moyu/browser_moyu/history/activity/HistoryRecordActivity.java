package com.moyu.browser_moyu.history.activity;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.moyu.browser_moyu.R;
import com.moyu.browser_moyu.db.MyDataBase;
import com.moyu.browser_moyu.db.entity.HistoryRecord;
import com.moyu.browser_moyu.db.viewmodel.HistoryViewModel;
import com.moyu.browser_moyu.history.adapter.ListViewAdapter;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;



public class HistoryRecordActivity extends AppCompatActivity {

    MyDataBase myDataBase ;
    HistoryViewModel mViewModel;
//    ActivityHistoryRecordBinding binding;
    ListView listView;
    List<HistoryRecord> historyList= new ArrayList<>();
    private CompositeDisposable mDisposable ;
    private  ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mViewModel.getLiveDataHistoryRecord().observe(this, new Observer<List<HistoryRecord>>() {
            @Override
            public void onChanged(List<HistoryRecord> historyRecords) {
                historyList.clear();
                historyList.addAll(historyRecords);
                listViewAdapter.notifyDataSetChanged();
            }
        });

    }




}