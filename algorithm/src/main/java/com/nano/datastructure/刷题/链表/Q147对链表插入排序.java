package com.nano.datastructure.刷题.链表;

/**
 * @author: nano
 * @time: 2020/7/4 21:32
 */
public class Q147对链表插入排序 {

	public ListNode insertionSortList(ListNode head) {
		// 引入dummy结点并设置值为最小值
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		ListNode move = dummyHead;
		// 指向链尾
		ListNode end = head;
		// 外层循环, 遍历非有序的链表
		while(move.next != null){
			// 当前的move结点的值与end结点的值是有序时, move和end往后移一位
			if(end.val <= move.next.val){
				end = move.next;
				move = move.next;
			} else {
				// head用来遍历有序链表, 寻找当前move结点应该插入的位置
				head = dummyHead;
				// while循环找到当前move结点的正确位置
				while(head.next.val < move.next.val && head.next != move.next){
					head = head.next;
				}
				// 当while循环结束时, head结点的下一个结点就是当前move结点应该插入的位置
				// 在正确位置将move结点插入
				temp = move.next;
				move.next = move.next.next;
				temp.next = head.next;
				head.next = temp;
			}
		}
		// 最后返回哨兵dummyHead结点的下一个结点即可
		return dummyHead.next;
	}

}
