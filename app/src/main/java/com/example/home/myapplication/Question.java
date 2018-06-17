package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Question extends AppCompatActivity {
    TextView tv_name ;
    TextView tv_spec;
    ImageView img;
    Button btn_chg;
    Button btn_view;
    Menu menu;

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
        tv_name = (TextView) findViewById(R.id.tv_cname);
        tv_spec = (TextView) findViewById(R.id.tv_cspec);
        img = (ImageView) findViewById(R.id.iv_repice);

        rdmMenu();
        tv_name.setText(menu.getDishes_name());
        tv_spec.setText(menu.getSpecialty_dishes());
        img.setImageBitmap(menu.getImgid());

        btn_chg = (Button) findViewById(R.id.btn_rnd);
        btn_view = (Button) findViewById(R.id.btn_view);

        btn_chg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdmMenu();
                tv_name.setText(menu.getDishes_name());
                tv_spec.setText(menu.getSpecialty_dishes());
                img.setImageBitmap(menu.getImgid());
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Question.this,RecipeInfo.class);
                intent.putExtra("INDEX",menu.getId());
                startActivity(intent);

            }
        });


    }

    public void rdmMenu(){
        Random rd = new Random();
        int num = rd.nextInt(FireBaseThread.lsMenu.size());

        menu = FireBaseThread.lsMenu.get(num);
    }


}
