package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/7/5 21:04
 */
public class Q538把二叉搜索树转换为累加树 {

	// 全局变量，用于记录累加和
	int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		TreeNode cur = root;
		helper(cur);
		return root;
	}
	// 整个是中序遍历的模板：但是搜索二叉树先遍历右子树再遍历左子树就是降序遍历！
	private void helper(TreeNode root) {
		// Base case
		if(root == null) return;
		// 先递归右子树
		convertBST(root.right);
		// 不断累积更新sum值
		sum = sum + root.val;
		// 将当前遍历过的节点值设置为sum
		root.val = sum;
		// 再递归左子树
		convertBST(root.left);
	}

}
