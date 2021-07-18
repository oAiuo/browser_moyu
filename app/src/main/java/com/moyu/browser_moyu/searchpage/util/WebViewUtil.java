package com.moyu.browser_moyu.searchpage.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.moyu.browser_moyu.R;

import java.util.Map;

public class WebViewUtil {

    private static SharedPreferences interceptUrl = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    public static void getInstance(Context con){
        context = con;
        String fileName = context.getString(R.string.intercept_url_filename);
        interceptUrl = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = interceptUrl.edit();
    }

    /**
     * 添加需要拦截的URL
     * @param name  URL标识名
     * @param url   具体URL链接
     * @return
     */
    public static boolean addUrl(String name, String url) {
        editor.putString(name, url);
        return editor.commit();
    }

    /**
     * 删除在拦截列表中的URL
     * @param name URL标识名
     * @return
     */
    public static boolean deleteUrl(String name) {
        editor.remove(name);
        return editor.commit();
    }

    /**
     * 当前URL是否需要拦截
     * @param url 具体URL链接
     * @return
     */
    public static boolean isNeedIntercept(String url) {
        Map<String, String> all = (Map<String, String>) interceptUrl.getAll();

        boolean flag = false;
        for (String name: all.keySet()) {
            if ( url.contains(all.get(name)) )
                flag = true;
        }
        return flag;
    }

    private static String localDestPage;
    public static String getLocalDestPage() {
        return localDestPage;
    }

    public static void setLocalDestPage(String destPage) {
        WebViewUtil.localDestPage = destPage;
    }

}
