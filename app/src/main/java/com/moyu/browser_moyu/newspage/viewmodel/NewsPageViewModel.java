package com.moyu.browser_moyu.newspage.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moyu.browser_moyu.newspage.entity.Link;
import com.moyu.browser_moyu.newspage.util.APIutil;

import java.util.ArrayList;
import java.util.List;


public class NewsPageViewModel extends ViewModel {

    private MutableLiveData<String> keyWord;
    private MutableLiveData<List<Link>> urlAndTitle;

    public MutableLiveData<String> getKeyWord() {
        return keyWord;
    }

    public MutableLiveData<List<Link>> getUrlAndTitle() {
        if (urlAndTitle == null) {
            urlAndTitle = new MutableLiveData<>();
        }
        return urlAndTitle;
    }

    public NewsPageViewModel() {
        keyWord = new MutableLiveData<>();
        urlAndTitle = new MutableLiveData<>();
    }
}

