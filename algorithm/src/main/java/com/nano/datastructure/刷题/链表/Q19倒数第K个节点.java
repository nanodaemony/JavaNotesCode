package com.nano.datastructure.刷题.链表;


public class Q19倒数第K个节点 {



    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 引入Dummy结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // First指针先走N步
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 当第一个First指针到达null时，停止
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // 此时Second指针的下一个结点就是需要删除的结点
        second.next = second.next.next;
        return dummy.next;
    }

}
