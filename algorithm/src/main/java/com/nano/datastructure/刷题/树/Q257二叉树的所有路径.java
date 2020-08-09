package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/6 20:50
 */
public class Q257二叉树的所有路径 {


	private List<String> resList = new ArrayList<>();

	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) return new ArrayList<>();
		dfs(root, "");
		return resList;
	}

	public void dfs(TreeNode root, String res) {
		// Base case
		if(root == null) return;
		// 遇到叶子节点就加入结果集并返回
		if(root.left == null && root.right == null) {
			res = res + root.val;
			resList.add(res);
			return;
			// 非叶子节点就需要额外加入箭头符号
		} else {
			res = res + root.val + "->";
		}
		// 递归
		dfs(root.left, res);
		dfs(root.right, res);
	}

}
