package com.nano.datastructure.面试.树题目;

/**
 * @author: nano
 * @time: 2020/8/25 12:22
 */
public class 路径总和III {


	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		int result = countPath(root, sum);
		int a = pathSum(root.left, sum);
		int b = pathSum(root.right, sum);
		return result + a + b;
	}

	// 先序遍历模板
	public int countPath(TreeNode root, int sum) {
		// 结点为空个数为0
		if (root == null) return 0;
		// 计算当前sum还剩多少
		sum = sum - root.val;
		// 分别计算左右个数
		int leftNum = countPath(root.left, sum);
		int rightNum = countPath(root.right, sum);
		// 如果sum为0,则多找到一个路径
		if(sum == 0) {
			return leftNum + rightNum + 1;
		} else {
			return leftNum + rightNum;
		}
	}

}
