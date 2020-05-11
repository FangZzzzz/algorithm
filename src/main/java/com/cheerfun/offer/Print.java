package com.cheerfun.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname Print
 *  * @Author fangzhou
 *  * @Date 2020/5/5 3:33 下午
 *  * @Version V1.0
 *  
 */
public class Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                list1.add(pop.val);
                if (pop.left != null) {
                    stack2.push(pop.left);
                }
                if (pop.right != null) {
                    stack2.push(pop.right);
                }
            }
            if (!list1.isEmpty()) {
                result.add(list1);
            }

            ArrayList<Integer> list2 = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                list2.add(pop.val);
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
            }
            if (!list2.isEmpty()) {
                result.add(list2);
            }
        }
        return result;
    }

    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if (pRoot == null) {
            return listAll;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int curSize = 1;
        int nextSize = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (curSize > 0) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.offer(poll.left);
                    nextSize ++ ;
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                    nextSize ++ ;
                }
                list.add(poll.val);
                curSize --;
            }
            if (!list.isEmpty()) {
                listAll.add(list);
            }
            curSize = nextSize;
            nextSize = 0;
        }
        return listAll;
    }
}