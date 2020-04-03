package com.nano.datastructure.刷题.树;

/**
 * 判断一棵树是否是对称二叉树
 */
public class 判断是否是对称二叉树 {


    boolean isSymmetrical(TreeNode head) {
        if(head == null){
            return true;
        }
        return check(head.left, head.right);
    }

    boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if ((left == null&& right != null) ||
                  (left != null && right == null) ||
                  (left.value != right.value)){
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

}
