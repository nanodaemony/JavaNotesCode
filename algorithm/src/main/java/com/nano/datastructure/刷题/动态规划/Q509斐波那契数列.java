package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/8/9 15:37
 */
public class Q509斐波那契数列 {

	public int Fibonacci(int num) {
		// Base case
		if (num <= 1) return num;
		int[] res = new int[num + 1];
		// 初始化
		res[1] = 1;
		// 自底向上计算即可
		for (int i = 2; i <= num; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[num];
	}


	public int Fibonacci2(int n) {
		if (n <= 1) return n;
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
}
