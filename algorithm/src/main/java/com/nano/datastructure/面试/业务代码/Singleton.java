package com.nano.datastructure.面试.业务代码;

/**
 * @author: nano
 * @time: 2020/8/12 19:18
 */
public class Singleton {


	/**
	 * 私有静态变量:唯一实例
	 */
	private static Singleton uniqueInstance;

	/**
	 * 定义一个私有内部方法防止外部构造对象
	 */
	private Singleton() {}


	/**
	 * 饿汉式:一来直接实例化
	 */
	private static Singleton uniqueInstance1 = new Singleton();


	/**
	 * 懒汉式:对整个方法加锁
	 */
	public static synchronized Singleton getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}


	public static Singleton getUniqueInstance1() {

		if(uniqueInstance == null) {
			synchronized (Singleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}


	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance3() {
		return SingletonHolder.INSTANCE;
	}

}
