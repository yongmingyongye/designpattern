package com.fx.responsibility.p_strategy;

// 飞动作的接口
interface FlyBehavior {
    void fly();
}
interface QuackBehavior{
    void quack();
}
// 实现类
class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞");
    }
}
class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
class FlyWithKick implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("踢飞");
    }
}
class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}
// 鸭子抽象类
abstract class Duck {
    protected FlyBehavior fb;
    protected QuackBehavior qb;
    public FlyBehavior getFb() {
        return fb;
    }
    public void setFb(FlyBehavior fb) {
        this.fb = fb;
    }
    public QuackBehavior getQb() {
        return qb;
    }
    public void setQb(QuackBehavior qb) {
        this.qb = qb;
    }
    public void swim() {
        System.out.println("游泳");
    }
    public void performFly() {
        fb.fly();
    }
    public void performQuack() {
        qb.quack();
    }
    public abstract void display();
}
// 绿头鸭会叫并会飞
class MallardDuck extends Duck {
    public MallardDuck() {
        this.fb = new FlyNoWay();
        this.qb = new Quack();
    }
    @Override
    public void display() {
        System.out.println("绿头鸭子");
    }
}
// 橡皮鸭被捏才会叫且不会飞
class RubberDuck extends Duck {
    public RubberDuck() {
        this.fb = new FlyWithWings();
        this.qb = new Quack();
    }
    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}
public class Test {
    public static void main(String[] args) {
        RubberDuck rd = new RubberDuck();
        rd.performQuack();
        rd.swim();
        rd.display();
        rd.performFly();
        // 运行时修改飞行动作
        rd.setFb(new FlyWithKick());
        rd.performFly();
    }
}
