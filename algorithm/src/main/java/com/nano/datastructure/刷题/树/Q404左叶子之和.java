package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:49
 */
public class Q404左叶子之和 {

	private int sum;
	public int sumOfLeftLeaves(TreeNode root) {
		process(root, false);
		return sum;
	}
	// 递归整体先序遍历的架构
	private void process(TreeNode root, boolean isLeft) {
		if(root == null) return;
		// 当前节点是叶子节点且是左结点则相加
		if(root.left == null && root.right == null && isLeft) {
			sum = sum + root.val;
		}
		// 递归左子树时默认为true，如果此时为子节点则加起来
		process(root.left, true);
		process(root.right, false);
	}

}
