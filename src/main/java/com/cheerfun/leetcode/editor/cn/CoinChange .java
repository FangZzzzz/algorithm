//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

package com.cheerfun.leetcode.editor.cn;

import java.util.Arrays;

class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            for (int i = 0; i < coins.length; i++) {
                if (amount >= coins[i]) {
                    dp[coins[i]] = 1;
                }
            }

            for (int i = 0; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] > 0 && dp[i - coins[j]] != -1) {
                        if(dp[i] == -1) {
                            dp[i] = dp[i - coins[j]] + 1;
                        } else {
                            dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                        }
                    }
                }
            }
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}