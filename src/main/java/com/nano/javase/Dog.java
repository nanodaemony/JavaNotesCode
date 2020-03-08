package com.nano.javase;

import lombok.Setter;

/**
 * 继承测试
 * @author nano
 */
public class Dog extends Animal{


    @Setter
    private String owner;

    public Dog(String name, String age, String owner) {
        super(name, age);
        this.owner = owner;
    }

    // 覆写父类方法
    @Override
    public void eatFood() {
        // 引用父类的方法
        System.out.println("小狗吃东西");
    }


    public void test(String name, String age) {}
    // public void test(String age, String name) {}
    public void test(String age, Integer name) {}
    public void test(Integer age, String name) {}


    public static void main(String[] args) {
        Dog dog = new Dog("Alice", "12", "Tom");
        Animal animal = dog; // animal声明为 Animal类型，也即其静态类型，此处其动态类型为Dog
        animal.eatFood();
    }
}