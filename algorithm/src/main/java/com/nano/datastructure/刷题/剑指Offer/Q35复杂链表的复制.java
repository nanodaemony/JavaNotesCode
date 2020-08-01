package com.nano.datastructure.刷题.剑指Offer;

/**
 * @author: nano
 * @time: 2020/7/30 12:42
 */
public class Q35复杂链表的复制 {

	public Node copyRandomList(Node pHead) {
		if (pHead == null) return null;
		// 挨着插入新节点
		Node cur = pHead;
		while (cur != null) {
			Node newNode = new Node(cur.val);
			// 将新节点插入原始链表中
			newNode.next = cur.next;
			cur.next = newNode;
			cur = newNode.next;
		}
		// 建立random链接
		cur = pHead;
		while (cur != null) {
			Node newNode = cur.next;
			if (cur.random != null)
				newNode.random = cur.random.next;
			cur = newNode.next;
		}
		// 拆分
		cur = pHead;
		Node cloneHead = pHead.next;
		while (cur.next != null) {
			Node next = cur.next;
			cur.next = next.next;
			cur = next;
		}
		return cloneHead;
	}



	private static class Node {
		int val;
		Node next = null;
		Node random = null;

		Node(int val) {
			this.val = val;
		}
	}


}


