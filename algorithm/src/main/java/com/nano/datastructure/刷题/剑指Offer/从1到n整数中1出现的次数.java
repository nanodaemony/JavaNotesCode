package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/2 17:21
 */
public class 从1到n整数中1出现的次数 {

	public int NumberOf1Between1AndN_Solution(int n) {
		int cnt = 0;
		for (int i = 1; i <= n; i *= 10) {
			int a = n / i, b = n % i;
			cnt += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
		}
		return cnt;
	}

}
