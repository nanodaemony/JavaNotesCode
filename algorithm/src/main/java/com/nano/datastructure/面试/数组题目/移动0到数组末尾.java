package com.nano.datastructure.面试.数组题目;

/**
 * @author: nano
 * @time: 2020/9/13 16:26
 */
public class 移动0到数组末尾 {

	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int num : nums) {
			// 不为0就拷贝到前面
			if (num != 0) {
				nums[index++] = num;
			}
		}
		// 将后面的全部置0
		while (index < nums.length) {
			nums[index++] = 0;
		}
	}

}
