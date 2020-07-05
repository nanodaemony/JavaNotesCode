package com.nano.datastructure.刷题.树;

import java.util.List;

/**
 * 多叉树结点
 *
 * @author: nano
 * @time: 2020/7/5 14:32
 */
public class Node {
	public int val;

	public List<Node> children;

	public Node() {}

	public Node(int val) {
		this.val = val;
	}

	public Node(int val, List<Node> children) {
		this.val = val;
		this.children = children;
	}
};
