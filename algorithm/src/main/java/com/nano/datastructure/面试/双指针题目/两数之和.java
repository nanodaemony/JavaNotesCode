package com.nano.datastructure.面试.双指针题目;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/8/14 14:19
 */
public class 两数之和 {

	public int[] twoSum(int[] nums, int target) {

		if(nums == null || nums.length == 0) return new int[]{};

		Arrays.sort(nums);
		int i = 0;
		int j = nums.length - 1;
		while(i < j) {
			int sum = nums[i] + nums[j];
			if(sum > target) {
				j--;
			} else if(sum < target) {
				i++;
			} else {
				// 返回这两个数
				return new int[]{nums[i], nums[j]};
			}
		}
		return new int[]{};
	}


	public ArrayList<int[]> findPair(int[] nums, int target){
		int len = nums.length;
		int i = 0;
		int j = len - 1;
		ArrayList<int[]> resList = new ArrayList<>();
		while(i < j){
			int sum = nums[i] + nums[j];
			if(sum > target){
				j--;
			} else if (sum < target){
				i++;
			} else {
				resList.add(new int[]{nums[i], nums[j]});
			}
		}
		return resList;
	}

}
