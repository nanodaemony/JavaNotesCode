package com.nano.datastructure.刷题.树;

import java.util.LinkedList;

/**
 * @author: nano
 * @time: 2020/7/5 20:14
 */
public class Q112根结点到叶子节点路径总合 {

	private boolean isFind = false;

	public boolean hasPathSum(TreeNode root, int sum) {
		helper(root, sum);
		return isFind;
	}

	// 整体中序递归模板
	private void helper(TreeNode root, int sum) {
		// Base case
		if(root == null) return;
		// 如果当前的sum等于结点值且当前正好为根结点则找到
		if(sum == root.val && (root.left == null && root.right == null)) {
			isFind = true;
		}
		helper(root.left, sum - root.val);
		helper(root.right, sum - root.val);
	}


	/**
	 * 迭代法
	 */
	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) return false;

		LinkedList<TreeNode> nodeStack = new LinkedList();
		LinkedList<Integer> sumStack = new LinkedList();
		nodeStack.add(root);
		sumStack.add(sum - root.val);

		TreeNode node;
		int currSum;
		while (!nodeStack.isEmpty() ) {
			node = nodeStack.pollLast();
			currSum = sumStack.pollLast();
			if ((node.right == null) && (node.left == null) && (currSum == 0)) {
				return true;
			}

			if (node.right != null) {
				nodeStack.add(node.right);
				sumStack.add(currSum - node.right.val);
			}
			if (node.left != null) {
				nodeStack.add(node.left);
				sumStack.add(currSum - node.left.val);
			}
		}
		return false;
	}

}
