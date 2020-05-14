package com.cheerfun.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname Tree
 *  * @Author fangzhou
 *  * @Date 2020/5/13 2:30 下午
 *  * @Version V1.0
 *  
 */
public class Tree {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode6.left = treeNode7;
        in(treeNode1);
        System.out.println("----------------------------------------------");
        inorderTraversal(treeNode1);
        System.out.println("----------------------------------------------");
        pre(treeNode1);
        System.out.println("----------------------------------------------");
        preorderTraversal(treeNode1);
        System.out.println("----------------------------------------------");
        post(treeNode1);
        System.out.println("----------------------------------------------");
        postOrderTraversa(treeNode1);
        System.out.println("----------------------------------------------");
        level(treeNode1);
    }

    public static void in(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        in(treeNode.left);
        System.out.println(treeNode.value);
        in(treeNode.right);
    }

    public static void pre(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.println(treeNode.value);
        pre(treeNode.left);
        pre(treeNode.right);
    }

    public static void post(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        post(treeNode.left);
        post(treeNode.right);
        System.out.println(treeNode.value);

    }

    public static void inorderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode cur = treeNode;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    public static void preorderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode cur = treeNode;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    public static void postOrderTraversa(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode last = new TreeNode();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (cur.left == last && cur.right == null) || last == cur.right) {
                System.out.println(cur.value);
                stack.pop();
                last = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }


    public static void level(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.value);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }
}
