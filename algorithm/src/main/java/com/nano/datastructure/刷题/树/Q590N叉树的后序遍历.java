package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/5 14:31
 */
public class Q590N叉树的后序遍历 {

	private List<Integer> resList;

	/**
	 * 递归法
	 */
	public List<Integer> postorder(Node root) {
		resList = new LinkedList<>();
		// 深度优先遍历
		dfs(root);
		return resList;
	}

	private void dfs(Node root) {
		// Base case
		if(root == null) {
			return;
		}
		// 整体后序遍历的架构，先遍历全部子结点最后再处理数据
		for(Node child : root.children) {
			dfs(child);
		}
		resList.add(root.val);
	}


	/**
	 * 迭代法
	 */
	public List<Integer> postorder2(Node root) {

		// Base case
		if (root == null) return new ArrayList<>();
		// 使用一个栈存储结点
		Stack<Node> stack = new Stack<>();
		// 存放结果
		LinkedList<Integer> resList = new LinkedList<>();
		// 根节点入栈
		stack.add(root);
		// 结束条件是栈为空
		while (!stack.isEmpty()) {
			// 栈中弹出一个结点
			Node node = stack.pop();
			// 将弹出节点的子结点元素加入结果
			resList.addFirst(node.val);
			// 顺序压入其他子节点
			for (Node item : node.children) {
				if (item != null) {
					stack.add(item);
				}
			}
		}
		return resList;
	}

}
