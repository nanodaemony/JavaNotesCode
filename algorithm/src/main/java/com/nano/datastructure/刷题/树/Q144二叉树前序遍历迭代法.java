package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/8 13:07
 */
public class Q144二叉树前序遍历迭代法 {

	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) return new ArrayList<>();
		List<Integer> resList = new ArrayList<>();
		// 准备一个栈并把根节点压栈
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		// 不断从栈中弹出元素弹出时处理数据，并先将右孩子压栈再将左孩子压栈
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			resList.add(node.val);
			// 先压入右结点，再压入左结点
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
		return resList;
	}

}
