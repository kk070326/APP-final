package com.example.home.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    MenuArrayAdapter adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent = new Intent();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent.setClass(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_collection:
                    intent.setClass(MainActivity.this,Collection.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_setting:
                    intent.setClass(MainActivity.this,Setting.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    intent.setClass(MainActivity.this,Search.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_question:
                    intent.setClass(MainActivity.this,Question.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        adapter = new MenuArrayAdapter (this, new ArrayList<Menu>());
        ListView lvMenu = (ListView)findViewById(R.id.list);
        lvMenu.setAdapter(adapter);
        getMenuFromFirebase();

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu menu = (Menu)parent.getAdapter().getItem(position);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,RecipeInfo.class);
                intent.putExtra("INDEX",menu.getId());
                startActivity(intent);
            }
        });
    }


    public void getMenuFromFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Table");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new FireBaseThread(dataSnapshot,adapter).start();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
