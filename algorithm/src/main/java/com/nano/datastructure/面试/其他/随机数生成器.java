package com.nano.datastructure.面试.其他;

/**
 * @author: nano
 * @time: 2020/8/13 22:43
 */
public class 随机数生成器 {

	// 1-5的随机数生成器
	public static int rand1To5() {
		return (int) (Math.random() * 5) + 1;
	}

	public static int rand1To7() {
		int num = 0;
		while (true) {
			num = (rand1To5() - 1) * 5 + rand1To5() - 1;
			if (num <= 20) break;
		}
		return num % 7 + 1;
	}


}
