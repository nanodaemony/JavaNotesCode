package com.nano.datastructure.刷题.链表;

public class 合并两条有序链表 {

    // 处理输入
    public static void main(String[] args) {


    }


    /**
     * 合并两个有序链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node head = null;
        if (l1.value <= l2.value){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

}
