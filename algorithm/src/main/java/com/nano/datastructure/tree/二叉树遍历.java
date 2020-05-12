package com.nano.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 二叉树遍历 {


    public static void main(String[] args) {
        preorderTraversal(new TreeNode(3));
    }


    public static List<Integer> preorderTraversal(TreeNode root) {



        List<List<Integer>> da = new ArrayList<>();
        Collections.reverse(da);
        if(root == null) {
            return null;
        }
        // Use stack
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList();
        stack.push(root);
        while(stack.isEmpty()) {
            TreeNode cur = stack.pop();
            resList.add(cur.val);
            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }
        }
        return resList;

    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Base case
        if(root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        // 根节点入队列
        queue.add(root);
        List<List<Integer>> resList = new ArrayList();
        // 队列为空时推退出循环
        while(queue.size() != 0) {
            // 获取当前队列中的元素个数，也就是当前这一层有多少个结点
            int len = queue.size();
            List<Integer> levelList = new ArrayList();
            // 将当前层的元素依次出队列并处理数据，每弹出一个结点并再次将其左右子节点入队列
            for(int i = 0; i < len; i++) {
                // 出队列并处理数据
                TreeNode temp = queue.poll();
                levelList.add(temp.val);
                // 将出队结点的左右子节点入队
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            // 这一层弹出的元素处理完毕
            resList.add(levelList);
            // 此时下一层的全部节点已经到队列中，再次循环即可
        }

        Collections.reverse(resList);
        return resList;
    }

}
