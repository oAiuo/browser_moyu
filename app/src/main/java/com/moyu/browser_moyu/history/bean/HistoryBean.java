package com.moyu.browser_moyu.history.bean;


import android.view.View;
import android.widget.Toast;

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
    public String getUrl(){
        return url;
    }
    public void setUrl(String url){
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void click(View v){
        Toast.makeText(v.getContext(),getTitle(),Toast.LENGTH_SHORT).show();
    }
}
