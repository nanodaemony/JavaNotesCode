package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/8/3 21:32
 */
public class Q28对称二叉树 {

	boolean isSymmetric(TreeNode pRoot) {
		// Base case
		if (pRoot == null) return true;
		// 对比根结点的左右子结点是否相同
		return process(pRoot.left, pRoot.right);
	}

	boolean process(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return true;
		if (t1 == null || t2 == null) return false;
		// 值不同
		if (t1.val != t2.val) return false;
		// 递归对比对称位置是否对称
		return process(t1.left, t2.right) && process(t1.right, t2.left);
	}

}
