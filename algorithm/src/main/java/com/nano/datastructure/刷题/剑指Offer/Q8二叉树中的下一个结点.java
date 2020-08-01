package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/30 13:11
 */
public class Q8二叉树中的下一个结点 {


	public Node GetNext(Node pNode) {
		// 如果右子树不为空
		if (pNode.right != null) {
			// 找右子树最左的节点并返回
			Node node = pNode.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;

			// 否则向上找第一个左链接指向的树包含该节点的祖先节点
		} else {
			// 这里是排除当前节点是最后一个节点的情况
			while (pNode.next != null) {
				// 得到父节点
				Node parent = pNode.next;
				// 如果当前节点是其父节点的左节点就是找到了
				if (parent.left == pNode)
					return parent;
				// 否则继续向父节点查找
				pNode = pNode.next;
			}
		}
		// 没找到说明是最后一个节点，返回null
		return null;
	}


	private static class Node {

		int val;
		Node left = null;
		Node right = null;
		Node next = null;

		Node(int val) {
			this.val = val;
		}
	}

}
