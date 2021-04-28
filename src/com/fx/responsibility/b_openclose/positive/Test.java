package com.fx.responsibility.b_openclose.positive;

public class Test {

    public static void main(String[] args) {
        // 通过实现继承的子类，实现打折，满足开闭原则
        Car c = new DiscountCar();
        c.setBrand("宝马");
        c.setColor("白色");
        c.setLouyou(true);
        c.setPrice(600000.0);
        System.out.println(c.getPrice());

    }

}
