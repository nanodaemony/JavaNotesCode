package com.nano.jvm;

/**
 * 类加载器测试
 * @author nano
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("Current ClassLoader is: " + ClassLoaderTest.class.getClassLoader());
        System.out.println("The Parent ClassLoader is: " + ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println("The GrandParent ClassLoader is: " + ClassLoaderTest.class.getClassLoader().getParent().getParent());
    }
}
