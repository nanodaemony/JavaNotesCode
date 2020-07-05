package com.nano.datastructure.刷题.链表;

/**
 * ① 首先判断链表是否有环
 */
public class 两个链表相交的一系列问题 {


    /**
     * 判断一个链表是否有环
     *
     * @param head 头结点
     * @return 有则返回第一个进入环的节点 无环则返回null
     */
    public static ListNode getFirstEnterLoopNode(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        // 初始化时就走一次 让两个指针错开，不然进不了while循环
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != slow) {

            // 说明快指针到达链尾无环
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 快指针重回头部
        fast = head;
        // 此时快慢指针同时运动且快慢指针都一次动一步
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }







}
