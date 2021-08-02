package com.dinhtrongdat.lab2bai4;

public class Planet {
    private String planetName;
    private String detail;
    private int pic;

    public Planet(String planetName, String detail, int pic) {
        this.planetName = planetName;
        this.detail = detail;
        this.pic = pic;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "planetName='" + planetName + '\'' +
                ", detail='" + detail + '\'' +
                ", pic=" + pic +
                '}';
    }
}
