package com.fx.responsibility.i_factorymethod;

// 修改代码如下，使用工厂方法

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
interface FoodFactory {
    public Food getFood();
}
class HamburgerFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Hamburger();
    }
}
class RiceFactory implements FoodFactory {
    @Override
    public Food getFood() {
        return new Rice();
    }
}

public class Test {
    public static void main(String[] args) {
        FoodFactory factory = new HamburgerFactory();
        Food f = factory.getFood();
        f.eat();
    }
}
