package com.moyu.browser_moyu.navigationlist.activity;

import androidx.lifecycle.LiveData;

public class Data extends LiveData<Data> {

    private boolean goBack;
    private boolean goForward;
    private boolean goHome;
    private int useOther;
    private boolean noRecord = false;

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

    public int getUseOther() {
        return useOther;
    }

    public void setUseOther(int useOther) {
        this.useOther = useOther;
        postValue(this);
    }

    public boolean getNoRecord() {
        return noRecord;
    }

    public void setNoRecord(boolean noRecord) {
        this.noRecord = noRecord;
    }
}
