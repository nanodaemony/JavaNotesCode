package com.nano.datastructure.graph;

import java.util.HashSet;
import java.util.Stack;

public class Code02_DFS {

	public static void dfs(Node node) {
		// Base case
		if (node == null) return;
		// 使用一个栈用于遍历
		Stack<Node> stack = new Stack<>();
		// 使用一个Set保存已经访问过的结点
		HashSet<Node> visitedSet = new HashSet<>();
		// 将头结点如栈和Set
		stack.add(node);
		visitedSet.add(node);
		// 打印头结点代表已经访问
		System.out.println(node.value);
		// 栈不为空持续遍历
		while (!stack.isEmpty()) {
			// 从栈弹出一个结点
			Node cur = stack.pop();
			// 遍历当前弹出结点的nexts链表
			for (Node next : cur.nexts) {
				// 如果这个结点没有遍历过则压栈
				if (!visitedSet.contains(next)) {
					// 注意把cur结点再次压栈
					stack.push(cur);
					stack.push(next);
					visitedSet.add(next);
					// 打印当前结点
					System.out.println(next.value);
					break;
				}
			}
		}
	}

}
