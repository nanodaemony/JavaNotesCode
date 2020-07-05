package com.nano.datastructure.刷题.链表;

/**
 * 给定一个值删除链表中所有含有这个值得节点
 * @author nano
 */
public class Q203删除链表中指定值得全部节点 {

    public ListNode removeElements(ListNode head, int val) {
        // Base case
        if(head == null) {
            return head;
        }
        // 可能删除头结点，引入dummy节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        // 遍历一次链表即可
        while(cur != null && cur.next != null) {
            // 如果下一个结点的值与给定值相等，则跳过下一个结点
            // 此时cur指针不动，这是为了应对几个需要删除的结点连在一起
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                // 如果不是要删的就直接移动cur指针即可
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
