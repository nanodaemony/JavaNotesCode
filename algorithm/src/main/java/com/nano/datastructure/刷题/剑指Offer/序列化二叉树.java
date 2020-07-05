package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/2 13:22
 */
public class 序列化二叉树 {

	private String deserializeStr;

	// 前序遍历方式序列化
	public String Serialize(TreeNode root) {
		if (root == null)
			return "#";
		return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
	}

	public TreeNode Deserialize(String str) {
		deserializeStr = str;
		return Deserialize();
	}

	// 反序列化为二叉树
	private TreeNode Deserialize() {
		// Base case
		if (deserializeStr.length() == 0) return null;
		// 找到下一个结点的值
		int index = deserializeStr.indexOf(" ");
		String nodeString = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
		// 更新原始的反序列化字符串
		deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
		// 如果是#代表是null值
		if (nodeString.equals("#")) return null;
		int val = Integer.parseInt(nodeString);
		TreeNode t = new TreeNode(val);
		// 递归解析左右子结点
		t.left = Deserialize();
		t.right = Deserialize();
		// 然后返回自己
		return t;
	}


}
