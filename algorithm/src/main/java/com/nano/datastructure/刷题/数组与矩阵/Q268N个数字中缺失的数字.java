package com.nano.datastructure.刷题.数组与矩阵;

/**
 * @author: nano
 * @time: 2020/7/14 21:05
 */
public class Q268N个数字中缺失的数字 {

	public int missingNumber(int[] nums) {
		// 期待的和
		int expectedSum = nums.length * (nums.length + 1) / 2;
		// 计算实际的全部和
		int actualSum = 0;
		for (int num : nums) actualSum = actualSum + num;
		// 得到结果
		return expectedSum - actualSum;
	}

}
