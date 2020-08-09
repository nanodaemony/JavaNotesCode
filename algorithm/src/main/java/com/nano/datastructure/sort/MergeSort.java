package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author nano
 */
public class MergeSort {

	/**
	 * 归并排序 对外暴露的接口
	 *
	 * @param array 数组
	 */
	public static void mergeSort(int[] array) {
		// Base case
		if (array == null || array.length < 2) return;
		mergeSort(array, 0, array.length - 1);
	}

	/**
	 * 归并排序 内部排序接口
	 *
	 * @param array 数组
	 */
	private static void mergeSort(int[] array, int left, int right) {
		// 当切分到仅一个元素时返回
		if (left == right) return;
		// 当前数组中值
		int mid = left + ((right - left) / 2);
		// 分别对两边排序
		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);
		// 最后对左右两部分结果进行合并
		merge(array, left, mid, right);
	}

	public static void merge(int[] array, int left, int mid, int right) {
		// 辅助数组
		int[] tmp = new int[array.length];
		// p1、p2是检测指针，k是元素存放指针
		int p1 = left, p2 = mid + 1, k = left;
		// 也就是合并两个有序的数组到一个数组
		while (p1 <= mid && p2 <= right) {
			if (array[p1] <= array[p2]) {
				tmp[k++] = array[p1++];
			} else {
				tmp[k++] = array[p2++];
			}
		}
		// 说明其中一个数组复制完了，直接将后面所有元素加到合并的序列中
		while (p1 <= mid) tmp[k++] = array[p1++];
		while (p2 <= right) tmp[k++] = array[p2++];

		// 复制回原数组
		for (int i = left; i <= right; i++) {
			array[i] = tmp[i];
		}
	}


	public static void main(String[] args) {
		int[] array = {3, 5, 2, 9, 10, 7, 4, 6, 8, 1, 1};
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

}
