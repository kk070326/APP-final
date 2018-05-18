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

        menu.add(new Menu("經典","炆","炆爌肉","",
                "客家人認為肥瘦兼具的肉才能做出好吃的爌肉，做法是經過炒、煮、燒、煨等製作過程，慢火炆煮越久，豬肉越好吃。",
                "1、材料：五花肉2斤、蒜頭少許、辣椒少許、梅乾菜2兩半。2、調味料：米酒少許、醬油6湯匙、糖1小匙、清水少許。3、步驟：" +
                        "(1)五花肉切成四指寬，水煮滾放入五花肉，再煮沸，改小火煮40分鐘，切成1公分的厚片，備用。(2)熱鍋放入少許油，爆香蒜頭、" +
                        "辣椒，加入調味料，煮滾後放入五花肉再煮沸，改小火燜煮10分鐘，湯汁備用。 (3)梅乾菜洗淨切碎，加入步驟2少許湯汁拌勻。" +
                        "(4)五花肉排入深碗中淋上湯汁，加入梅乾菜，置蒸籠中蒸1小時即可，食時反扣盤中即可 。",
                "http://cloud.hakka.gov.tw/Details?p=67860",R.drawable.img1));
        menu.add(new Menu("經典","炆","炆爌肉","",
                "客家人認為肥瘦兼具的肉才能做出好吃的爌肉，做法是經過炒、煮、燒、煨等製作過程，慢火炆煮越久，豬肉越好吃。",
                "1、材料：五花肉2斤、蒜頭少許、辣椒少許、梅乾菜2兩半。2、調味料：米酒少許、醬油6湯匙、糖1小匙、清水少許。3、步驟：" +
                        "(1)五花肉切成四指寬，水煮滾放入五花肉，再煮沸，改小火煮40分鐘，切成1公分的厚片，備用。(2)熱鍋放入少許油，爆香蒜頭、" +
                        "辣椒，加入調味料，煮滾後放入五花肉再煮沸，改小火燜煮10分鐘，湯汁備用。 (3)梅乾菜洗淨切碎，加入步驟2少許湯汁拌勻。" +
                        "(4)五花肉排入深碗中淋上湯汁，加入梅乾菜，置蒸籠中蒸1小時即可，食時反扣盤中即可 。",
                "http://cloud.hakka.gov.tw/Details?p=67860",R.drawable.img1));
        menu.add(new Menu("經典","炆","炆爌肉","",
                "客家人認為肥瘦兼具的肉才能做出好吃的爌肉，做法是經過炒、煮、燒、煨等製作過程，慢火炆煮越久，豬肉越好吃。",
                "1、材料：五花肉2斤、蒜頭少許、辣椒少許、梅乾菜2兩半。2、調味料：米酒少許、醬油6湯匙、糖1小匙、清水少許。3、步驟：" +
                        "(1)五花肉切成四指寬，水煮滾放入五花肉，再煮沸，改小火煮40分鐘，切成1公分的厚片，備用。(2)熱鍋放入少許油，爆香蒜頭、" +
                        "辣椒，加入調味料，煮滾後放入五花肉再煮沸，改小火燜煮10分鐘，湯汁備用。 (3)梅乾菜洗淨切碎，加入步驟2少許湯汁拌勻。" +
                        "(4)五花肉排入深碗中淋上湯汁，加入梅乾菜，置蒸籠中蒸1小時即可，食時反扣盤中即可 。",
                "http://cloud.hakka.gov.tw/Details?p=67860",R.drawable.img1));        menu.add(new Menu("經典","炆","炆爌肉","",
                "客家人認為肥瘦兼具的肉才能做出好吃的爌肉，做法是經過炒、煮、燒、煨等製作過程，慢火炆煮越久，豬肉越好吃。",
                "1、材料：五花肉2斤、蒜頭少許、辣椒少許、梅乾菜2兩半。2、調味料：米酒少許、醬油6湯匙、糖1小匙、清水少許。3、步驟：" +
                        "(1)五花肉切成四指寬，水煮滾放入五花肉，再煮沸，改小火煮40分鐘，切成1公分的厚片，備用。(2)熱鍋放入少許油，爆香蒜頭、" +
                        "辣椒，加入調味料，煮滾後放入五花肉再煮沸，改小火燜煮10分鐘，湯汁備用。 (3)梅乾菜洗淨切碎，加入步驟2少許湯汁拌勻。" +
                        "(4)五花肉排入深碗中淋上湯汁，加入梅乾菜，置蒸籠中蒸1小時即可，食時反扣盤中即可 。",
                "http://cloud.hakka.gov.tw/Details?p=67860",R.drawable.img1));        menu.add(new Menu("經典","炆","炆爌肉","",
                "客家人認為肥瘦兼具的肉才能做出好吃的爌肉，做法是經過炒、煮、燒、煨等製作過程，慢火炆煮越久，豬肉越好吃。",
                "1、材料：五花肉2斤、蒜頭少許、辣椒少許、梅乾菜2兩半。2、調味料：米酒少許、醬油6湯匙、糖1小匙、清水少許。3、步驟：" +
                        "(1)五花肉切成四指寬，水煮滾放入五花肉，再煮沸，改小火煮40分鐘，切成1公分的厚片，備用。(2)熱鍋放入少許油，爆香蒜頭、" +
                        "辣椒，加入調味料，煮滾後放入五花肉再煮沸，改小火燜煮10分鐘，湯汁備用。 (3)梅乾菜洗淨切碎，加入步驟2少許湯汁拌勻。" +
                        "(4)五花肉排入深碗中淋上湯汁，加入梅乾菜，置蒸籠中蒸1小時即可，食時反扣盤中即可 。",
                "http://cloud.hakka.gov.tw/Details?p=67860",R.drawable.img1));




        MenuArrayAdapter adapter = new MenuArrayAdapter (this, menu);
        ListView lv = (ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);
        //lv.setOnItemClickListener(itemclick);
    }


}
