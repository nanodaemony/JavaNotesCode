package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/30 13:26
 */
public class Q10_2跳台阶 {

	public int numWays(int n) {
		int a = 1, b = 1, sum;
		for(int i = 0; i < n; i++){
			sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return a;
	}

}
