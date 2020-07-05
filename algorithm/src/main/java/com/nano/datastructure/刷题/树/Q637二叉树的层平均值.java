package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/5 15:00
 */
public class Q637二叉树的层平均值 {

	public List<Double> averageOfLevels(TreeNode root) {
		// Base case
		if(root == null) {
			return new ArrayList();
		}
		// 根节点入队列
		Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
		queue.add(root);
		List<Double> resList = new ArrayList();
		// 队列为空时推退出循环
		while(queue.size() != 0) {
			// 获取当前队列中的元素个数，也就是当前这一层有多少个结点
			int len = queue.size();
			// 保存这一层的节点数值的和
			double sum = 0;
			// 将当前层的元素依次出队列并处理数据，每弹出一个结点并再次将其左右子节点入队列
			for(int i = 0; i < len; i++) {
				// 出队列并处理数据
				TreeNode temp = queue.poll();
				// 转换成double类型
				sum = sum + (double)temp.val;
				// 将出队结点的左右子节点入队
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
			}
			// 这一层弹出的元素处理完毕
			resList.add(sum / len);
		}
		return resList;
	}



	/**
	 * 递归法
	 */
	public List <Double> averageOfLevels2(TreeNode root) {
		List<Double> resList = new ArrayList<>();
		// 记录每层的元素个数数组
		List <Integer> levelNodeNumberList = new ArrayList<>();
		// 记录每层元素和数组
		List <Double> levelSumList = new ArrayList<>();
		// 递归求上述的两个数组的值
		dfs(root, 0, levelSumList, levelNodeNumberList);
		// 求平均值（因为两个数组是对应的）
		for (int i = 0; i < resList.size(); i++)
			resList.set(i, levelSumList.get(i) / levelNodeNumberList.get(i));
		return levelSumList;
	}

	// 进行DFS-整体是先序遍历的模板
	public void dfs(TreeNode root, int level, List<Double> sumList, List<Integer> numberList) {
		// Base case
		if (root == null)
			return;
		// 说明这里到了一个新的层
		if (level < sumList.size()) {
			sumList.set(level, sumList.get(level) + root.val);
			numberList.set(level, numberList.get(level) + 1);
		} else {
			// 加入元素
			sumList.add(1.0 * root.val);
			numberList.add(1);
		}
		dfs(root.left, level + 1, sumList, numberList);
		dfs(root.right, level + 1, sumList, numberList);
	}

}
