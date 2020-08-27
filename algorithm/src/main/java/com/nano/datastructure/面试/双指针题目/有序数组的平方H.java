package com.nano.datastructure.面试.双指针题目;

/**
 * @author: nano
 * @time: 2020/8/14 14:24
 */
public class 有序数组的平方H {


	public int diffSquareNum(int nums[]) {
		if(nums == null || nums.length == 0) return 0;
		int res = 0;
		// 左右指针
		int left = 0;
		int right = nums.length - 1;
		// 直到指针相遇
		while(left <= right){
			// 说明两个数平方相同
			if(nums[left] + nums[right] == 0){
				res++;
				// 这里开始去掉后面重复的数字
				int temp = nums[left];
				while(left <= right && nums[left] == temp) left++;
				while(left <= right && nums[right] == -temp) right--;
			} else if (nums[left] + nums[right] < 0){
				res++;
				int temp = nums[left];
				// 去重
				while(left <= right && nums[left] == temp) left++;
			} else {
				res++;
				int temp = nums[right];
				// 去重
				while(left <= right && nums[right] == temp) right--;
			}
		}
		return res;
	}

}
