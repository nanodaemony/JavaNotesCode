package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 20:54
 */
public class Q863二叉树中所有距离为K的结点 {


	// 存放当前节点及其父节点的指针的Map
	HashMap<TreeNode, TreeNode> map = new HashMap<>();

	public List<Integer> distanceK(TreeNode root, TreeNode targetNode, int K) {
		// base case
		if (root == null || targetNode == null) return new ArrayList<>();

		// 用于记录已经访问过的结点
		HashSet<TreeNode> set = new HashSet<>();
		// 存放答案
		List<Integer> resList = new LinkedList<>();
		// 使用队列遍历
		Queue<TreeNode> queue = new LinkedList<>();

		// 深度优先遍历找到每个节点的父节点信息并记录到map中,根节点的parent为null
		dfs(root, null);
		// 目标结点入队列与Set中
		queue.add(targetNode);
		set.add(targetNode);
		// 下面是层序遍历的逻辑BFS
		while (!queue.isEmpty() && K > 0) {
			// 判断当前层的结点数
			int size = queue.size();
			// 层数--
			K--;
			// 弹出这一层的全部结点,前面的几层不做数据处理
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null && set.add(node.left) == true) queue.add(node.left);
				if (node.right != null && set.add(node.right) == true) queue.add(node.right);
				if (map.containsKey(node) && set.add(map.get(node)) == true) queue.add(map.get(node));
				size--;
			}
		}
		// 现在到了第K层这一层的数据就是答案
		while (!queue.isEmpty()) {
			resList.add(queue.poll().val);
		}

		return resList;
	}

	// 找到结点的父节点信息并存入map中
	public void dfs(TreeNode root, TreeNode parent) {
		if (parent != null) map.put(root, parent);
		if (root.left != null) dfs(root.left, root);
		if (root.right != null) dfs(root.right, root);
	}

}
