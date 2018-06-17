package com.example.home.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeInfo extends AppCompatActivity {

    Button btn_add;
    Menu menu;
    List<Integer> ids;
    Boolean check;
    private FirebaseDatabase mFirebase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);
        Intent intent = getIntent();

        mFirebase = FirebaseDatabase.getInstance();
        databaseReference = mFirebase.getReference("Colloction");

        int index = intent.getIntExtra("INDEX",0);
        menu  = FireBaseThread.lsMenu.get(index);

        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText((String)menu.getDishes_name());

        TextView tv_create = (TextView) findViewById(R.id.tv_create);
        tv_create.setText((String)menu.getCreative());

        TextView tv_kind = (TextView) findViewById(R.id.tv_kind);
        tv_kind.setText((String)menu.getKind());

        TextView tv_class = (TextView) findViewById(R.id.tv_class);
        tv_class.setText((String)menu.getClassification());

        TextView tv_specialty = (TextView) findViewById(R.id.tv_specialty);
        tv_specialty.setText((String)menu.getSpecialty_dishes());

        TextView tv_practic = (TextView) findViewById(R.id.tv_practic);
        tv_practic.setText((String)menu.getPractic());

        ImageView iv_img = (ImageView) findViewById(R.id.imageView);
        iv_img.setImageBitmap((Bitmap)menu.getImgid());

        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = menu.getId();
                checkExist(id);
                check = false;
                Log.v("Check","123 " + check);

            }
        });
    }


    public void checkExist(final int id){
        check = false;
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ids = getID(dataSnapshot.getValue().toString());
                for(int menuId : ids){
                    if(menuId == id){
                        check = true;
                    }
                }

                if(!check){
                    DatabaseReference newdataref = databaseReference.child("ID").push();
                    newdataref.setValue(id);
                    Toast.makeText(RecipeInfo.this, "Done add!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RecipeInfo.this, "Already exist!!", Toast.LENGTH_SHORT).show();
                }

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
