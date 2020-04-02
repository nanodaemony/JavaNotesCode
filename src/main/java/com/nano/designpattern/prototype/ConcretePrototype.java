package com.nano.designpattern.prototype;

/**
 * 原型抽象类实现类
 * @author nano
 */
public class ConcretePrototype extends Prototype{

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}
