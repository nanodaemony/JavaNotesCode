package com.nano.datastructure.刷题.树;

/**
 * @author: nano
 * @time: 2020/8/9 12:36
 */
public class Q100相同的树 {

	boolean isSame = true;
	public boolean isSameTree(TreeNode root1, TreeNode root2) {
		dfs(root1, root2);
		return isSame;
	}

	private void dfs(TreeNode root1, TreeNode root2) {

		// Base case 如果两个都为空返回true
		if(root1 == null && root2 == null) return;
		// 如果其中一个结点为空或者两个的值不同，返回false
		if((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.val != root2.val)) {
			isSame = false;
			return;
		}
		// 递归获取左右子树信息
		isSameTree(root1.left, root2.left);
		isSameTree(root1.right, root2.right);
	}


	public boolean isSameTree2(TreeNode root1, TreeNode root2) {
		// Base case 如果两个都为空返回true
		if(root1 == null && root2 == null) return true;
		// 如果其中一个结点为空或者两个的值不同，返回false
		if((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.val != root2.val)) {
			return false;
		}
		// 递归获取左右子树信息
		boolean left = isSameTree(root1.left, root2.left);
		boolean right = isSameTree(root1.right, root2.right);
		// 必须左右子树都是true才为true
		return left && right;
	}
}
