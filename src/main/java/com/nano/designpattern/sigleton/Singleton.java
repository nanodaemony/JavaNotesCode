package com.nano.designpattern.sigleton;

/**
 * 单例模式
 * @author nano
 */
public class Singleton {

    // 私有静态变量 唯一实例
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    /**
     * 懒汉式1
     */
    public static Singleton getUniqueInstance1() {
        // 这里在多线程下不安全，如果多个判断为null就初始化多个实例
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 饿汉式 自己直接实例化
     */
    private static Singleton uniqueInstance2 = new Singleton();


    /**
     * 懒汉式
     *
     * 对整个方法加锁
     */
    public static synchronized Singleton getUniqueInstance3() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }


    private volatile static Singleton uniqueInstance4;

    /**
     * 双重校验锁
     * @return 单例对象
     */
    public static Singleton getUniqueInstance4() {
        if (uniqueInstance4 == null) {
            // 仅仅在初始化的时候才加锁
            synchronized (Singleton.class) {
                // 再加一层判断 防止在第一次判断之后发生已经初始化的情况
                if (uniqueInstance4 == null) {
                    uniqueInstance4 = new Singleton();
                }
            }
        }
        return uniqueInstance4;
    }


    // 使用静态内部类 可延迟加载
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance5() {
        return SingletonHolder.INSTANCE;
    }

}
