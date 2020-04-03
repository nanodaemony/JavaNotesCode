package com.nano.datastructure.刷题.链表;


public class 倒数第K个节点 {



    public Node FindKthToTail(Node head,int k) {
        // 边界条件
        if(head == null) {
            return null;
        }
        int length = 0;
        // 引用当前头结点
        Node current = head;
        // 求链表长度
        while(head != null) {
            head = head.next;
            length++;
        }

        // 找到从正数的长度gap
        int gap = length - k;
        // gap小于0则说明倒数第K个不存在\
        if(gap < 0) {
            return null;
        }
        // 从正向移动gap步到达倒数第K个结点
        while(gap != 0){
            current = current.next;
            gap--;
        }
        return current;
    }

}
