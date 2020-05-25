//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划

package com.cheerfun.leetcode.editor.cn;

class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * G(n)为n个节点可组成搜索二叉树的个数
         * F(i,n) 以i为根节点的n个节点可组成的二叉树的个数
         * G(n) = F（1,n) + ... + f(n,n)
         * F(i,n) = G(i-1) * G(n-i)
         *
         * @param n
         * @return
         */
        public int numTrees(int n) {
            int[] g = new int[n + 1];
            g[0] = g[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    g[i] += g[j - 1] * g[i - j];
                }
            }
            return g[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}