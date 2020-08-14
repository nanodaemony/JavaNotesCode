package com.nano.datastructure.面试.树题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/14 20:23
 */
public class 二叉树前序遍历 {


	public List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> resList = new ArrayList<>();
		if(root == null) return resList;
		// 准备一个栈并把根节点压栈
		Stack<TreeNode> stack = new Stack<>();
		// 根结点压栈
		stack.push(root);
		// 不断从栈中弹出元素弹出时处理数据，并先将右孩子压栈再将左孩子压栈
		while(!stack.isEmpty()) {
			// 弹出节点并处理数据
			TreeNode node = stack.pop();
			resList.add(node.val);
			// 先压入右结点，再压入左结点
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
		return resList;
	}

}
