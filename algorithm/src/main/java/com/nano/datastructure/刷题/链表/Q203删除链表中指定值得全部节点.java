package com.nano.datastructure.刷题.链表;

/**
 * 给定一个值删除链表中所有含有这个值得节点
 * @author nano
 */
public class Q203删除链表中指定值得全部节点 {

    public ListNode removeElements(ListNode head, int val) {
        // Base case
        if(head == null) return head;
        // 可能删除头结点，引入dummy节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 遍历一次链表即可
        while (head != null) {
            // 如果是还要的结点就接到dummy后面
            if (head.val != val) {
                cur.next = head;
                head = head.next;
                cur = cur.next;
                cur.next = null;
                // 值相同直接不管了
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

}
