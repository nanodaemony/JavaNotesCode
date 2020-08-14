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


	public static int rand7() {
		while (true) {
			// 0-24,超过21的不要,重新计算
			int num = 5 * rand5() + rand5();
			if (num < 21) {
				return num % 7;
			}
		}
	}

	public static int rand5() {
		return (int) (Math.random() * 5);
	}


	public static int rand10() {
		while (true) {
			// 注意rand7是随机调用了两次
			int num = 7 * rand7() + rand7();
			// 排除41-48，因为他们不能生成9，会造成各个数字出现的概率不同
			if (num < 41) {
				return num % 10;
			}
		}
	}

}
