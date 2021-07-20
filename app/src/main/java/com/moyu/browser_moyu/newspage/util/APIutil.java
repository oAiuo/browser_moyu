package com.moyu.browser_moyu.newspage.util;

import android.util.Log;

import com.moyu.browser_moyu.newspage.entity.Link;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class APIutil {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject postRequestFromUrl(String url, String body) throws IOException, JSONException {
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        PrintWriter out = new PrintWriter(conn.getOutputStream());
        out.print(body);
        out.flush();

        InputStream instream = conn.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            instream.close();
        }
    }

    private static JSONObject getRequestFromUrl(String url) throws IOException, JSONException {
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        try (InputStream instream = conn.getInputStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream, StandardCharsets.UTF_8));

            String jsonText = readAll(rd);
            Log.d(TAG, "getRequestFromUrl: jsonText " + jsonText);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }

    private static final String base_APIUrl = "http://api01.idataapi.cn:8000/news/qihoo?apikey=gngefPRGZi6xokc0sfp37EeVtgEUYF1JpsINriG4sn9pQMjWEebyX43eDkunJ3XN";
    private static final String base_kw = "&kw=";
    private static final String base_pageToken = "&pageToken=";

    private static final ArrayList<Link> titleUrlList = new ArrayList<>();

    public static ArrayList<Link> getTitleUrlList() {
        return titleUrlList;
    }

    public static void initTitleUrlList() {
        // make sure titleUrlList list able to store 10 Link obj
        // cause the third-party API only return 10 (url and title)
        while (titleUrlList.size() < 10) {
            Link obj = new Link();
            titleUrlList.add(obj);
        }
    }

    private static final String TAG = "APIutil";

    /**
     * 输入新的关键词时，调用第三方API，获取新的新闻
     * @param keyWord
     * @param pageToken
     * @return
     */
    public static ArrayList<Link> updateTitleUrlList(String keyWord, int pageToken) {
        try {
            String url = base_APIUrl + base_kw + URLEncoder.encode(keyWord, "UTF-8") + base_pageToken + pageToken;
            Log.d(TAG, "updateTitleUrlList: url " + url);
            JSONObject json = getRequestFromUrl(url);
            JSONArray data = json.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject element = data.getJSONObject(i);
                Link link = titleUrlList.get(i);

                link.setTitle(element.getString("title"));
                link.setUrl(element.getString("url"));
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            e.printStackTrace();
        }
        return titleUrlList;
    }


}
