package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/6 22:02
 */
public class Q872叶子相似的树 {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = new ArrayList();
		List<Integer> leaves2 = new ArrayList();
		dfs(root1, leaves1);
		dfs(root2, leaves2);
		return leaves1.equals(leaves2);
	}

	// 整体是先序遍历的架构
	public void dfs(TreeNode node, List<Integer> leafValues) {
		if (node == null) return;

		// 深度优先遍历树，将叶子节点值保存
		if (node.left == null && node.right == null) {
			leafValues.add(node.val);
		}
		dfs(node.left, leafValues);
		dfs(node.right, leafValues);
	}

}
