package com.nano.designpattern.template;

public abstract class CaffeineBeverage {


    // 泡茶和冲咖啡都具有的步骤
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    // 以下两个方法是都有的方法
    void boilWater() {
        System.out.println("烧水");
    }

    void pourInCup() {
        System.out.println("饮料倒入杯中");
    }
}
