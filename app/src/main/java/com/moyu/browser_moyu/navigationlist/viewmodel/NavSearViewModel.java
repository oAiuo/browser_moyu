package com.moyu.browser_moyu.navigationlist.viewmodel;

import androidx.lifecycle.ViewModel;

import com.moyu.browser_moyu.navigationlist.activity.Data;

public class NavSearViewModel extends ViewModel {

    private Data mdata;

    public Data getData() {
        if (mdata == null) {
            mdata = new Data();
        }
        return mdata;
    }
}
