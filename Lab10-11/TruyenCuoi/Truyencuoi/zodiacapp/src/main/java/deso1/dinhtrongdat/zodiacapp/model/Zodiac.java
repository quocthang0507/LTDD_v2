package deso1.dinhtrongdat.zodiacapp.model;

import java.io.Serializable;

public class Zodiac implements Serializable {
    private String title;
    private String descrip;
    private String date;
    private String detail;
    private int img;

    public Zodiac() {
    }

    public Zodiac(String title, String descrip, String date, String detail, int img) {
        this.title = title;
        this.descrip = descrip;
        this.date = date;
        this.detail = detail;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
