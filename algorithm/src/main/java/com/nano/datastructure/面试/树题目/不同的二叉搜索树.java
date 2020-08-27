package com.nano.datastructure.面试.树题目;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/8/27 14:04
 */
public class 不同的二叉搜索树 {
	public List<TreeNode> generateTrees(int num) {
		if (num < 1) return new LinkedList<>();
		return generateSubtrees(1, num);
	}

	private List<TreeNode> generateSubtrees(int start, int end) {
		List<TreeNode> resList = new LinkedList<>();
		if (start > end) {
			resList.add(null);
			return resList;
		}
		for (int i = start; i <= end; i++) {
			// 左右子树
			List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
			List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);
			for (TreeNode left : leftSubtrees) {
				for (TreeNode right : rightSubtrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					resList.add(root);
				}
			}
		}
		return resList;
	}

}
