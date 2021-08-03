package com.dinhtrongdat.menuorder;

public class Food {
    private String foodName;
    private String foddVn;
    private double price;
    private int foodPic;

    public Food(String foodName, String foddVn, double price, int foodPic) {
        this.foodName = foodName;
        this.foddVn = foddVn;
        this.price = price;
        this.foodPic = foodPic;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoddVn() {
        return foddVn;
    }

    public void setFoddVn(String foddVn) {
        this.foddVn = foddVn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(int foodPic) {
        this.foodPic = foodPic;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foddVn='" + foddVn + '\'' +
                ", price=" + price +
                ", foodPic=" + foodPic +
                '}';
    }
}
