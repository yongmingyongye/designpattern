package com.fx.responsibility.b_openclose.negtive;

public class Test {

    public static void main(String[] args) {
        Car c = new Car();
        c.setBrand("宝马");
        c.setColor("白色");
        c.setLouyou(true);
        c.setPrice(600000.0);
        // 实现打折，非开闭原则在Car源代码修改
        System.out.println(c.getPrice());

    }

}
