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
		if(root == null) return new ArrayList();
		binaryTreePaths(root, "");
		return resList;
	}

	public void binaryTreePaths(TreeNode root, String builder) {
		// Base case
		if(root == null) return;
		// 遇到叶子节点就加入结果集并返回
		if(root.left == null && root.right == null) {
			builder = builder + root.val;
			resList.add(builder);
			return;
			// 非叶子节点就需要额外加入箭头符号
		} else {
			builder = builder + root.val + "->";
		}
		// 递归
		binaryTreePaths(root.left, builder);
		binaryTreePaths(root.right, builder);
	}

}
