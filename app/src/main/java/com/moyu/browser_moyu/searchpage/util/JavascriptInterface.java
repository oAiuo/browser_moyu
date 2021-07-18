package com.moyu.browser_moyu.searchpage.util;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.moyu.browser_moyu.searchpage.activity.PhotoBrowserActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/2/10.
 */
public class JavascriptInterface {
    private Context context;
    private String [] imageUrls;

    public JavascriptInterface(Context context,String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @android.webkit.JavascriptInterface
    public void openImage(String img) {
        Intent intent = new Intent();
        intent.putExtra("imageUrls", imageUrls);
        intent.putExtra("curImageUrl", img);
        intent.setClass(context, PhotoBrowserActivity.class);
        context.startActivity(intent);
        for (int i = 0; i < imageUrls.length; i++) {
            Log.e("图片地址"+i,imageUrls[i].toString());
        }
    }
}
