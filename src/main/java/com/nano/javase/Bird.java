package com.nano.javase;

/**
 * 鸟类
 * @author nano
 */
public class Bird extends Animal implements Fly{

    /**
     * 接口中的一般方法必须实现
     */
    @Override
    public void flyOnRiver() {
        System.out.println("鸟在河上飞");
    }

    /**
     * 接口中的默认方法可以不实现
     */
    @Override
    public void flyOnSky() {
        System.out.println("鸟在天空飞");
    }

    public static void main(String[] args) {
        Fly fly = new Bird();
        fly.flyOnRiver();
        fly.flyOnSky();
    }


}
