package com.fx.responsibility.g_composite.e;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        MySet set = new MySet();
        Set set2 = new HashSet();
        set2.add("测试");
        set2.add("集合");
        set2.add("添加");
        set.addAll(set2);
        set.add("123");
        System.out.println(set.getCount());
    }
}

class MySet {
    private int count = 0;
    private Set set = new HashSet();
    public boolean add(Object o) {
        count++;
        return set.add(o);
    }
    public boolean addAll(Collection c) {
        count += c.size();
        return set.addAll(c);
    }
    public int getCount() {
        return count;
    }
}
