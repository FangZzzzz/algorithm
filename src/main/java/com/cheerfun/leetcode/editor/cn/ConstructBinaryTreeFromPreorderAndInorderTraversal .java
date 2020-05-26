//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

package com.cheerfun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
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


        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            Map<Integer, Integer> inMap = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            return buildTreeD(preorder, 0, preorder.length - 1, 0, inMap);
        }

        public TreeNode buildTreeD(int[] pre, int preI, int preJ, int inI, Map<Integer, Integer> inMap) {
            if (preI > preJ) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preI]);
            int inPoint = inMap.get(pre[preI]);
            root.left = buildTreeD(pre, preI + 1, preI + inPoint - inI, inI, inMap);
            root.right = buildTreeD(pre, preI + inPoint - inI + 1, preJ, inPoint + 1, inMap);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}