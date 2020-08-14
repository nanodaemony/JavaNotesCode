package com.nano.datastructure.面试.树题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/14 20:25
 */
public class 二叉树中序遍历 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		// 条件是栈不为空且root不为null
		while (!stack.isEmpty() || root != null) {
			// 将当前root的全部左子结点压栈,模拟递归调用
			if (root != null) {
				stack.push(root);
				root = root.left;
				// 当前节点为null，说明左边走到头，此时可以栈中弹出节点并处理数据
			} else {
				// 处理当前节点
				TreeNode temp = stack.pop();
				res.add(temp.val);
				// 马上切换处理右子节点
				root = temp.right;
			}
		}
		return res;
	}

}
