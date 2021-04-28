package com.fx.responsibility.h_simplefactory.a;

// 抽象产品
interface Food {
    void eat();
}
// 具体产品
class Hamburger implements Food {
    @Override
    public void eat() {
        System.out.println("吃汉堡！");
    }
}
public class Test {
    public static void main(String[] args) {
        Food f = new Hamburger();
        f.eat();
    }
}
