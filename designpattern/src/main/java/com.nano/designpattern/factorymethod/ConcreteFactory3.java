package com.nano.designpattern.factorymethod;

public class ConcreteFactory3 extends Factory{
    @Override
    public Product newProduct() {
        return new ConcreteProduct3();
    }
}
