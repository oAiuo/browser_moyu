package com.moyu.browser_moyu.navigationlist.activity;

import androidx.lifecycle.LiveData;

public class Data extends LiveData<Data> {

    private int goBack;
    private int goForward;
    private int goHome;

    public int getGoBack() {
        return goBack;
    }

    public void setGoBack(int goBack) {
        this.goBack = goBack;
        postValue(this);
    }

    public int getGoForward() {
        return goForward;
    }

    public void setGoForward(int goForward) {
        this.goForward = goForward;
        postValue(this);
    }

    public int getGoHome() {
        return goHome;
    }

    public void setGoHome(int goHome) {
        this.goHome = goHome;
        postValue(this);
    }
}
