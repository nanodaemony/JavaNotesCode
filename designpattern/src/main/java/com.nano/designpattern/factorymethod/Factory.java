package com.nano.designpattern.factorymethod;

public abstract class Factory {

    // 工厂方法 产生Product对象
    abstract public Product newProduct();

    public void doSomething() {
        // 使用小工厂自己的对象产生方法
        Product product = newProduct();
        // do something with the product
    }
}
