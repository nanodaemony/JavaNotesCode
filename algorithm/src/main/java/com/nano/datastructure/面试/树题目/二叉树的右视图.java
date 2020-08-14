package com.nano.datastructure.面试.树题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/14 20:29
 */
public class 二叉树的右视图 {

	// 当前最大层数
	int level = -1;
	List<Integer> resList = new ArrayList<>();

	public List<Integer> rightSideView2(TreeNode root) {
		dfs(root, 0);
		return resList;
	}

	// 辅助方法：传入根节点，层数，结果集
	public void dfs(TreeNode root, int level) {
		// Base case
		if (root == null) return;
		// 代表是新的一层，仅添加一次
		if (level > this.level) {
			this.level = level;
			resList.add(root.val);
		}
		// 先递归右子树
		dfs(root.right, level + 1);
		dfs(root.left, level + 1);
	}

}
