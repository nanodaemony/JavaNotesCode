package com.nano.datastructure.面试.树题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: nano
 * @time: 2020/8/14 21:08
 */
public class 二叉树的最大路径和 {



	int maxSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return maxSum;
	}

	public int dfs(TreeNode root) {
		if (root == null) return 0;
		// 求左右的最大路径和
		int leftGain = Math.max(0, dfs(root.left));
		int rightGain = Math.max(0, dfs(root.right));

		maxSum = Math.max(maxSum, root.val + leftGain + rightGain);
		return root.val + Math.max(leftGain, rightGain);
	}




	public boolean hasPathSum2(TreeNode root, int sum) {
		if(root == null) return false;
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();

		nodeStack.push(root);
		numStack.push(sum - root.val);

		while(!nodeStack.isEmpty()){
			TreeNode node = nodeStack.pop();
			Integer value = numStack.pop();

			if(node.left == null && node.right == null && value == 0) return true;

			if(node.left != null){
				nodeStack.push(node.left);
				numStack.push(value - node.left.val);
			}
			if(node.right != null){
				nodeStack.push(node.right);
				numStack.push(value - node.right.val);
			}
		}
		return false;
	}

	//-----------------下面是找出全部路径---------------------

	List<List<Integer>> resList = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>();
		// 递归求解路径总和
		path(root, sum, tmp);
		return ans;
	}



	// 传入4个参数来完成路径的存放和搜索
	private void path(TreeNode root, int sum, ArrayList<Integer> tempList) {
		if (root == null) return;
		tempList.add(root.val);
		// 复合条件加入结果
		if (root.left == null && root.right == null && sum == root.val) {
			resList.add(new ArrayList<>(tempList));
		}
		path(root.left, sum - root.val, tempList);
		path(root.right, sum - root.val, tempList);
		// 这里利用了回溯的思想:每次回退上一个节点再寻找另一条边的节点作为新路径
		tempList.remove(tempList.size() - 1);
	}


}
