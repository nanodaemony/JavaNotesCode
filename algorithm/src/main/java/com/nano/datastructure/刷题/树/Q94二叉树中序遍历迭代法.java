package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/8 13:15
 */
public class Q94二叉树中序遍历迭代法 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		// 条件是栈不为空且root不为null
		while (!stack.isEmpty() || root != null) {
			// 将全部左子结点压栈,这是模拟递归的调用
			if (root != null) {
				stack.push(root);
				root = root.left;
				// 当前节点为空，说明左边走到头了，从栈中弹出节点并保存
			} else {
				TreeNode temp = stack.pop();
				res.add(temp.val);
				// 然后转向右边节点，继续上面整个过程
				root = temp.right;
			}
		}
		return res;
	}


}
