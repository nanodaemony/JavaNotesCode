package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/4 16:03
 */
public class 构建乘积数组 {

	public int[] constructArr(int[] a) {
		// Base case
		if(a.length == 0) return new int[0];

		int[] res = new int[a.length];
		// 初始化
		res[0] = 1;
		int temp = 1;
		// 计算下三角
		for(int i = 1; i < a.length; i++) {
			res[i] = res[i - 1] * a[i - 1];
		}
		// 计算上三角
		for(int i = a.length - 2; i >= 0; i--) {
			temp = temp * a[i + 1];
			res[i] = res[i] * temp;
		}
		return res;
	}


}
