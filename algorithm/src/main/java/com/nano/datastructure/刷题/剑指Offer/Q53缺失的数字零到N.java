package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/3 19:52
 */
public class Q53缺失的数字零到N {


	public int missingNumber(int[] nums) {
		int low = 0, high = nums.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(nums[mid] == mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}



}
