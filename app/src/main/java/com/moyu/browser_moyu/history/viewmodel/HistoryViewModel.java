package com.moyu.browser_moyu.history.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.moyu.browser_moyu.db.MyDataBase;
import com.moyu.browser_moyu.db.entity.HistoryRecord;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    private final MyDataBase myDataBase;
    private LiveData<List<HistoryRecord>> liveDataHistoryRecord;

    public HistoryViewModel(@NonNull Application application){
        super();
        myDataBase = MyDataBase.getInstance(application);
        liveDataHistoryRecord = myDataBase.historyRecordDao().getHistoryRecord();
    }

    public LiveData<List<HistoryRecord>> getLiveDataHistoryRecord(){
        return liveDataHistoryRecord;
    }
}
