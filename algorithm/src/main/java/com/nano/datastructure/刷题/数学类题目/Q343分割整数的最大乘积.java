package com.nano.datastructure.刷题.数学类题目;

/**
 * @author: nano
 * @time: 2020/8/10 15:03
 */
public class Q343分割整数的最大乘积 {

	public int integerBreak(int n) {
		if (n <= 3) return n - 1;
		int quotient = n / 3;
		int remain = n % 3;
		if (remain == 0) {
			return (int) Math.pow(3, quotient);
		} else if (remain == 1) {
			return (int) Math.pow(3, quotient - 1) * 4;
		} else {
			return (int) Math.pow(3, quotient) * 2;
		}
	}

}
