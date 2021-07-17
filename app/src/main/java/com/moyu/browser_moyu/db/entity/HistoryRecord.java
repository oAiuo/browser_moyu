package com.moyu.browser_moyu.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity
public class HistoryRecord  {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo
    public String title;

    @ColumnInfo
    public String url;

    @ColumnInfo
    public Date date = null;

    public HistoryRecord(String title, String url, Date date) {
        this.title = title;
        this.url = url;
        this.date = date;
    }



    public int getUid() {
        return uid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
