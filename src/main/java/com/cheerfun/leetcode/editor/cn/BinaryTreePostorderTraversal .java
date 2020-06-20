//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package com.cheerfun.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode last = new TreeNode(-1);
            stack.addLast(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peekLast();
                if ((cur.left == null && cur.right == null) || cur.right == last ||
                        (cur.right == null && cur.left == last)) {
                    result.add(cur.val);
                    stack.removeLast();
                    last = cur;
                } else {
                    if (cur.right != null) {
                        stack.addLast(cur.right);
                    }
                    if (cur.left != null) {
                        stack.addLast(cur.left);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}