//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

package com.cheerfun.leetcode.editor.cn;

import java.util.Arrays;

class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS_02(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int result = 1;
            int len = nums.length;
            // 以nums[i]结尾的上升子序列的长度
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        result = Math.max(result, dp[i]);
                    }
                }
            }
            return result;
        }

        public int lengthOfLIS_03(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int[] dp = new int[n];
            int max = 1;
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        max = Math.max(dp[i], max);
                    }
                }
            }
            return max;
        }

        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            // 定义 长度为i的上升子序列，最小的尾数是dp[i];
            int[] dp = new int[len];
            dp[0] = nums[0];
            int result = 0;
            for (int i = 1; i < nums.length; i++) {
                if (dp[result] < nums[i]) {
                    dp[++result] = nums[i];
                } else {
                    int start = 0, end = result - 1;
                    while (start <= end) {
                        int mid = start + (end - start) / 2;
                        if (dp[mid] < nums[i]) {
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    }
                    dp[start] = nums[i];
                }
            }
            return result + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}