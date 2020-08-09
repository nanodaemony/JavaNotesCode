package com.nano.datastructure.刷题.剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: nano
 * @time: 2020/7/2 13:22
 */
public class Q37序列化二叉树 {


	// 前序遍历方式序列化
	public String serialize(TreeNode root) {
		if (root == null) return "#";
		// 递归构造
		return root.val + " " + serialize(root.left) + " " + serialize(root.right);
	}

	private String str;

	public TreeNode deserialize(String str) {
		this.str = str;
		return deserialize();
	}

	// 反序列化为二叉树
	private TreeNode deserialize() {
		// Base case
		if (str.length() == 0) return null;
		// 找到下一个结点的值
		int index = str.indexOf(" ");
		String nodeString = index == -1 ? str : str.substring(0, index);
		// 更新原始的反序列化字符串
		str = index == -1 ? "" : str.substring(index + 1);
		// 如果是#代表是null值
		if ("#".equals(nodeString)) return null;
		int val = Integer.parseInt(nodeString);
		TreeNode t = new TreeNode(val);
		// 递归解析左右子结点
		t.left = deserialize();
		t.right = deserialize();
		// 然后返回自己
		return t;
	}


	//------------------迭代层序方式--------------------------

	public String serialize2(TreeNode root) {
		if (root == null) return "";
		StringBuilder res = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				res.append(node.val + "#");
				// 这里即使是空节点也需要加进去
				queue.add(node.left);
				queue.add(node.right);
			} else res.append("null#");
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}

	public TreeNode deserialize2(String data) {
		if (data.length() == 0) return null;
		// 拆分成结点值
		String[] vals = data.split("#");
		// 构造根结点
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty()) {
			// 弹出根结点
			TreeNode node = queue.poll();
			// 不断设置其左右结点
			if (!"null".equals(vals[i])) {
				node.left = new TreeNode(Integer.parseInt(vals[i]));
				queue.add(node.left);
			}
			i++;
			if (!"null".equals(vals[i])) {
				node.right = new TreeNode(Integer.parseInt(vals[i]));
				queue.add(node.right);
			}
			i++;
		}
		return root;
	}


}
