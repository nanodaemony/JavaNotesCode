package com.nano.datastructure.刷题.链表;

import java.util.Stack;

/**
 * 有两个链表可以当成两个数字，求两个对应的数字相加形成的结果链表
 * @author nano
 */
public class 两个链表当成数字相加生成新链表 {

    public static Node addTwoListWithSatck(Node head1, Node head2) {
        // 初始化两个栈并把链表压栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.value);
            head2 = head2.next;
        }
        // 记录进位 0-无进位 1-有进位
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        // 不断弹栈
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            // 求两个位置的和并判断是否有进位
            n = n1 + n2 + ca;
            pre = node;
            // 只记录个位
            node = new Node(n % 10);
            node.next = pre;
            // 记录进位信息
            ca = n / 10;
        }
        // 当两个栈都弹完看看进位信息是否为1 是则还需要再加一个结点
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }




}
