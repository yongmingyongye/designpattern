package com.fx.responsibility.g_composite.a;

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
        System.out.println(set.getCount());
    }
}
class MySet extends HashSet {
    private int count = 0;
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }
    /*public boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
    }*/
    public boolean addAll(Collection c) {
        boolean flag = false;
        for(Object o : c) {
            if(add(o)) {
                flag = true;
            }
        }
        return flag;
    }
    public int getCount() {
        return count;
    }
}
