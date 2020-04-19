package com.example.tuan7.models;

public class ItemModel {
    String title;
    int imageRes;
    boolean isleft;

    public ItemModel(String title, int imageRes) {
        this.title = title;
        this.imageRes = imageRes;
        this.isleft = true;
    }

    public ItemModel(String title, int imageRes, boolean isleft) {
        this.title = title;
        this.imageRes = imageRes;
        this.isleft = isleft;

    }
    public boolean isLeft(){
        return this.isleft;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
