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
     * @param root 头结点
     */
    public void preOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        // 第一次到达结点时处理数据
        System.out.println(root.val + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }


    /**
     * 递归方式中序遍历
     *
     * @param root 头结点
     */
    public void midOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderRecursive(root.left);
        // 第二次到达结点时处理数据
        System.out.println(root.val + " ");
        preOrderRecursive(root.right);
    }


    /**
     * 递归方式后序遍历
     *
     * @param root 头结点
     */
    public void postOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
        // 第三次到达结点时处理数据
        System.out.println(root.val + " ");
    }


    /**
     * 非递归方式前序遍历
     *
     * @param root 头结点
     */
    public void preOrderUnRecursive(TreeNode root) {
        if (root != null) {
            // 准备一个栈并把根节点压栈
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            // 不断从栈中弹出元素弹出时处理数据，并先将右孩子压栈再将左孩子压栈
            while(!stack.isEmpty()) {
                // 弹出栈顶的结点并处理数据
                root = stack.pop();
                System.out.println(root.val + " ");
                // 右孩子压栈
                if (root.right != null) {
                    stack.push(root.right);
                }
                // 左孩子压栈
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }


    /**
     * 非递归方式中序遍历
     *
     * @param root 头结点
     */
    public void midOrderUnRecursive(TreeNode root) {

        if (root != null) {
            // 准备一个栈
            Stack<TreeNode> stack = new Stack<>();
            // 不把头结点压栈
            while (!stack.isEmpty() || root != null) {
                // 持续将当前结点的左子节点压栈
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                    // 压完之后进行数据处理并在处理完后变到右子树上
                } else {
                    // 弹出数据处理
                    root = stack.pop();
                    // 处理数据
                    System.out.println(root.val + " ");
                    // 变到右子树
                    root = root.right;
                }
            }
        }
    }



    /**
     * 非递归方式后序遍历
     *
     * @param root 头结点
     */
    public void postOrderUnRecursive(TreeNode root) {
        if (root != null) {
            // 准备两个栈
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            // 根节点压入栈1
            s1.push(root);
            // 退出条件为栈1为空
            while (!s1.isEmpty()) {
                // 栈1每弹出一个元素就放入栈2
                root = s1.pop();
                s2.push(root);

                // 再将当前弹出元素的左右子节点分别入栈
                if (root.left != null) {
                    s1.push(root.left);
                }
                if (root.right != null) {
                    s1.push(root.right);
                }
            }
            // 当栈1为空时，依次弹出栈2就是后序遍历顺序
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().val + "");
            }
        }
    }


}
