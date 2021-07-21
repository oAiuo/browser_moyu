package com.moyu.browser_moyu.navigationlist.activity;

import androidx.lifecycle.LiveData;

public class Data extends LiveData<Data> {

    private boolean goBack;
    private boolean goForward;
    private boolean goHome;

    public boolean getGoBack() {
        return goBack;
    }

    public void setGoBack(boolean goBack) {
        this.goBack = goBack;
        postValue(this);
    }

    public boolean getGoForward() {
        return goForward;
    }

    public void setGoForward(boolean goForward) {
        this.goForward = goForward;
        postValue(this);
    }

    public boolean getGoHome() {
        return goHome;
    }

    public void setGoHome(boolean goHome) {
        this.goHome = goHome;
        postValue(this);
    }
}
