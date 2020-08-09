package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 19:53
 */
public class Q654最大二叉树 {

	int[] nums;

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		this.nums = nums;
		// 第一次的范围是0到length
		return helper(0, nums.length);
	}

	public TreeNode helper(int start, int end) {
		// Base case
		if (start >= end) return null;

		// 遍历数组寻找当前范围下的最大值作为分界线
		int max = nums[start];
		int maxIndex = start;
		for (int i = start + 1; i < end; i++) {
			if (max < nums[i]) {
				// 更新最大数值和索引值
				max = nums[i];
				maxIndex = i;
			}
		}
		// 使用最大值构造一个根结点
		TreeNode root = new TreeNode(max);
		// 递归设置左右子树
		root.left = helper(start, maxIndex);
		root.right = helper(maxIndex + 1, end);
		return root;
	}


}
