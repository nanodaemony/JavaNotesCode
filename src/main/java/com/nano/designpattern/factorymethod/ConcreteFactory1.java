package com.nano.designpattern.factorymethod;

public class ConcreteFactory1 extends Factory {
    /**
     * 覆写工厂类的抽象方法
     *
     * @return 返回需要得产品
     */
    @Override
    public Product newProduct() {
        return new ConcreteProduct1();
    }
}
