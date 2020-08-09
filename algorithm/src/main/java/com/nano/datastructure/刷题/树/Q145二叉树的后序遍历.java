package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/8 13:31
 */
public class Q145二叉树的后序遍历 {


	public List<Integer> postorderTraversal(TreeNode root) {

		if (root == null) return new ArrayList<>();
		List<Integer> resList = new ArrayList<>();


		// 准备两个栈
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		// 根节点压入栈1
		s1.push(root);
		// 退出条件为栈1为空
		while (!s1.isEmpty()) {
			// 栈1每弹出一个元素就放入栈2
			root = s1.pop();
			s2.push(root);

			// 再将当前弹出元素的左右子节点分别入栈,一定是先左再右
			if (root.left != null) s1.push(root.left);
			if (root.right != null) s1.push(root.right);
		}
		// 当栈1为空时，依次弹出栈2就是后序遍历顺序
		while (!s2.isEmpty()) {
			resList.add(s2.pop().val);
		}
		return resList;
	}

}
