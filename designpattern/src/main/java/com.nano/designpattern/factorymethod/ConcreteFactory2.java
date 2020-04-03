package com.nano.designpattern.factorymethod;

public class ConcreteFactory2 extends Factory {
    @Override
    public Product newProduct() {
        return new ConcreteProduct2();
    }
}
