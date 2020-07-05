package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 15:11
 */
public class 求1到N的和 {

	public int sumNums(int n) {
		int sum = n;
		boolean flag = (n > 0) && ((sum += sumNums(n - 1)) > 0);
		return sum;
	}

}
