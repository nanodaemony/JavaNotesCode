package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/8/9 13:03
 */
public class Q988从叶结点开始的最小字符串 {

	private String resStr = "";

	public String smallestFromLeaf(TreeNode root) {
		if (root == null) {
			return "";
		}
		dfs(root, "");
		return resStr;
	}

	private void dfs(TreeNode root, String path) {

		if (root == null) return;

		// 构造字符串
		path = (char) ('a' + root.val) + path;
		// 当前的结点为叶子结点，此时利用字符串进行对比
		if (root.left == null && root.right == null) {
			// 若所生成字符串比当前最小字符串小，则更新保留
			if ("".equals(resStr) || path.compareTo(resStr) < 0) resStr = path;
			return;
		}
		// 非叶子结点递归
		dfs(root.left, path);
		dfs(root.right, path);
	}

}
