package com.nano.datastructure.刷题.链表;

import java.util.Stack;

/**
 * 判断单向链表是不是回文结构
 * @author nano
 */
public class 判断链表是否是回文结构 {

    /**
     * 判断单向链表是否是回文结构--使用栈
     *
     * @param head 链表头部
     * @return 是否回文结构
     */
    private static boolean isPalindromeListUsingStack(ListNode head) {
        if (head == null) {
            return false;
        }
        // 利用栈
        Stack<ListNode> stack = new Stack<>();
        // 将节点全部压栈
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // 元素逐个弹出与链表顺序一一比较
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }






}
