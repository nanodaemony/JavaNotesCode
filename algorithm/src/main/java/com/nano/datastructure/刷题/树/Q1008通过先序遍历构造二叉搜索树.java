package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 19:16
 */
public class Q1008通过先序遍历构造二叉搜索树 {


	int index = 0;
	int[] preOrder;
	int len;


	public TreeNode bstFromPreorder(int[] preOrder) {
		this.preOrder = preOrder;
		len = preOrder.length;
		return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// 递归构造：整体是线序遍历
	public TreeNode helper(int lower, int upper) {
		// 当全部元素都用了就是构造好了
		if (index == len) return null;
		// 取一个值
		int val = preOrder[index];
		// 如果当前值不符合搜索二叉树的特性
		if (val < lower || val > upper) return null;
		index++;
		// 递归构造二叉树
		TreeNode root = new TreeNode(val);
		root.left = helper(lower, val);
		root.right = helper(val, upper);
		return root;
	}


	//-------另一种递归写法------

	public TreeNode bstFromPreorder2(int[] preorder) {
		return helper(preorder, 0, preorder.length - 1);
	}

	// 辅助函数：传入先序数组，数组左边界，右边界
	private TreeNode helper(int[] preorder, int left, int right){
		// Base case
		if (left > right) return null;

		// 用来找比根节点大的第一个点，也就是右子节点的开始
		int index = -1;
		// 从左边界left开始寻找
		for (int i = left; i<= right; i++){
			if (preorder[i] > preorder[left]){
				// 找到第一个大于根节点的索引
				index = i;
				break;
			}
		}
		// 构造自己的返回值 创建当前深度的根节点，使用的是当前数组的第一个节点
		TreeNode node = new TreeNode(preorder[left]);
		// 满足则说明左子树不为空
		if (index != left) {
			// 分情况构造左子树
			if (index != -1) {
				node.left = helper(preorder, left + 1, index - 1);
			} else {
				node.left = helper(preorder, left + 1, right);
			}
		}
		// 满足则说明右子树不为空
		if (index != -1)
			// 构造右子树
			node.right = helper(preorder, index, right);
		return node;
	}

}
