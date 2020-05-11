package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname IsBalanced_Solution
 *  * @Author fangzhou
 *  * @Date 2020/5/4 1:54 下午
 *  * @Version V1.0
 *  
 */
public class IsBalanced_Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (getDepth(root) == -1) {
            return false;
        }
        return true;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
