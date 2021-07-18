package com.moyu.browser_moyu.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.moyu.browser_moyu.db.entity.HistoryRecord;

import java.util.List;

import io.reactivex.Completable;


@Dao
public interface HistoryRecordDao {

    //插入新记录
    @Insert( onConflict = OnConflictStrategy.REPLACE)
    Completable insertHistory(HistoryRecord historyRecord);

    //删除单个记录
    @Delete
    Completable deleteHistoryRecord(HistoryRecord historyRecord);

    //删除所有记录
    @Query("DELETE FROM HistoryRecords")
    Completable  deleteAllHistoryRecords();


    @Query("SELECT * FROM HistoryRecords ORDER BY Uid desc  ")
    LiveData<List<HistoryRecord>> getHistoryRecords();//希望监听历史记录的变化，为其加上LiveData


}
