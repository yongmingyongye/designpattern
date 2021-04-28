package com.fx.responsibility.b_openclose.positive;

public class DiscountCar extends Car {
    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }
}
