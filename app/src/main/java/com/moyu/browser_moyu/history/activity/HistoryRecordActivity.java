package com.moyu.browser_moyu.history.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.moyu.browser_moyu.BR;
import com.moyu.browser_moyu.MainActivity;
import com.moyu.browser_moyu.R;
import com.moyu.browser_moyu.db.MyDataBase;
import com.moyu.browser_moyu.db.entity.HistoryRecord;
import com.moyu.browser_moyu.db.viewmodel.HistoryViewModel;
import com.moyu.browser_moyu.history.adapter.ListViewAdapter;
import com.moyu.browser_moyu.history.bean.HistoryBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class HistoryRecordActivity extends AppCompatActivity {

    MyDataBase myDataBase ;
    HistoryViewModel mViewModel;
    ListView listView;
    List<HistoryRecord> historyList= new ArrayList<>();
    private CompositeDisposable mDisposable ;
    private  ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDataBase = MyDataBase.getInstance(getApplicationContext());
        mViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        setContentView(R.layout.activity_history_record);
        listView = findViewById(R.id.historyListView);
        mDisposable = new CompositeDisposable();


        listViewAdapter = new ListViewAdapter(HistoryRecordActivity.this,
                historyList);
        listView.setAdapter(listViewAdapter);


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