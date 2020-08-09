package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/5 16:54
 */
public class Q1305两棵二叉搜索树值的合并 {

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> ansList1 = new ArrayList<>();
		List<Integer> ansList2 = new ArrayList<>();
		// 采用中序遍历方式将值分别放入列表
		dfs(root1, ansList1);
		dfs(root2, ansList2);
		// 归并排序合并两个有序链表
		return merge(ansList1, ansList2);
	}
	// 中序遍历
	private void dfs(TreeNode root, List<Integer> ansList) {
		if (root == null) return;
		// 中序遍历放入值
		dfs(root.left, ansList);
		ansList.add(root.val);
		dfs(root.right, ansList);
	}
	// 归并排序两个有序链表
	private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
		List<Integer> ansList = new ArrayList<>();
		int size1 = list1.size();
		int size2 = list2.size();
		int index1, index2;
		for (index1 = 0, index2 = 0; index1 < size1 && index2 < size2;) {
			int num1 = list1.get(index1);
			int num2 = list2.get(index2);
			if (num1 < num2) {
				ansList.add(num1);
				index1++;
			} else {
				ansList.add(num2);
				index2++;
			}
		}
		while (index1 < size1) {
			ansList.add(list1.get(index1++));
		}
		while (index2 < size2) {
			ansList.add(list2.get(index2++));
		}
		return ansList;
	}
}
