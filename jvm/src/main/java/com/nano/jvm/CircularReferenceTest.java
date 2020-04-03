package com.nano.jvm;

/**
 * 循环引用
 * @author nano
 */
public class CircularReferenceTest {

    private Object instance = null;

    public static void main(String[] args) {
        CircularReferenceTest a = new CircularReferenceTest();
        CircularReferenceTest b = new CircularReferenceTest();
        // 循环引用
        a.instance = b;
        b.instance = a;
        // 同时置空
        a = null;
        b = null;
        // doSomething();
    }
}
