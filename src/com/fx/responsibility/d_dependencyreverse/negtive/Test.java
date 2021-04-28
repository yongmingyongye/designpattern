package com.fx.responsibility.d_dependencyreverse.negtive;

class Person {
    public void feed(Animal animal) {
        System.out.println("开始喂。。。");
        animal.eat();
    }
}

interface Animal {
    void eat();
}

class Dog implements Animal {
    public void eat() {
        System.out.println("狗开始吃。。。");
    }
}

class Cat implements Animal {
    public void eat() {
        System.out.println("猫开始吃。。。");
    }
}

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        Dog d = new Dog();
        p.feed(d);
        Cat c = new Cat();
        p.feed(c);
    }
}
