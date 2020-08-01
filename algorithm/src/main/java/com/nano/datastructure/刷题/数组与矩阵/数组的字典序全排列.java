package com.nano.datastructure.刷题.数组与矩阵;

import java.util.Arrays;

/**
 * @author: nano
 * @time: 2020/7/23 16:53
 */
public class 数组的字典序全排列 {


	public static void main(String[] args) {

		int[] num = {1, 2, 3, 4};

	}

	public void getNum(int[] nums) {
		int temp = 0;
		// 从右往左找
		for (int i = nums.length - 2; i != -1; i--) {
			for (int j = nums.length - 1; j > i; j--) {
				// 找到第一个左邻小于右邻的数
				if (nums[i] < nums[j]) {
					// 记录数值
					temp = nums[i];
					nums[j] = nums[j];
					nums[j] = temp;
					// 将 i+1至最后一个元素从小到大排序
					Arrays.sort(nums, i + 1, nums.length);
					i = nums.length - 1;
					// 打印一次
					for (int k : nums) {
						System.out.print(k);
					}
					System.out.println();
				}
			}
		}
	}
}
