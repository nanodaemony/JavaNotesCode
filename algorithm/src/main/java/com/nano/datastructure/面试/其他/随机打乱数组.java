package com.nano.datastructure.面试.其他;

import java.util.Random;

/**
 * @author: nano
 * @time: 2020/8/21 18:37
 */
public class 随机打乱数组 {

	private static Random random = new Random();

	public static void shuffle(int[] nums) {
		int len = nums.length;
		// 从后往前选择一个随机数并与后面的交换
		for (int i = len; i > 0; i--) {
			int randInd = random.nextInt(i);
			swap(nums, randInd, i - 1);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
