package com.nano.datastructure.面试.树题目;

/**
 * @author: nano
 * @time: 2020/8/23 14:29
 */
public class 二叉搜索树的前序遍历求中序遍历 {

	public TreeNode bstFromPreorder(int[] preOrder) {
		return build(preOrder, 0, preOrder.length - 1);
	}

	// 数组的范围从left到right
	private TreeNode build(int[] preOrder, int left, int right) {
		if (left > right) return null;
		// 前序第一个left是根结点
		TreeNode root = new TreeNode(preOrder[left]);
		// 如果left==right说明只有一个元素，没法再拆分了
		if (left == right) return root;
		int i = left;
		// 拆分为两部分,一部分是比preorder[left]根结点大的,一部分是比preorder[left]根结点小的
		while (i + 1 <= right && preOrder[i + 1] < preOrder[left]) {
			i++;
		}
		// 区间[left + 1，i]所有元素都在root节点的左子树
		// 区间[i + 1，right]所有元素都在root节点的右子树
		root.left = build(preOrder, left + 1, i);
		root.right = build(preOrder, i + 1, right);
		return root;
	}




}
