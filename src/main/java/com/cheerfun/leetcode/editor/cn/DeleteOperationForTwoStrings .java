//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串

package com.cheerfun.leetcode.editor.cn;

class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new DeleteOperationForTwoStrings().new Solution();
        System.out.println(solution.minDistance("sea", "eat"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1 == null && word2 == null) {
                return 0;
            }
            if (word1 == null || word1.length() == 0) {
                return word2.length();
            }
            if (word2 == null || word2.length() == 0) {
                return word1.length();
            }
            int n = word1.length(), m = word2.length();
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                if (word1.charAt(i) == word2.charAt(0)) {
                    dp[i][0] = 1;
                } else if (i == 0) {
                    dp[0][0] = 0;
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
            for (int i = 0; i < m; i++) {
                if (word1.charAt(0) == word2.charAt(i)) {
                    dp[0][i] = 1;
                } else if (i == 0) {
                    dp[0][0] = 0;
                } else {
                    dp[0][i] = dp[0][i - 1];
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
            }
            return n + m - dp[n - 1][m - 1] * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}