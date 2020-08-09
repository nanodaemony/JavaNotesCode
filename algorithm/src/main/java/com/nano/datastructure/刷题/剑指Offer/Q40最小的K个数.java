package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: nano
 * @time: 2020/7/2 15:52
 */
public class Q40最小的K个数 {

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {

		if (k > nums.length || k <= 0)
			return new ArrayList<>();

		PriorityQueue<Integer> queue = new PriorityQueue(k, Comparator.reverseOrder());

		for (int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
		}
		ArrayList<Integer> resList = new ArrayList();
		while (k-- >= 0) {
			resList.add((Integer) queue.poll());
		}
		return resList;
	}


	/**
	 * 基于快排思想的最小K个数
	 */
	public int[] getLeastNumbers(int[] nums, int k) {
		// Base case
		if (k > nums.length || k <= 0) return new int[]{};
		// 快速选择
		quickFind(nums, k - 1);
		// findKthSmallest会改变数组，使得前k个数都是最小的k个数
		int[] res = new int[k];
		for (int i = 0; i < k; i++)
			res[i] = nums[i];
		return res;
	}

	public void quickFind(int[] nums, int k) {

		int low = 0, high = nums.length - 1;
		while (low < high) {
			int pivot = partition(nums, low, high);
			// 表示当前pivot就是第K小的且左边的已经小于pivot，此时即可退出
			if (pivot == k) break;
			// 表示第k小的数在pivot的左侧
			if (pivot > k) {
				high = pivot - 1;
				// 表示第k小的数在pivot的右侧
			} else {
				low = pivot + 1;
			}
		}
	}

	// 快排Partition
	private int partition(int[] array, int left, int right) {
		// 挑选一个随机的pivot索引并交换到第一个位置上
		int randomPivot = left + (int) (Math.random() * (right - left + 1));
		swap(array, randomPivot, left);
		// 数组第一个值为pivot值
		int pivotValue = array[left];
		int i = left + 1;
		int j = right;
		while (true) {
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

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
