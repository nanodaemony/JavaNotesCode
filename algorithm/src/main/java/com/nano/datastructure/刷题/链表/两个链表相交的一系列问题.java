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
    public static Node getFirstEnterLoopNode(Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        // 初始化时就走一次 让两个指针错开，不然进不了while循环
        Node fast = head.next.next;
        Node slow = head.next;

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


    /**
     * 判断两个无环链表是否相交
     *
     * @param head1 链表1
     * @param head2 链表2
     * @return 相交的节点或null
     */
    public static Node isTwoListMeet(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 记录长度
        int length1 = 0;
        int length2 = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        // 寻找长度 并让temp1和temp2各自到链尾部
        while (temp1.next != null) {
            temp1 = temp1.next;
            length1++;
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
            length2++;
        }
        // 先比较尾部两个指针 如果不相同则肯定不相交
        if (temp1 != temp2) {
            return null;
        }

        // 此处是让temp1时钟指向较长的一根链表 temp2指向较短的链表
        temp1 = (length1 - length2 > 0) ? head1 : head2;
        temp2 = (temp1 == head1) ? head2 : head1;
        // 求两个链表的长度差
        int gap = Math.abs(length1 - length2);
        // 链表长的temp1先走gap步
        while (gap != 0) {
            temp1 = temp1.next;
            gap--;
        }
        // 两个链表同时运动找第一个相同的点
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }




}
