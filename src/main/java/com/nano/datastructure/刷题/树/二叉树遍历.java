package com.nano.datastructure.刷题.树;

import java.util.Stack;

/**
 * 二叉树的递归 非递归方式遍历
 * @author nano
 */
public class 二叉树遍历 {

    /**
     * 递归方式前序遍历
     *
     * @param head 头结点
     */
    public void preOrderRecursive(TreeNode head) {
        if (head == null) {
            return;
        }
        // 第一次到达结点时处理数据
        System.out.println(head.value + " ");
        preOrderRecursive(head.left);
        preOrderRecursive(head.right);
    }


    /**
     * 递归方式中序遍历
     *
     * @param head 头结点
     */
    public void midOrderRecursive(TreeNode head) {
        if (head == null) {
            return;
        }
        preOrderRecursive(head.left);
        // 第二次到达结点时处理数据
        System.out.println(head.value + " ");
        preOrderRecursive(head.right);
    }


    /**
     * 递归方式后序遍历
     *
     * @param head 头结点
     */
    public void postOrderRecursive(TreeNode head) {
        if (head == null) {
            return;
        }
        preOrderRecursive(head.left);
        preOrderRecursive(head.right);
        // 第三次到达结点时处理数据
        System.out.println(head.value + " ");
    }


    /**
     * 非递归方式前序遍历
     *
     * @param head 头结点
     */
    public void preOrderUnRecursive(TreeNode head) {
        if (head != null) {
            // 准备一个栈并把根节点压栈
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            // 不断从栈中弹出元素弹出时处理数据，并先将右孩子压栈再讲左孩子压栈
            while(!stack.isEmpty()) {
                // 弹出栈顶的结点
                head = stack.pop();
                // 处理数据
                System.out.println(head.value + " ");
                // 右孩子压栈
                if (head.right != null) {
                    stack.push(head.right);
                }
                // 左孩子压栈
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }

    }


    /**
     * 非递归方式中序遍历
     *
     * @param head 头结点
     */
    public void midOrderUnRecursive(TreeNode head) {

        if (head != null) {
            // 准备一个栈
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                // 持续将左子节点压栈
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    // 弹出数据处理
                    head = stack.pop();
                    // 处理数据
                    System.out.println(head.value + " ");
                    // 变到右子树
                    head = head.right;
                }
            }
        }

    }



    /**
     * 非递归方式后序遍历
     *
     * @param head 头结点
     */
    public void postOrderUnRecursive(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            // 根节点压入栈1
            s1.push(head);

            while (!s1.isEmpty()) {
                // 栈1弹出一个元素就放入栈2
                head = s1.pop();
                s2.push(head);

                // 再将弹出元素的左右子节点分别入栈
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            // 当栈1的全部元素进入栈2时 栈2依次弹出即可
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().value + "");
            }
        }

    }


}
