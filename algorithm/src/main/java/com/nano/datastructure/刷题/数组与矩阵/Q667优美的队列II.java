package com.nano.datastructure.刷题.数组与矩阵;

/**
 * @author: nano
 * @time: 2020/7/7 15:16
 */
public class Q667优美的队列II {

	public int[] constructArray(int n, int k) {
		int[] array = new int[n];
		int left = 1, right = n;

		// 前k个数需要间隔从两端取；
		int i = 0;
		while (true) {
			if(i < k) { array[i] = left; i++; left++; } else break;
			if(i < k) { array[i] = right; i++; right--; } else break;
		}

		// 剩下的数字则按照降序或者升序排列；
		if(k % 2 == 1) {
			for (int j = k; j < array.length; j++) {
				array[j] = left;
				left++;
			}
		} else {
			for (int j = k; j < array.length; j++) {
				array[j] = right;
				right--;
			}
		}
		return array;
	}

}
