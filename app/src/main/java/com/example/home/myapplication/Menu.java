package com.example.home.myapplication;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Menu implements Serializable{
    private String kind;
    private String classification;
    private String dishes_name;
    private String creative;
    private String specialty_dishes;
    private String practic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Bitmap imgid;
    private int id;
    public Bitmap getImgid() {
        return imgid;
    }

    public void setImgid(Bitmap imgid) {
        this.imgid = imgid;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDishes_name() {
        return dishes_name;
    }

    public void setDishes_name(String dishes_name) {
        this.dishes_name = dishes_name;
    }


    public String getCreative() {
        return creative;
    }

    public void setCreative(String creative) {
        this.creative = creative;
    }

    public String getSpecialty_dishes() {
        return specialty_dishes;
    }

    public void setSpecialty_dishes(String specialty_dishes) {
        this.specialty_dishes = specialty_dishes;
    }

    public String getPractic() {
        return practic;
    }

    public void setPractic(String practic) {
        this.practic = practic;
    }

}
