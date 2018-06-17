package com.example.home.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    ImageButton btn_img ;
    EditText et_input;
    ListView lv;
    MenuArrayAdapter adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent = new Intent();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent.setClass(Search.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_collection:
                    intent.setClass(Search.this,Collection.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_setting:
                    intent.setClass(Search.this,Setting.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    intent.setClass(Search.this,Search.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_question:
                    intent.setClass(Search.this,Question.class);
                    startActivity(intent);
                    return true;
            }            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_search);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        adapter = new MenuArrayAdapter (this, new ArrayList<Menu>());
        lv = (ListView)findViewById(R.id.list);
        lv.setEmptyView(findViewById(R.id.empty));

        btn_img = findViewById(R.id.searchImageButton);
        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input = findViewById(R.id.et_input);
                String str = et_input.getText().toString();

                if(str.equals("")){
                    lv.setEmptyView(findViewById(R.id.empty));
                    adapter.clear();
                    lv.setAdapter(adapter);
                }else{
                    List<Menu> index = searchMenu(str);
                    if(index.size() == 0){
                        lv.setEmptyView(findViewById(R.id.empty));
                        adapter.clear();
                        lv.setAdapter(adapter);
                        //lv.invalidateViews();
                    }else{
                        adapter.clear();
                        adapter.addAll(index);
                        lv.setAdapter(adapter);
                    }
                }

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu menu = (Menu)parent.getAdapter().getItem(position);
                Intent intent = new Intent();
                intent.setClass(Search.this,RecipeInfo.class);
                intent.putExtra("INDEX",menu.getId());
                startActivity(intent);
            }
        });

    }

    public List<Menu> searchMenu(String input){
        List<Menu> menus = FireBaseThread.lsMenu;
        List<Menu> index = new ArrayList<>();
        for(Menu menu:menus){
            if(menu.getDishes_name().contains(input) || menu.getKind().contains(input)
                    || menu.getClassification().contains(input) || menu.getCreative().contains(input)){
                index.add(menu);
            }
        }

        return index;
    }
}
