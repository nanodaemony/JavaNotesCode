package com.nano.datastructure.search;

/**
 * 插值查找
 *
 * @author: nano
 * @time: 2020/7/10 16:28
 */
public class InsertValueSearch {

	public static void main(String[] args) {

		// 此处产生1-100的数组 使得关键字分布比较均匀
		int [] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		// 插指查找查找99
		System.out.println("插指查找开始");
		int index = insertValueSearch(arr, 0, arr.length - 1, 99);
		System.out.println("index = " + index);

		System.out.println("二分查找开始");
		int index2 = binarySearch(arr, 0, arr.length, 99);
		System.out.println("index2 = " + index2);
	}

	/**
	 * 二分查找算法
	 * @param array 数组
	 * @param left 左边的索引
	 * @param right 右边的索引
	 * @param target 要查找的值
	 * @return 如果找到就返回下标，如果没有找到就返回 -1
	 */
	public static int binarySearch(int[] array, int left, int right, int target) {
		System.out.println("二分查找被调用1次");

		// 当 left > right 时，说明已经递归整个数组，但是没有找到，必须要此处，不然会无限递归下去
		if (left > right) {
			return -1;
		}
		// 找中间值
		int midIndex = (left + right) / 2;
		int midValue = array[midIndex];

		// 向右递归
		if (target > midValue) {
			return binarySearch(array, midIndex + 1, right, target);
			// 向左递归
		} else if (target < midValue) {
			return binarySearch(array, left, midIndex - 1, target);
		} else {
			// 等于时直接返回
			return midIndex;
		}
	}

	/**
	 * 插指查找算法
	 *
	 * 插值查找算法也要求数组是有序的
	 * @param array 数组
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param target 查找值
	 * @return 如果找到，就返回对应的下标，如果没有找到返回-1
	 */
	public static int insertValueSearch(int[] array, int left, int right, int target) {

		System.out.println("插值查找被调用1次");

		// 后面两个条件必须要，否则我们得到的 mid 可能越界（比如findValue值特别巨大，而findValue参与到了mid值的计算中）
		// 同时如果待查找的值比最小值小或比最大值还大，直接返回-1
		if (left > right || target < array[0] || target > array[array.length - 1]) {
			return -1;
		}

		// 使用自适应公式计算 mid 索引值
		int mid = left + (right - left) * (target - array[left]) / (array[right] - array[left]);
		int midValue = array[mid];
		if (target > midValue) {
			// 说明应该向右边递归
			return insertValueSearch(array, mid + 1, right, target);
		} else if (target < midValue) {
			// 说明向左递归查找
			return insertValueSearch(array, left, mid - 1, target);
		} else {
			// 找到就返回
			return mid;
		}
	}
}
