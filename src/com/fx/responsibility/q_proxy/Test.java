package com.fx.responsibility.q_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

interface ICalc {
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
}
class CalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {
        System.out.println("+");
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("-");
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("*");
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("/");
        return a / b;
    }
}

class MyHandler implements InvocationHandler {

    private Object target;
    public MyHandler(Object target) {
        this.target = target;
    }

    /**
     * 动态代理执行的方法
     * @param proxy 动态代理的对象
     * @param method 调用的接口方法
     * @param args 调用的接口方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " 开始，参数是" + Arrays.toString(args));
        Object result = method.invoke(target, args);
        System.out.println(method.getName() + " 结束，结果是" + result);

        return 0;
    }
}
public class Test {
    public static void main(String[] args) {
        ClassLoader cl = Test.class.getClassLoader();
        ICalc proxy = (ICalc) Proxy.newProxyInstance(cl, new Class[]{ICalc.class}, new MyHandler(new CalcImpl()));
        proxy.add(1, 2);
    }
}
