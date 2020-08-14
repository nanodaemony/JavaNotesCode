package com.nano.datastructure.面试.树题目;

/**
 * @author: nano
 * @time: 2020/8/14 20:55
 */
public class 完全二叉树结点个数 {


	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int leftLevel = countLevel(root.left);
		int rightLevel = countLevel(root.right);
		if (leftLevel == rightLevel) {
			// 移位运算，1向左移动left次，相当于1*2^n
			return countNodes(root.right) + (1 << leftLevel);
		} else {
			return countNodes(root.left) + (1 << rightLevel);
		}
	}
	// 计算层数
	private int countLevel(TreeNode root) {
		int level = 0;
		while (root != null) {
			level++;
			root = root.left;
		}
		return level;
	}

}
