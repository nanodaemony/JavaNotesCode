package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 19:47
 */
public class Q108有序数组构造成搜索二叉树 {


	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	// 辅助数组，传入nums，需要构造树的起始和结束索引
	private TreeNode helper(int[] nums, int start, int end) {
		// Base case
		if(start > end) return null;
		// 仅一个元素则直接返回这个元素构成的结点
		if(start == end) return new TreeNode(nums[start]);
		// 否则用中间结点构造根节点,这样才是高度平衡的
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		// 递归构造左右子树
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		// 返回构造好的根结点
		return root;
	}

}
