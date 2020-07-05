package com.nano.datastructure.刷题.树;

import java.util.Stack;

/**
 * 二叉树的递归 非递归方式遍历
 * @author nano
 */
public class 二叉树遍历总结 {

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
        System.out.println(head.val + " ");
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
        System.out.println(head.val + " ");
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
        System.out.println(head.val + " ");
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
            // 不断从栈中弹出元素弹出时处理数据，并先将右孩子压栈再将左孩子压栈
            while(!stack.isEmpty()) {
                // 弹出栈顶的结点并处理数据
                head = stack.pop();
                System.out.println(head.val + " ");
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
            // 不把头结点压栈
            while (!stack.isEmpty() || head != null) {
                // 持续将当前结点的左子节点压栈
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                    // 压完之后进行数据处理并在处理完后变到右子树上
                } else {
                    // 弹出数据处理
                    head = stack.pop();
                    // 处理数据
                    System.out.println(head.val + " ");
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
            // 准备两个栈
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            // 根节点压入栈1
            s1.push(head);
            // 退出条件为栈1为空
            while (!s1.isEmpty()) {
                // 栈1每弹出一个元素就放入栈2
                head = s1.pop();
                s2.push(head);

                // 再将当前弹出元素的左右子节点分别入栈
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            // 当栈1为空时，依次弹出栈2就是后序遍历顺序
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().val + "");
            }
        }
    }


}
