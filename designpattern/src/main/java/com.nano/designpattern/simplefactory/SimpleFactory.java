package com.nano.designpattern.simplefactory;

/**
 * 简单工厂类
 * @author nano
 */
public class SimpleFactory {

    /**
     * 根据类型获取对象 统一使用其接口来表示
     *
     * @param type 类型
     * @return 产品对象
     */
    public Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct1();
        } else if (type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct1();
    }
}
