package com.nano.designpattern.abstractfactory;

public class Client {


    public static void main(String[] args) {
        // 得到具体工厂1
        AbstractFactory abstractFactory = new ConcreteFactory1();
        // 得到工厂1产生的产品A
        AbstractProductA productA = abstractFactory.createProductA();
        // 得到工厂1产生的产品B
        AbstractProductB productB = abstractFactory.createProductB();
        // do something with productA and productB
    }

}
