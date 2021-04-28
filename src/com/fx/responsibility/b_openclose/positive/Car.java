package com.fx.responsibility.b_openclose.positive;

public class Car {

    private String brand;
    private String color;
    private Double price;
    private Boolean louyou;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getLouyou() {
        return louyou;
    }

    public void setLouyou(Boolean louyou) {
        this.louyou = louyou;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", louyou=" + louyou +
                '}';
    }
}
