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
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 其中一个为null返回另一条
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        // 引入dummy结点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 都不为null进行
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                ListNode temp = l1;
                l1 = l1.next;
                temp.next = null;
                cur.next = temp;
            } else {
                ListNode temp = l2;
                l2 = l2.next;
                temp.next = null;
                cur.next = temp;
            }
            cur = cur.next;
        }
        // 到这里说明有一个为null了，连接上即可
        if(l1 == null) cur.next = l2;
        if(l2 == null) cur.next = l1;
        return dummy.next;
    }

}
