package com.nano.datastructure.面试.链表题目;

/**
 * @author: nano
 * @time: 2020/8/20 16:28
 */
public class 复制带有随机指针的链表 {


	public Node copyRandomList(Node head) {
		// Base case
		if (head == null) return null;
		// 将每个节点复制到下一个结点
		Node cur = head;
		while (cur != null) {
			Node temp = new Node(cur.val);
			temp.next = cur.next;
			cur.next = temp;
			cur = cur.next.next;
		}
		// 复制随机指针
		cur = head;
		while (cur != null) {
			// 随机指针为空的不管
			if (cur.random != null) {
				// 拷贝当前节点的随机指针的指向
				cur.next.random = cur.random.next;
			}
			// 移动两步
			cur = cur.next.next;
		}
		// 将两条链表完全拆分
		cur = head;
		Node copHead = cur.next;
		Node copyCur = copHead;
		while (copyCur.next != null) {
			// 移动原链表指针
			cur.next = cur.next.next;
			cur = cur.next;
			// 移动复制链表指针
			copyCur.next = copyCur.next.next;
			copyCur = copyCur.next;
		}
		// 结束标志null
		cur.next = null;
		return copHead;
	}


	class Node {
		int val;
		Node next;
		// 随机指针
		Node random;
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
