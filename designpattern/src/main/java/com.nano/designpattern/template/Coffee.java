package com.nano.designpattern.template;

public class Coffee extends CaffeineBeverage {
    // 覆写第二个特殊的方法
    @Override
    void brew() {
        System.out.println("煮咖啡");
    }

    @Override
    void addCondiments() {
        System.out.println("添加咖啡调味料");
    }
}
