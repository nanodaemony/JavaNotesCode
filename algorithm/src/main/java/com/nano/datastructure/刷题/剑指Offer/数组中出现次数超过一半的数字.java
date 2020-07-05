package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/2 15:34
 */
public class 数组中出现次数超过一半的数字 {

	public int MoreThanHalfNum_Solution(int[] nums) {
		// 假设第一个数字为最多的数
		int majority = nums[0];
		// 遍历一波cnt初始值为1
		int cnt = 1;
		for (int i = 1; i < nums.length; i++) {

			// 如果当前索引处值等于majority则计数器++，否则--
			if(nums[i] == majority) {
				cnt++;
			} else {
				cnt--;
			}
			// 如果计数器为0则更新majority的值并重置cnt为1
			if (cnt == 0) {
				majority = nums[i];
				cnt = 1;
			}
		}
		// cnt置0
		cnt = 0;
		for (int val : nums)
			if (val == majority)
				cnt++;
		return cnt > nums.length / 2 ? majority : 0;
	}

}
