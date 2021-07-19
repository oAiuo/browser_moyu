package com.moyu.browser_moyu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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