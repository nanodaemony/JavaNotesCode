package com.nano.datastructure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author: nano
 * @time: 2020/7/10 14:05
 */
public class ShellSort {


	public static void shellSort(int[] array) {

		// Base case
		if(array == null || array.length < 2) return;
		// 初始化Gap
		int gap = array.length / 2;

		while (gap > 0) {
			for (int i = gap; i < array.length; i++) {
				int tmp = array[i];
				int j = i - gap;
				while (j >= 0 && array[j] > tmp) {
					array[j + gap] = array[j];
					j -= gap;
				}
				array[j + gap] = tmp;
			}
			gap = gap / 2;
		}
	}


	public static void shellSort2(int[] arr) {
		// 增量gap, 并逐步的缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// 移动
						arr[j] = arr[j - gap];
						j = j - gap;
					}
					// 当退出while后，就给temp找到插入的位置
					arr[j] = temp;
				}
			}
		}
	}


	public static void main(String[] args) {
		int[] array = {3, 5, 2, 9, 10, 7, 4, 6, 8, 1, 1};
		shellSort(array);
		System.out.println(Arrays.toString(array));
	}
}
