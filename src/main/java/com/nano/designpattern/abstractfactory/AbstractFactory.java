package com.nano.designpattern.abstractfactory;

// 组合成抽象工厂
public abstract class AbstractFactory {
    /**
     * 获取产品系列的抽象方法
     */
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}
