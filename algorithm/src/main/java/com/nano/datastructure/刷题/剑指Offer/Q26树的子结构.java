package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/1 17:47
 */
public class Q26树的子结构 {

	public boolean isSubStructure(TreeNode root1, TreeNode root2) {
		// base case
		if (root1 == null || root2 == null) return false;
		// 这里需要对A的全部结点作为根结点与B作为根结点进行匹配
		return recur(root1, root2) || isSubStructure(root1.left, root2) || isSubStructure(root1.right, root2);
	}

	// 判断以当前两个根结点是不是子结构
	private boolean recur(TreeNode root1, TreeNode root2) {
		if (root2 == null) return true;
		if (root1 == null) return false;
		if (root1.val != root2.val) return false;
		return recur(root1.left, root2.left) && recur(root1.right, root2.right);
	}

}
