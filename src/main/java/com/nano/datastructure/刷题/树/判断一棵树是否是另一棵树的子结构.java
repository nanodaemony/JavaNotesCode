package com.nano.datastructure.刷题.树;

/**
 * 判断一棵树是否是另一棵树的子结构
 *
 * @author nano
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class 判断一棵树是否是另一棵树的子结构 {

    /**
     * 判断一棵树是否是另一棵树的子结构
     *
     * @param root1 树A
     * @param root2 树B
     * @return B是否是A的子结构
     */
    public boolean contains(TreeNode root1, TreeNode root2) {

        if (root2 == null)
            return false;

        return DFS(root1, root2);
    }

    private boolean DFS(TreeNode root1, TreeNode root2) {

        if (root1 == null)
            return false;

        if (IsSubTree(root1, root2))
            return true;

        return contains(root1.left, root2) | contains(root1.right, root2);
    }

    private boolean IsSubTree(TreeNode root1, TreeNode root2) {

        if (root2 == null)
            return true;
        else {
            if (root1 == null || root1.value != root2.value)
                return false;
            return IsSubTree(root1.left, root2.left) & IsSubTree(root1.right, root2.right);
        }
    }

}
