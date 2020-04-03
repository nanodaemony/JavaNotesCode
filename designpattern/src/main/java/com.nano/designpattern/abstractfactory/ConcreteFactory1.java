package com.nano.designpattern.abstractfactory;

/**
 * 具体工厂1
 */
public class ConcreteFactory1 extends AbstractFactory{

    /**
     * 实现工厂方法A
     */
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    /**
     * 实现工厂方法B
     */
    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}
