package com.moyu.browser_moyu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moyu.browser_moyu.history.activity.HistoryRecordActivity;
import com.moyu.browser_moyu.searchpage.activity.SearchPageFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_search_page, SearchPageFragment.class, null)
                    .commit();
        }
    }
}