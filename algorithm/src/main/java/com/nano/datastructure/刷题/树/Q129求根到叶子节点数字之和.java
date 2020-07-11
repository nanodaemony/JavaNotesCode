package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/11 13:53
 */
public class Q129求根到叶子节点数字之和 {

	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	public int helper(TreeNode root, int i){
		if (root == null) return 0;
		int temp = i * 10 + root.val;
		if (root.left == null && root.right == null)
			return temp;
		return helper(root.left, temp) + helper(root.right, temp);
	}

}
