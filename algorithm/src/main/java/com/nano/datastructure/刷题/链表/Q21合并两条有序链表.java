package com.nano.datastructure.刷题.链表;

public class Q21合并两条有序链表 {

    // 处理输入
    public static void main(String[] args) {


    }


    /**
     * 合并两个有序链表 递归版本
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }

        ListNode head = null;
        if (head1.val <= head2.val) {
            head = head1;
            head.next = mergeTwoLists(head1.next, head2);
        } else {
            head = head2;
            head.next = mergeTwoLists(head1, head2.next);
        }
        return head;
    }


    /**
     *     * 非递归方式
     *     *
     *     * @param head1 有序单链表1
     *     * @param head2 有序单链表2
     *     * @return 合并后的单链表
     *    
     */
    public static ListNode mergeTwoList2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        // 合并后单链表头结点
        ListNode head = head1.val < head2.val ? head1 : head2;

        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;

        ListNode pre = null;// cur1前一个元素
        ListNode next = null;// cur2的后一个元素

        while (cur1 != null && cur2 != null) {
        // 第一次进来肯定走这里
            if (cur1.val <= cur2.val) {
                pre = cur1;

                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

}
