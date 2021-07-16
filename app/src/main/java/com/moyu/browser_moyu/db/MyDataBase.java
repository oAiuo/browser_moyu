package com.moyu.browser_moyu.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.moyu.browser_moyu.db.converters.Converters;
import com.moyu.browser_moyu.db.dao.BookmarkRecordDao;
import com.moyu.browser_moyu.db.dao.HistoryRecordDao;
import com.moyu.browser_moyu.db.entity.BookmarkRecord;
import com.moyu.browser_moyu.db.entity.HistoryRecord;

@Database(entities = {HistoryRecord.class, BookmarkRecord.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class MyDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db";

    private static MyDataBase databaseInstance =  null;

    public static  MyDataBase getInstance(Context context)
    {

        if(databaseInstance == null)
        {
            synchronized (MyDataBase.class) {
                if(databaseInstance == null) {
                    databaseInstance = Room
                            .databaseBuilder(context.getApplicationContext(), MyDataBase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return databaseInstance;
    }

    public abstract HistoryRecordDao historyRecordDao() ;
    public abstract BookmarkRecordDao bookmarkRecordDao();
}
