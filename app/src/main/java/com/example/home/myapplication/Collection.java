package com.example.home.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
import java.util.Arrays;
import java.util.List;

public class Collection extends AppCompatActivity {
    private FirebaseDatabase mFirebase;
    private DatabaseReference databaseReference;
    Menu menu;
    List<Menu> menus;
    MenuArrayAdapter adapter;
    List<Integer> ids;
    ListView lv;

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

        mFirebase = FirebaseDatabase.getInstance();
        databaseReference = mFirebase.getReference("Colloction");
        menus = new ArrayList<Menu>();
        adapter = new MenuArrayAdapter (this, new ArrayList<Menu>());
        lv = (ListView)findViewById(R.id.list);
        showlsMenu();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu menu = (Menu)parent.getAdapter().getItem(position);
                Intent intent = new Intent();
                intent.setClass(Collection.this,RecipeInfo.class);
                intent.putExtra("INDEX",menu.getId());
                startActivity(intent);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Collection.this);
                Menu menu = (Menu)parent.getAdapter().getItem(position);
                final AlertDialog builderCre = builder.create();

                builder.setMessage("Confirm delete??\n");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        builderCre.dismiss();
                    }
                });
                builder.show();

                return false;
            }
        });

    }

    public void showlsMenu(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ids = getID(dataSnapshot.getValue().toString());
                for(int i : ids){
                    menus.add(FireBaseThread.lsMenu.get(i));
                }
                adapter.clear();
                adapter.addAll(menus);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public List<Integer> getID(String value){
        List<Integer> lsID = new ArrayList<>();
        String str = value.substring(5,value.length()-2);
        List<String> lsStr = Arrays.asList(str.split(","));

        for(String temp : lsStr){
            String[] arrStr = temp.split("=");
            lsID.add(Integer.parseInt(arrStr[1]));
        }

        return lsID;
    }


}
