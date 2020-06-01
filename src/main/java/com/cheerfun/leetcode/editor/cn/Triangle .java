//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

package com.cheerfun.leetcode.editor.cn;

import java.util.List;

class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) {
                return 0;
            }
            int size = triangle.size();
            int[][] dp = new int[size][size];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == i) {
                        dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                    }
                }
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                result = Math.min(result, dp[size - 1][i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}