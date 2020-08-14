package com.nano.datastructure.面试.其他;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/14 12:36
 */
public class 快排 {


	public static void quickSort(int[] array) {
		if (array == null || array.length < 2) return;
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		// 这里是if,不是while,因为这个循环里面根本没有更新left与right
		if (left < right) {
			int pivot = partition(array, left, right);
			// 这里pivot已经计算过了，所以取pivot的两边
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		// Base case
		if(left == right) return left;
		// 挑选一个随机的pivot索引并交换到第一个位置上
		int randomPivot = left + (int) (Math.random() * (right - left + 1));
		swap(array, randomPivot, left);
		// 数组第一个值为pivot值
		int pivotValue = array[left];
		// 从第二个位置处开始
		int i = left + 1;
		int j = right;
		while (true) {
			// 找到第一个可以交换的双指针
			while (i <= j && array[i] <= pivotValue) i++;
			while (i <= j && array[j] >= pivotValue) j--;
			// 数组越界退出
			if(i >= j) break;
			// 交换两个值
			swap(array, i, j);
		}
		// 交换第一个pivot元素和j位置
		swap(array, left, j);
		return j;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {

		int[] nums = new int[]{2, 4, 7, 2, 4, 2, 89, 3, 3};
		quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
