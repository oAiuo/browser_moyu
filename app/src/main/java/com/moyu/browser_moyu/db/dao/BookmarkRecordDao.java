package com.moyu.browser_moyu.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.moyu.browser_moyu.db.entity.BookmarkRecord;

import java.util.List;

@Dao
public interface BookmarkRecordDao {
    @Insert
    void insertBookmarkRecord(BookmarkRecord bookmarkRecord);

    @Delete
    void deleteBookmarkRecord(BookmarkRecord bookmarkRecord);

    @Update
    void updateBookmarkRecord(BookmarkRecord bookmarkRecord);

    @Query("SELECT * FROM bookmarkrecord")
    LiveData<List<BookmarkRecord>> getBookmarkRecord();//希望监听历史记录的变化，为其加上LiveData
}
