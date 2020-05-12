package com.nano.datastructure;

public class A {

    static int func(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int x = 30, y = 10, z = 20, r;
        r = func(x, y) < func(y, z) ? x:y;
        System.out.println(r);
    }

}