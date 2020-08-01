package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/30 13:17
 */
public class Q10_1裴波那契数列 {


	public int fib(int n) {
		if (n <= 1) {
			return n;
		}
		// 两个指针，一个前一个后
		int back = 0, front = 1;
		// 存放最终结果
		int res = 0;
		for (int i = 2; i <= n; i++) {
			res = back + front;
			back = front;
			front = res;
		}
		return res;
	}

	public int fib2(int n) {
		int a = 0, b = 1, sum;
		for(int i = 0; i < n; i++){
			sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return a;
	}

}
