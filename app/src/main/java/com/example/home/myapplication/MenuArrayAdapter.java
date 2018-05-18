package com.example.home.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuArrayAdapter extends ArrayAdapter<Menu> {
    Context context;

    public MenuArrayAdapter(Context context,
                             ArrayList<Menu> items) {
        super(context, 0, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout itemlayout = null;
        if(convertView == null) {
            itemlayout = (LinearLayout)inflater.inflate(R.layout.introduction, null);
        } else {
            itemlayout = (LinearLayout) convertView;
        }

        Menu item = (Menu)getItem(position);

        TextView tv_name = (TextView)itemlayout.findViewById(R.id.dishes_name);
        tv_name.setText(item.getDishes_name());
        TextView tv_kind = (TextView)itemlayout.findViewById(R.id.dishes_kind);
        tv_kind.setText(item.getKind());
        TextView tv_classification = (TextView)itemlayout.findViewById(R.id.dishes_classification);
        tv_classification.setText(item.getClassification());
        TextView tv_creative = (TextView)itemlayout.findViewById(R.id.dishes_creative);
        tv_creative.setText(item.getCreative());
        TextView tv_specialty = (TextView)itemlayout.findViewById(R.id.dishes_specialty);
        tv_specialty.setText(item.getSpecialty_dishes());
        ImageView iv = (ImageView)itemlayout.findViewById(R.id.img_dishes);
        iv.setImageResource(item.getImgid());
        return itemlayout;
    }
}
