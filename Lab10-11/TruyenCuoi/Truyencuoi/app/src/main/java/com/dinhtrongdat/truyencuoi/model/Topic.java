package com.dinhtrongdat.truyencuoi.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Topic implements Serializable {
    private Bitmap img;
    private String name;

    public Topic() {
    }

    public Topic(Bitmap img, String name) {
        this.img = img;
        this.name = name;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
