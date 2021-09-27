package com.dinhtrongdat.customgridview;

public class Genius {
    private int image;
    private String title;
    private double number;

    public Genius(int image, String title, double number) {
        this.image = image;
        this.title = title;
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
