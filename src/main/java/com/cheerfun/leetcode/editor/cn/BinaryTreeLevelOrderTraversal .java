//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

package com.cheerfun.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            q1.offer(root);
            while (!q1.isEmpty() || !q2.isEmpty()) {
                List<Integer> list1 = new LinkedList<>();
                while (!q1.isEmpty()) {
                    TreeNode cur = q1.poll();
                    list1.add(cur.val);
                    if (cur.left != null) {
                        q2.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q2.offer(cur.right);
                    }
                }
                if (!list1.isEmpty()) {
                    result.add(list1);
                }
                List<Integer> list2 = new LinkedList<>();
                while (!q2.isEmpty()) {
                    TreeNode cur = q2.poll();
                    list2.add(cur.val);
                    if (cur.left != null) {
                        q1.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q1.offer(cur.right);
                    }
                }
                if (!list2.isEmpty()) {
                    result.add(list2);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}