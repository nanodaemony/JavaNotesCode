package com.nano.datastructure.刷题.剑指Offer;

import com.nano.datastructure.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: nano
 * @time: 2020/7/2 15:52
 */
public class 最小的K个数 {

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
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums, int k) {
		ArrayList<Integer> resList = new ArrayList<>();
		// Base case
		if (k > nums.length || k <= 0) return resList;

		findKthSmallest(nums, k - 1);
		/* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
		for (int i = 0; i < k; i++)
			resList.add(nums[i]);
		return resList;
	}

	// 快排Partition
	public void findKthSmallest(int[] nums, int k) {

		int low = 0, high = nums.length - 1;
		while (low < high) {
			int j = partition(nums, low, high);
			if (j == k)
				break;
			if (j > k)
				high = j - 1;
			else
				low = j + 1;
		}
	}

	private int partition(int[] nums, int low, int high) {
		// 切分元素
		int p = nums[low];
		int i = low, j = high + 1;
		while (true) {
			while (i != high && nums[++i] < p) ;
			while (j != low && nums[--j] > p) ;
			if (i >= j)
				break;
			swap(nums, i, j);
		}
		swap(nums, low, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
