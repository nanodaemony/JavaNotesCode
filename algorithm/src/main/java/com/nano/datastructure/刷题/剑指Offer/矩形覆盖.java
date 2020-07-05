package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 14:24
 */
public class 矩形覆盖 {


	public int RectCover(int n) {
		// Base case
		if (n <= 2) {
			return n;
		}
		//
		int back = 1, front = 2;
		int result = 0;
		for (int i = 3; i <= n; i++) {
			result = back + front;
			back = front;
			front = result;
		}
		return result;
	}



}
