package com.moyu.browser_moyu.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.moyu.browser_moyu.db.entity.HistoryRecord;

import java.util.List;

@Dao
public interface HistoryRecordDao {

    @Insert
    void insertStudent(HistoryRecord historyRecord);

    @Delete
    void deleteStudent(HistoryRecord historyRecord);

    @Update
    void updateStudent(HistoryRecord historyRecord);

    @Query("SELECT * FROM historyRecord")
    LiveData<List<HistoryRecord>> getHistoryRecord();//希望监听历史记录的变化，为其加上LiveData


}
