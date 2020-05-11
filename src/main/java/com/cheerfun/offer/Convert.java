package com.cheerfun.offer;

import java.util.Stack;

/**
 *  * @Description TODO
 *  * @Classname Convert
 *  * @Author fangzhou
 *  * @Date 2020/5/2 3:44 下午
 *  * @Version V1.0
 *  
 */
public class Convert {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        toList(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode preNode = null;
        TreeNode cur = pRootOfTree;
        TreeNode head = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur.left = preNode;
            if (preNode != null) {
                preNode.right = cur;
            } else {
                head = cur;
            }
            preNode = cur;
            cur = cur.right;
        }
        return head;
    }

    public void toList(TreeNode cur) {
        if (cur == null) {
            return;
        }
        toList(cur.left);
        cur.left = pre;
        if (pre != null) {
            pre.right = cur;
        }
        pre = cur;
        toList(cur.right);
    }
}
