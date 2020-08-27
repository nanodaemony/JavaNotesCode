package com.nano.datastructure.面试.贪心问题;

/**
 * @author: nano
 * @time: 2020/8/26 21:50
 */
public class 种植花朵 {
	public boolean canPlaceFlowers(int[] nums, int n) {

		if(nums == null) return false;
		// 只有一个
		if(nums.length == 1 && nums[0] == 0) return true;
		// 只有两个
		if(nums.length == 2 && nums[0] == 0 && nums[1] == 0 && n <= 1) return true;

		int count = 0;
		// 如果第一个和第二个是空的就在第一个种花
		if(nums[0] == 0 && nums[1] == 0) {
			nums[0] = 1;
			count++;
		}
		// 如果倒数第一个和倒数第二个为0则在最后一个种花
		if(nums[nums.length - 1] == 0 && nums[nums.length - 2] == 0) {
			nums[nums.length - 1] = 1;
			count++;
		}
		// 中间的花,如果当前位置为0,且左右都为0则种花
		for (int i = 1; i < nums.length - 1; i++) {
			if(nums[i] == 0 && nums[i - 1] == 0 && nums[i + 1] == 0) {
				nums[i] = 1;
				count++;
			}
		}
		return count >= n;
	}


}
