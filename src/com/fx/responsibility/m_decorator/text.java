package com.fx.responsibility.m_decorator;

/**
 * 业务场景：卖咖啡（四种咖啡）
 * Decaf Espresso DrakRoast HouseBlend
 * 因为所有咖啡都有共性，因为把共性提到一个父类：Beverage
 */

abstract class Beverage {
    private String description;
    public Beverage(String description) {
        this.description = description;
    }
    public abstract double cost();
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        super("无咖啡因咖啡");
    }
    @Override
    public double cost() {
        return 1;
    }
}
class Espresso extends Beverage {
    public Espresso() {
        super("浓缩咖啡");
    }
    @Override
    public double cost() {
        return 2;
    }
}
class DrakRoast extends Beverage {
    public DrakRoast() {
        super("焦炒咖啡");
    }
    @Override
    public double cost() {
        return 1.5;
    }
}
class HouseBlend extends Beverage {
    public HouseBlend() {
        super("混合咖啡");
    }
    @Override
    public double cost() {
        return 3;
    }
}
abstract class Condiment extends Beverage {
    protected Beverage beverage;
    public Condiment(Beverage beverage) {
        super("调料");
        this.beverage = beverage;
    }
}
class Milk extends Condiment {
    public Milk(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }
    @Override
    public String getDescription() {
        String msg = beverage.getDescription() + " 牛奶";
        return msg;
    }
}
class Soy extends Condiment {
    public Soy(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double cost() {
        return beverage.cost() + 0.1;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + " 豆浆";
    }
}

public class text {
    public static void main(String[] args) {
        Beverage d = new Decaf();
        Condiment c = new Milk(d);
        Condiment c1 = new Soy(c);
        System.out.println(c1.getDescription() + "：" + c1.cost());
    }
}
