package com.example.home.myapplication;

public class Menu {
    private String kind;
    private String classification;
    private String dishes_name;
    private String creative;
    private String specialty_dishes;
    private String practic;
    private String url;
    private int imgid;

    public Menu(String kind, String classification, String dishes_name,
                String creative, String specialty_dishes, String practic,
                String url, int imgid){

        this.kind = kind;
        this.classification = classification;
        this.dishes_name = dishes_name;
        this.creative = creative;
        this.specialty_dishes = specialty_dishes;
        this.practic = practic;
        this.url = url;
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

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
