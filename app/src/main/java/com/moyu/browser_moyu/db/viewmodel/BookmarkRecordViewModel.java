package com.moyu.browser_moyu.db.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.moyu.browser_moyu.db.MyDataBase;
import com.moyu.browser_moyu.db.entity.BookmarkRecord;
import com.moyu.browser_moyu.db.entity.HistoryRecord;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

import io.reactivex.Completable;

public class BookmarkRecordViewModel extends AndroidViewModel {

    //数据库实列
    private  MyDataBase myDatabase;


    private LiveData<List<BookmarkRecord>> bookmarkRecordLiveData;

    public BookmarkRecordViewModel(@NonNull Application application) {
        super(application);
        myDatabase = MyDataBase.getInstance(application);
        bookmarkRecordLiveData = myDatabase.bookmarkRecordDao().getBookmarkRecords();

    }

    //新增记录操作
    public Completable insertBookmarkRecord(final String title, final  String url){
        BookmarkRecord bookmarkRecord = new BookmarkRecord(title, url);
        return myDatabase.bookmarkRecordDao().insertBookmarkRecord(bookmarkRecord);
    }

    //删除单个记录
    public Completable deleteBookmarkRecord(BookmarkRecord bookmarkRecord){
        return myDatabase.bookmarkRecordDao().deleteBookmarkRecord(bookmarkRecord);
    }

    //删除所有记录
    public Completable deleteBookmarkRecords(){
        return myDatabase.bookmarkRecordDao().deleteBookMarkRecords();
    }

    //更新记录
    public Completable updateBookmarkRecord(BookmarkRecord bookmarkRecord){
        return myDatabase.bookmarkRecordDao().updateBookmarkRecord(bookmarkRecord);
    }

    public LiveData<List<BookmarkRecord>> getLiveDataBookmarkRecord()
    {
        return bookmarkRecordLiveData;
    }
}
