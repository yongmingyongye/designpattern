package com.fx.responsibility.o_adapter;

class Calc {
    public int add(int a, int b) {
        return a + b;
    }
}
// 适配器
class CalcAdapter {
    private Calc calc;
    public CalcAdapter(Calc c) {
        calc = c;
    }
    public int add(int a, int b, int c) {
        return calc.add(calc.add(a, b), c);
    }
}
public class Test {
    public static void main(String[] args) {
        Calc c = new Calc();
        CalcAdapter calcAdapter = new CalcAdapter(c);
        calcAdapter.add(1, 2, 3);
    }
}
