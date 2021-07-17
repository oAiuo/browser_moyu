package com.moyu.browser_moyu.db.converters;

import androidx.room.TypeConverter;

import java.util.Date;

//转换器，时间戳和时间相互转换
public class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}