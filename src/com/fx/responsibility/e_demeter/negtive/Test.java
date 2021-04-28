package com.fx.responsibility.e_demeter.negtive;

public class Test {
    public static void main(String[] args) {
        Foo f = new Foo();
        Bar bar = f.get();
        bar.t1();
    }
}
class Bar {
    public String t1(){
        return "";
    }
}
class Foo {
    public Bar get(){
        return new Bar();
    }
}


class Computer {
    public void saveData() {
        System.out.println("保存数据");
    }
    public void killProcess() {
        System.out.println("关闭程序");
    }
    public void close() {
        System.out.println("关掉电源");
    }
    public void shutdown() {
        this.saveData();
        this.killProcess();
        this.close();
    }
}
class Person {
    private Computer c;
    // 修改后，只关注于关机业务，其具体实现不关心，关机的流程修改不会影响到Person
    public void shutdownComputer() {
        c.shutdown();
    }
}
