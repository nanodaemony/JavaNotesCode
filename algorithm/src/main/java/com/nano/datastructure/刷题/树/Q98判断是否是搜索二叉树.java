package com.nano.datastructure.刷题.树;

import java.util.Stack;

/**
 * 搜索二叉树中序遍历是升序
 * @author nano
 */
public class Q98判断是否是搜索二叉树 {

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
        // 注意：维护一个前一个节点的值
        int preValue = Integer.MIN_VALUE;
        while(!stack.empty() || head != null){
            if(head != null){
                // 持续将左节点压入
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                // 注意：判断是否是升序
                if(preValue > head.val) return false;
                // 注意：切换前值
                preValue = head.val;
                // 将节点切换到右子结点
                head = head.right;
            }
        }
        return true;
    }


    //--------------下面是递归方法--------------

    long preValue = Long.MIN_VALUE;
    boolean isBST = true;
    public boolean isValidBST(TreeNode root) {
        // Base case
        if (root == null) return true;
        dfs(root);
        return isBST;
    }

    private void dfs(TreeNode root) {
        // 访问左子树
        isValidBST(root.left);
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= preValue) isBST = false;
        preValue = root.val;
        // 访问右子树
        isValidBST(root.right);
    }



}
