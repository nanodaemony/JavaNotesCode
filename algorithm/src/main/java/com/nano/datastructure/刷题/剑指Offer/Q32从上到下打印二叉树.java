package com.nano.datastructure.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/1 20:05
 */
public class Q32从上到下打印二叉树 {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

		if(root == null) {
			return new ArrayList<>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> resList = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			resList.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return resList;
	}

}
