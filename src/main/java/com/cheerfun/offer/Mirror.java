package com.cheerfun.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  * @Description TODO
 *  * @Classname Mirror
 *  * @Author fangzhou
 *  * @Date 2020/5/1 3:29 下午
 *  * @Version V1.0
 *  
 */
public class Mirror {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }


    public void mirrorQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }

        }
    }

}
