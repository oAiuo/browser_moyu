package com.moyu.browser_moyu.newspage.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moyu.browser_moyu.newspage.entity.Link;
import com.moyu.browser_moyu.newspage.util.APIutil;

import java.util.ArrayList;


public class NewsPageViewModel extends ViewModel {

    private MutableLiveData<String> keyWord;

    public MutableLiveData<String> getKeyWord() {
        if (keyWord == null) {
            keyWord = new MutableLiveData<>();
        }
        return keyWord;
    }

    public NewsPageViewModel() {

    }
}

