package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/1 20:14
 */
public class 按之字形顺序打印二叉树 {


	public ArrayList<ArrayList<Integer>> Print(TreeNode root) {

		if (root == null) {
			return new ArrayList<>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int len = queue.size();
			level++;
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
			if(level % 2 == 0) {
				Collections.reverse(levelList);
			}
			resList.add(levelList);
		}
		return resList;
	}

}
