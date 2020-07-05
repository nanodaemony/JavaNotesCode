package com.nano.jvm;

/**
 * JVM架构测试类
 *
 * @author: nano
 * @time: 2020/6/19 20:37
 */
public class Math {

	/**
	 * 计算方法
	 * 一个方法对应一个栈帧
	 */
	public int compute() {
		int a = 1;
		int b = 2;
		int c = (a + b) * 10;

		char e = 'a';
		System.out.println((int) e);

		return c;
	}

	public static void main(String[] args) {
		Math math = new Math();
		math.compute();

		String a1 = new String("111");
		String a2 = "111";
		System.out.println(a1 == a2);
	}

}
