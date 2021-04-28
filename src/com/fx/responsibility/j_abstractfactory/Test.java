package com.fx.responsibility.j_abstractfactory;

// 抽象工厂设计模式

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
// 抽象产品
interface Drink {
    public void drink();
}
// 具体产品
class Cola implements Drink {
    @Override
    public void drink() {
        System.out.println("喝可乐！");
    }
}
class IcePeak implements Drink {
    @Override
    public void drink() {
        System.out.println("喝冰峰！");
    }
}
// 工厂
interface Factory {
    public Food getFood();
    public Drink getDrink();
}
class KFCFactory implements Factory {
    @Override
    public Food getFood() {
        return new Hamburger();
    }
    @Override
    public Drink getDrink() {
        return new Cola();
    }
}
class DongFactory implements Factory {
    @Override
    public Food getFood() {
        return new Rice();
    }
    @Override
    public Drink getDrink() {
        return new IcePeak();
    }
}

public class Test {
    public static void main(String[] args) {
        Factory factory = new KFCFactory();
        Food f = factory.getFood();
        Drink drink = factory.getDrink();
        f.eat();
        drink.drink();
    }
}
