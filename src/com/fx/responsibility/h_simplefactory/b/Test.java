package com.fx.responsibility.h_simplefactory.b;

// 修改代码如下，使用简单工厂

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
class Rice implements Food {
    @Override
    public void eat() {
        System.out.println("吃面！");
    }
}
class FoodFactory {
    public static Food getFood(int n) {
        Food food = null;
        switch (n) {
            case 1:
                food = new Hamburger();
                break;
            case 2:
                food = new Rice();
                break;
        }
        return food;
    }
}
public class Test {
    public static void main(String[] args) {
        Food f = FoodFactory.getFood(1);
        f.eat();
    }
}
