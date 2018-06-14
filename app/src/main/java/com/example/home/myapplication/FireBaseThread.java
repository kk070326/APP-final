package com.example.home.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import com.google.firebase.database.DataSnapshot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FireBaseThread extends Thread{
    private DataSnapshot dataSnapshot;
    private MenuArrayAdapter adapter = null;
    private static final int LIST_MENU = 1;
    List<Menu> lsMenu;

    public FireBaseThread(DataSnapshot dataSnapshot, MenuArrayAdapter adapter){
        this.dataSnapshot = dataSnapshot;
        this.adapter = adapter;
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LIST_MENU: {
                    List<Menu> hotels = (List<Menu>)msg.obj;
                    refreshHotelList(hotels);
                    break;
                }
            }
        }
    };

    private void refreshHotelList(List<Menu> menus) {
        adapter.clear();
        adapter.addAll(menus);
    }

    @Override
    public void run (){
        lsMenu = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            DataSnapshot ds_name = ds.child("dishes_name");
            DataSnapshot ds_classification = ds.child("classification");
            DataSnapshot ds_creative = ds.child("creative");
            DataSnapshot ds_kind = ds.child("kind");
            DataSnapshot ds_practic = ds.child("practic");
            DataSnapshot ds_specialty = ds.child("specialty_dishes");
            DataSnapshot ds_url = ds.child("url");

            Menu menu = new Menu();
            menu.setClassification((String)ds_classification.getValue());
            menu.setCreative((String)ds_creative.getValue());
            menu.setDishes_name((String)ds_name.getValue());
            menu.setKind((String)ds_kind.getValue());
            menu.setPractic((String)ds_practic.getValue());
            menu.setSpecialty_dishes((String)ds_specialty.getValue());

            menu.setImgid(getImgBitmap((String)ds_url.getValue()));
            lsMenu.add(menu);
        }


        Message msg = new Message();
        msg.what = LIST_MENU;
        msg.obj = lsMenu;
        handler.sendMessage(msg);
    }

    private Bitmap getImgBitmap(String imgUrl){
        try {
            URL url = new URL(imgUrl);
            Bitmap bm = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bm;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
