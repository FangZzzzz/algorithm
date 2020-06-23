//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树

package com.cheerfun.leetcode.editor.cn;

class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode.left = treeNode3;
        treeNode.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode6.right = treeNode7;
        solution.deleteNode(treeNode, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return root;
            }
            TreeNode parent = null;
            TreeNode cur = root;
            while (cur != null) {
                if (cur.val == key) {
                    break;
                } else if (cur.val < key) {
                    parent = cur;
                    cur = cur.right;
                } else {
                    parent = cur;
                    cur = cur.left;
                }
            }
            if (cur == null) {
                return root;
            }
            if (cur.left == null && cur.right == null) {
                if (cur == root) {
                    root = null;
                } else if (cur == parent.left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (cur.left != null && cur.right == null) {
                if (cur == root) {
                    root = cur.left;
                } else if (cur == parent.left) {
                    parent.left = cur.left;
                } else {
                    parent.right = cur.left;
                }
            } else if (cur.right != null && cur.left == null) {
                if (cur == root) {
                    root = cur.right;
                } else if (cur == parent.left) {
                    parent.left = cur.right;
                } else {
                    parent.right = cur.right;
                }
            } else {
                TreeNode maxLeft = cur.left;
                while (maxLeft.right != null) {
                    maxLeft = maxLeft.right;
                }
                maxLeft.right = cur.right;
                if (cur == root) {
                    root = cur.left;
                } else if (cur == parent.left) {
                    parent.left = cur.left;
                } else {
                    parent.right = cur.left;
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}