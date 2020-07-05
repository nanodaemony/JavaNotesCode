package com.nano.datastructure.刷题.树;

import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/7/5 17:17
 */
public class Q783二叉搜索树节点最小距离 {

	// 记录结果
	int res = Integer.MAX_VALUE;
	// 记录上一个结点
	TreeNode lastNode = null;

	public int minDiffInBST(TreeNode root) {
		process(root);
		return res;
	}

	// 中序遍历二叉搜索树
	private void process(TreeNode root) {
		// Base case
		if(root == null) return;
		process(root.left);
		// 如果上一个结点不为空则计算更新最小值
		if(lastNode != null) {
			res = Math.min(res, root.val - lastNode.val);
		}
		// 更新上一个结点的指针为当前节点
		lastNode = root;
		process(root.right);
	}


	/**
	 * 迭代法
	 */
	public int midOrderUnRecursive(TreeNode root) {

		// 注意：记录前一个结点
		TreeNode lastNode = null;
		int res = Integer.MAX_VALUE;

		if (root != null) {
			// 准备一个栈
			Stack<TreeNode> stack = new Stack<>();
			// 不把头结点压栈
			while (!stack.isEmpty() || root != null) {
				// 持续将当前结点的左子节点压栈
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					// 弹出数据处理
					root = stack.pop();
					// 注意：处理数据
					if(lastNode != null) {
						res = Math.min(res, root.val - lastNode.val);
					}
					lastNode = root;
					// 变到右子树
					root = root.right;
				}
			}
		}
		return res;
	}

}
