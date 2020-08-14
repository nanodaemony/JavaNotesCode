package com.nano.datastructure.面试.其他;

import com.nano.datastructure.A;

import java.util.ArrayList;

/**
 * @author: nano
 * @time: 2020/8/14 17:10
 */
public class 求前K大的元素 {


	public ArrayList<Integer> topK(int[] nums, int k) {
		ArrayList<Integer> resList = new ArrayList<>();
		// 如果元素个数较小
		if (nums.length <= k) {
			for (int num : nums) {
				resList.add(num);
			}
			return resList;
		}
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		int target = len - k;
		int index = 0;
		while (true) {
			index = partition(nums, left, right);
			if (index == target) {
				break;
			} else if (index < target) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}
		for (int i = target; i < len; i++) {
			resList.add(nums[i]);
		}
		return resList;
	}

	public int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int j = left;
		for (int i = left + 1; i <= right; i++) {
			// 当前值大于pivot值
			if (nums[i] > pivot) {
				j++;
				swap(nums, i, j);
			}
		}
		swap(nums, left, j);
		return j;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
