package com.nano.datastructure.刷题.动态规划;

/**
 * @author: nano
 * @time: 2020/7/7 15:37
 */
public class Q70爬跳台阶 {

	public int JumpFloor(int n) {
		if (n <= 2) {
			return n;
		}
		int back = 1, front = 2;
		int result = 1;
		// 滚动计算
		for (int i = 2; i < n; i++) {
			result = back + front;
			back = front;
			front = result;
		}
		return result;
	}

}
