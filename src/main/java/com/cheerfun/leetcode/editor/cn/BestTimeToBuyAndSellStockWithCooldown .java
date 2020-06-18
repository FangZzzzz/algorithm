//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划

package com.cheerfun.leetcode.editor.cn;

class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int dpI0 = 0, dpI1 = -prices[0], dpPre0 = 0;
            for (int i = 1; i < prices.length; i++) {
                int temp = dpI0;
                // 昨天没有持有，昨天持有了
                dpI0 = Math.max(dpI0, dpI1 + prices[i]);
                // 昨天持有了，前天没持有
                dpI1 = Math.max(dpI1, dpPre0 - prices[i]);
                dpPre0 = temp;
            }
            return dpI0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}