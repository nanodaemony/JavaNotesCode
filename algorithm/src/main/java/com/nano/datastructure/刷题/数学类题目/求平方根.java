package com.nano.datastructure.刷题.数学类题目;

/**
 * @author: nano
 * @time: 2020/8/13 21:48
 */
public class 求平方根 {

	public int mySqrt(int x) {
		// 注意：针对特殊测试用例，例如 2147395599
		// 要把搜索的范围设置成长整型
		// 为了照顾到 0 把左边界设置为 0
		long left = 0;
		// # 为了照顾到 1 把右边界设置为 x // 2 + 1
		long right = x / 2 + 1;
		while (left < right) {
			// 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
			long mid = left + (right - left + 1) / 2;
			long square = mid * mid;
			if (square > x) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		// 因为一定存在，因此无需后处理
		return (int) left;
	}

	public static double square(int num) {
		double x1 = 1, x2;
		// 牛顿迭代公式
		x2 = x1 / 2.0 + num / (2 * x1);
		while (Math.abs(x2 - x1) > 0.0001) {
			x1 = x2;
			x2 = x1 / 2.0 + num / (2 * x1);
		}
		return x2;
	}
}
