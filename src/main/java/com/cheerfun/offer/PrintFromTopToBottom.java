package com.cheerfun.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  * @Description TODO
 *  * @Classname PrintFromTopToBottom
 *  * @Author fangzhou
 *  * @Date 2020/5/2 2:13 下午
 *  * @Version V1.0
 *  
 */
public class PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if(poll.left != null) {
                queue.offer(poll.left);
            }
            if(poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return result;
    }


}
