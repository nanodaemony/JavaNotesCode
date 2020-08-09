package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 14:41
 */
public class Q102二叉树的层序遍历I {


	/**
	 * 迭代法
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		// Base case
		if(root == null) return new ArrayList<>();
		// 使用辅助队列并将根节点入队列
		Queue<TreeNode> queue = new LinkedList<>() ;
		queue.add(root);
		List<List<Integer>> resList = new ArrayList<>();
		// 队列为空时退出循环
		while(queue.size() != 0) {
			// 获取当前队列中的元素个数，也就是当前这一层有多少个结点，这是为了控制访问到了某一层
			int size = queue.size();
			List<Integer> levelList = new ArrayList<>();
			// 将当前层的元素依次出队列并处理数据，每弹出一个结点并再次将其左右子节点入队列
			for(int i = 0; i < size; i++) {
				// 出队列并处理数据
				TreeNode temp = queue.poll();
				levelList.add(temp.val);
				// 将出队结点的左右子节点入队
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
			}
			// 这一层弹出的元素处理完毕
			resList.add(levelList);
			// 此时下一层的全部节点已经到队列中，再次循环即可
		}
		return resList;
	}


	/**
	 * 递归法
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		if (root == null) return resList;
		// 从根结点开始递归,根结点是第0层
		dfs(root, 0);
		return resList;
	}

	List<List<Integer>> resList = new ArrayList<>();

	// 辅助方法:整体是先序遍历的模板
	public void dfs(TreeNode node, int level) {
		// 说明遇到了新的一层则新建一个列表,并添加一层新的到结果中
		if (resList.size() == level) {
			resList.add(new ArrayList<>());
		}
		// 根据层数获取对应的列表并将当前节点的值加入到list中（先序遍历）
		resList.get(level).add(node.val);

		// 递归进行
		if (node.left != null) dfs(node.left, level + 1);
		if (node.right != null) dfs(node.right, level + 1);
	}



}
