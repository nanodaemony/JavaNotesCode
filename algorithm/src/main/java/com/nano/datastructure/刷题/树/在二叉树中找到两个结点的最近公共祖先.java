package com.nano.datastructure.刷题.树;

/**
 * 在二叉树中找到两个结点的最近公共祖先
 */
public class 在二叉树中找到两个结点的最近公共祖先 {


    /**
     * 寻找两个结点的最近公共祖先
     *
     * @param head 头结点
     * @param o1 结点1
     * @param o2 结点2
     * @return 最近公共祖先
     */
    public TreeNode lowestAncestor(TreeNode head, TreeNode o1, TreeNode o2) {

        if (head == null || head == o1 || head == o2) {
            return head;
        }

        TreeNode left = lowestAncestor(head.left, o1, o2);
        TreeNode right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }


}
