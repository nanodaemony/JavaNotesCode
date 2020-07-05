package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 16:53
 */
public class 调整数组顺序使奇数位于偶数前面 {

	public void reOrderArray(int[] nums) {
		// 获取长度
		int len = nums.length;
		// 从右到左冒泡
		for (int i = len - 1; i > 0; i--) {
			// 然后从左到右取值
			for (int j = 0; j < i; j++) {
				// 遇到一个奇数和偶数的情况时就交换
				if (isEven(nums[j]) && !isEven(nums[j + 1])) {
					swap(nums, j, j + 1);
				}
			}
		}
	}

	private boolean isEven(int x) {
		return x % 2 == 0;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
