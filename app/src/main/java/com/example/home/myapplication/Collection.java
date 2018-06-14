package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Collection extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent = new Intent();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent.setClass(Collection.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_collection:
                    intent.setClass(Collection.this,Collection.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_setting:
                    intent.setClass(Collection.this,Setting.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    intent.setClass(Collection.this,Search.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_question:
                    intent.setClass(Collection.this,Question.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_collection);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ArrayList<Menu> menu = new ArrayList<Menu>();






        MenuArrayAdapter adapter = new MenuArrayAdapter (this, menu);
        ListView lv = (ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);
        //lv.setOnItemClickListener(itemclick);
    }


}
