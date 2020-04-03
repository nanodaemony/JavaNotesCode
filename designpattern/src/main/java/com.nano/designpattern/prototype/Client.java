package com.nano.designpattern.prototype;

public class Client {

    public static void main(String[] args) {
        // 构建原型对象
        Prototype prototype = new ConcretePrototype("abc");
        // 使用原型对象进行复制
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}
