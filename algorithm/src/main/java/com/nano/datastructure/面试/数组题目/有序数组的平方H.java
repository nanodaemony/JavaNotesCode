package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/8/14 14:24
 */
public class 有序数组的平方H {


	public int diffSquareNum(int nums[]) {
		int n = nums.length;
		if(n == 0 || nums == null) return 0;
		int sum = 0;
		int left = 0;
		int right = n - 1;
		while(left <= right){
			// 说明两个数平方相同
			if(nums[left] + nums[right] == 0){
				sum++;
				// 这里开始去掉后面重复的数字
				int temp = nums[left];
				while(left <= right && nums[left] == temp)
					left++;
				while(left <= right && nums[right] == -temp)
					right--;
			} else if (nums[left] + nums[right] < 0){
				sum++;
				int temp = nums[left];
				while(left <= right && nums[left] == temp)
					left++;
			} else {
				sum++;
				int temp = nums[right];
				while(left <= right && nums[right] == temp)
					right--;
			}
		}
		return sum;
	}

}
