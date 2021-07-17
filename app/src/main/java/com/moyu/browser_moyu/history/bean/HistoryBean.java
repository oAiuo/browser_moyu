package com.moyu.browser_moyu.history.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.moyu.browser_moyu.BR;

public class HistoryBean extends BaseObservable {
    String title;
    String url;
    public HistoryBean(String title,String url){
        this.title = title;
        this.url = url;
    }

    @Bindable
    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getUrl(){
        return url;
    }
    public void setUrl(){
        this.url = url;
    }
}
