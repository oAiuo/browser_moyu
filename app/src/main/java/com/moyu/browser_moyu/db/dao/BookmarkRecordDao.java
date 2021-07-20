package com.moyu.browser_moyu.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.moyu.browser_moyu.db.entity.BookmarkRecord;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface BookmarkRecordDao {
    //插入新记录
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertBookmarkRecord(BookmarkRecord bookmarkRecord);

    //删除单个记录
    @Delete
    Completable deleteBookmarkRecord(BookmarkRecord bookmarkRecord);

    //删除所有记录
    @Query("DELETE FROM HistoryRecords")
    Completable deleteBookMarkRecords();

    //修改书签内容
    @Update(onConflict = OnConflictStrategy.REPLACE)
    Completable updateBookmarkRecord(BookmarkRecord bookmarkRecord);

    @Query("SELECT * FROM bookmarkrecord ORDER BY Uid")
    LiveData<List<BookmarkRecord>> getBookmarkRecords();//希望监听书签的变化，为其加上LiveData
}
