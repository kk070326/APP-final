package com.example.home.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);
        Intent intent = getIntent();
        int index = intent.getIntExtra("INDEX",0);
        Menu menu  = FireBaseThread.lsMenu.get(index);

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

    }
}
