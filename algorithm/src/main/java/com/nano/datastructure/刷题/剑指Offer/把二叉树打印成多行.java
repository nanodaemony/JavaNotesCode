package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/1 20:08
 */
public class 把二叉树打印成多行 {

	public ArrayList<ArrayList<Integer>> Print(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			int len = queue.size();
			ArrayList levelList = new ArrayList();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				levelList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			resList.add(levelList);
		}
		return resList;
	}


}

