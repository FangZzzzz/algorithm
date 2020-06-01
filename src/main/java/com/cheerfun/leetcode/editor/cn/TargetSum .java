//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 示例 1: 
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 注意: 
//
// 
// 数组非空，且长度不会超过20。 
// 初始的数组的和不会超过1000。 
// 保证返回的最终结果能被32位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划

package com.cheerfun.leetcode.editor.cn;

class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0 || S > 1000) {
                return 0;
            }
            int len = nums.length;
            int[][] dp = new int[len][2001];
            dp[0][1000 + nums[0]] = 1;
            dp[0][1000 - nums[0]] += 1;
            for (int i = 1; i < len; i++) {
                for (int j = -1000 + nums[i]; j <= 1000 - nums[i]; j++) {
                    if (dp[i - 1][j + 1000] > 0) {
                        dp[i][j + 1000 + nums[i]] += dp[i - 1][j + 1000];
                        dp[i][j + 1000 - nums[i]] += dp[i - 1][j + 1000];
                    }
                }
            }
            return dp[len - 1][1000 + S];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}