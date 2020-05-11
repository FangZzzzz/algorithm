package com.cheerfun.offer;

import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname KthNode
 *  * @Author fangzhou
 *  * @Date 2020/5/6 9:00 下午
 *  * @Version V1.0
 *  
 */
public class KthNode {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode cur = pRoot;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (k == ++index) {
                return cur;
            }
            cur = cur.right;
        }
        return null;
    }
}
