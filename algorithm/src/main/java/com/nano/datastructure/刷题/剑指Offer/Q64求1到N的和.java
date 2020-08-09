package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 15:11
 */
public class Q64求1到N的和 {

	public int sumNums(int n) {
		int sum = n;
		// 后面的sum是一定大于0，总是为true，直到n=0不满足条件开始返回
		boolean flag = (n > 0) && ((sum = sum + sumNums(n - 1)) > 0);
		return sum;
	}



}
