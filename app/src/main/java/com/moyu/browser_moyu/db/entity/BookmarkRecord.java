package com.moyu.browser_moyu.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BookmarkRecord {

    //自增uid，用于标识增加顺序
    @PrimaryKey(autoGenerate = true)
    public int uid;

    //标题
    @ColumnInfo
    public String title;

    //网址
    @ColumnInfo
    public String url;

    public BookmarkRecord(String title, String url) {
        this.title = title;
        this.url = url;
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
}
