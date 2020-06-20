//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索

package com.cheerfun.leetcode.editor.cn;


class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public void flatten(TreeNode root) {
            // 把根的右子树 移植到左子树的右子树上
            // 然后把根的左子树变成右子树
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                } else {
                    TreeNode pre = root.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = root.right;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}