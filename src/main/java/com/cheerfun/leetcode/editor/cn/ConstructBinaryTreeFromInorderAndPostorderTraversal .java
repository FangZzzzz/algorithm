//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组

package com.cheerfun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(postorder, 0, postorder.length - 1, 0, map);
        }

        private TreeNode buildTree(int[] postOrder, int pStart, int pEnd, int iStart, Map<Integer, Integer> map) {
            if (pStart > pEnd) {
                return null;
            }
            TreeNode root = new TreeNode(postOrder[pEnd]);
            int rootIndex = map.get(postOrder[pEnd]);
            root.left = buildTree(postOrder, pStart, pStart + rootIndex - iStart - 1, iStart, map);
            root.right = buildTree(postOrder, pStart + rootIndex - iStart, pEnd - 1, rootIndex + 1, map);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}