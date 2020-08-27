package com.nano.datastructure.面试.数学题目;

/**
 * @author: nano
 * @time: 2020/8/21 14:47
 */
public class 最大公约数 {

	public int gcd(int m, int n) {
		return n == 0 ? m : gcd(n, m % n);
	}


}
