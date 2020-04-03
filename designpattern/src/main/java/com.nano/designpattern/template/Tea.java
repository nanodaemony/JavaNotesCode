package com.nano.designpattern.template;

public class Tea extends CaffeineBeverage {
    // 覆写第三个特殊的方法
    @Override
    void brew() {
        System.out.println("煮茶");
    }

    // 覆写第三个特殊的方法
    @Override
    void addCondiments() {
        System.out.println("茶中加入调味料");
    }
}