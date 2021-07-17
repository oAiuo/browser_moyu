package com.moyu.browser_moyu.db.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.moyu.browser_moyu.db.dao.HistoryRecordDao;
import com.moyu.browser_moyu.db.entity.HistoryRecord;
import com.moyu.browser_moyu.db.MyDataBase;

import java.util.Date;
import java.util.List;

import io.reactivex.Completable;

public class HistoryViewModel extends AndroidViewModel {
    private final MyDataBase myDatabase;
    private LiveData<List<HistoryRecord>> liveDataHistoryRecord;

    public HistoryViewModel(@NonNull Application application)
    {
        super(application);

        myDatabase = MyDataBase.getInstance(application);
        liveDataHistoryRecord = myDatabase.historyRecordDao().getHistoryRecords();
    }

    //增加书签
    public Completable insertHistoryRecord(final String title, final  String url){
        HistoryRecord historyRecord = new HistoryRecord(title, url, new Date());
        return myDatabase.historyRecordDao().insertHistory(historyRecord);
    }

    //删除书签
    public Completable deleteHistoryRecord(HistoryRecord historyRecord){
        return myDatabase.historyRecordDao().deleteHistoryRecord(historyRecord);
    }

    //删除所有书签
    public Completable deleteAllHistoryRecords(){
        return myDatabase.historyRecordDao().deleteAllHistoryRecords();
    }


    public LiveData<List<HistoryRecord>> getLiveDataHistoryRecord()
    {
        return liveDataHistoryRecord;
    }
}
