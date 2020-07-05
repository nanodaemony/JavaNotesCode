package com.nano.datastructure.刷题.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: nano
 * @time: 2020/7/5 16:12
 */
public class Q559N叉树的最大深度 {

	public int maxDepth(Node root) {
		// Base case：为null退出
		if(root == null) return 0;
		// 当为叶子结点直接返回1
		if(root.children == null || root.children.size() == 0) {
			return 1;
		}
		// 使用列表存储各个子树的高度信息值
		List<Integer> heightList = new ArrayList();
		// 获取各个子树的高度信息并存入列表
		for(Node head : root.children) {
			heightList.add(maxDepth(head));
		}
		// 返回各个子树最大的高度+1
		return Collections.max(heightList) + 1;
	}

}
