package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/8/9 12:40
 */
public class Q687最长同值路径 {

	int res = 0;    // 结果
	public int longestUnivaluePath(TreeNode root) {
		helper(root);
		return res;
	}
	// 搜索以root为起点的最长同值路径,要么经过左子树，要么经过右子树
	public int helper(TreeNode root) {
		if (root == null) return 0;
		// 以root为起点的最长同值路径
		int maxLength = 0;
		int leftLength = helper(root.left);     // 以root.left为起点的最长同值路径
		int rightLength = helper(root.right);   // 以root.right为起点的最长同值路径
		// 情况2，不需要更新maxLength，但要更新结果
		if (root.left != null && root.right != null &&
				root.val == root.left.val && root.val == root.right.val) {
			res = Math.max(res, leftLength + rightLength + 2);
		}
		// 从左右子树中选取最长同值路径
		if (root.left != null && root.val == root.left.val) {
			maxLength = leftLength + 1;
		}
		if (root.right != null && root.val == root.right.val) {
			maxLength = Math.max(maxLength, rightLength + 1);
		}
		// 更新结果
		res = Math.max(res, maxLength);
		return maxLength;
	}

}
