package com.fx.responsibility.n_template;

import java.util.LinkedList;

abstract class Template {
    public void template() {
        System.out.println("程序执行开始。。。");
        long startTime = System.currentTimeMillis();
        code();
        long endTime = System.currentTimeMillis();
        System.out.println("程序执行用时：" + (endTime - startTime) + "ms");
        System.out.println("程序执行结束。。。");
    }

    protected abstract void code();
}

class TestA extends Template {
    @Override
    protected void code() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(0, i);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Template t = new TestA();
        t.template();
    }
}
