package com.example.home.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Question extends AppCompatActivity {

    private int imgNo = 0;
    ImageView image;
    TextView tvQ;
    Button btnY;
    Button btnN;
    ArrayList<String> img = null;
    ArrayList<String> q = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent = new Intent();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent.setClass(Question.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_collection:
                    intent.setClass(Question.this,Collection.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_setting:
                    intent.setClass(Question.this,Setting.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    intent.setClass(Question.this,Search.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_question:
                    intent.setClass(Question.this,Question.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_question);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //將題目加入List
        img = new ArrayList<String>();
        q = new ArrayList<String>();

        img.add("snake");
        img.add("sugar");
        img.add("soup");
        img.add("spicy");

        q.add("吃點心嗎?");
        q.add("吃點甜的?");
        q.add("喝點湯嗎?");
        q.add("加點辣嗎?");

        GetFirstImgAndQ();   //顯示圖片

        btnY = findViewById(R.id.btn_y);
        btnN = findViewById(R.id.btn_n);
        btnY.setOnClickListener(ButtonOnClick);
        btnN.setOnClickListener(ButtonOnClick);
    }

    private View.OnClickListener ButtonOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            if(imgNo >= img.size()-1) {
                //imgNo = 0; //超過題目位址,回到初始值
                Intent intent = new Intent();
                intent.setClass(Question.this, Answer.class);
                startActivity(intent);
                finish();
            }
            else{
                imgNo++;
            }
            GetFirstImgAndQ();
        }
    };

    //顯示圖片
    private void GetFirstImgAndQ(){

        image = (ImageView) findViewById(R.id.iv_ques);
        String[] imgArray = new String[imgNo]; //宣告字串陣列大小
        imgArray = img.toArray(imgArray); //將List放到字串陣列裡來
        tvQ = findViewById(R.id.tv_question);
        String[] qArray = new String[imgNo];
        qArray = q.toArray(qArray);

        String uri = "@drawable/" + imgArray[imgNo].toString(); //圖片路徑和名稱
        int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        String qString = qArray[imgNo].toString();

        image.setImageResource(imageResource);
        tvQ.setText(qString);
        tvQ.setTextSize(30);
        tvQ.setTextColor(Color.parseColor("#000000"));
    }
}
