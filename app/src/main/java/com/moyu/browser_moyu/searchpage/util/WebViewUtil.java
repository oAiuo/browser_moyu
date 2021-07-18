package com.moyu.browser_moyu.searchpage.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.moyu.browser_moyu.R;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 判断字符串是否为URL（https://blog.csdn.net/bronna/article/details/77529145）
     *
     * @param urls 要勘定的字符串
     * @return true:是URL、false:不是URL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isUrl;
        // 判断是否是网址的正则表达式
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";

        Pattern pat = Pattern.compile(regex.trim());
        Matcher mat = pat.matcher(urls.trim());
        isUrl = mat.matches();
        return isUrl;
    }

}
