package com.nano.datastructure.刷题.树;

import java.util.Stack;

/**
 * 搜索二叉树中序遍历是升序
 * @author nano
 */
public class 判断是否是搜索二叉树 {

    /**
     * 是否是搜索二叉树 使用非递归中序遍历
     *
     * @param head 头结点
     * @return 是否搜索二叉树
     */
    public boolean isBinarySearchTree(TreeNode head) {

        if(head == null) return true;
        // 用了栈来实现中序遍历的非递归实现
        Stack<TreeNode> stack = new Stack<>();
        int preNode = Integer.MIN_VALUE;

        while(!stack.empty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                // 判断是否是升序
                if(preNode > head.value){
                    return false;
                }
                preNode = head.value;
                head = head.right;
            }
        }
        return true;
    }


}
