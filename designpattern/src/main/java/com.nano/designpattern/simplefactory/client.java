package com.nano.designpattern.simplefactory;

public class client {

    public static void main(String[] args) {
        // 构造简单工厂
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);	// 往工厂传入类型
        // do something with the product
    }


    /**
     * 不好的实现
     */
//    public static void main(String[] args) {
//
//        int type = 1;
//        // 自己定义产生Product对象
//        Product product;
//        if (type == 1) {
//            product = new ConcreteProduct1();
//        } else if (type == 2) {
//            product = new ConcreteProduct2();
//        } else {
//            product = new ConcreteProduct1();
//        }
//        // do something with the product
//    }

}
