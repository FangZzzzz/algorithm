//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划

package com.cheerfun.leetcode.editor.cn;

class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        solution.minDistance("zoologicoarchaeologist", "zoogeologist");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1 == null || word1.length() == 0) {
                if (word2 == null) {
                    return 0;
                } else {
                    return word2.length();
                }
            }
            if (word2 == null || word2.length() == 0) {
                if (word1 == null) {
                    return 0;
                } else {
                    return word1.length();
                }
            }
            int[][] dp = new int[word1.length()][word2.length()];
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) == word2.charAt(0)) {
                    dp[i][0] = i;
                } else if (i != 0) {
                    dp[i][0] = dp[i - 1][0] + 1;
                } else {
                    dp[0][0] = 1;
                }
            }

            for (int i = 0; i < word2.length(); i++) {
                if (word1.charAt(0) == word2.charAt(i)) {
                    dp[0][i] = i;
                } else if (i != 0) {
                    dp[0][i] = dp[0][i - 1] + 1;
                } else {
                    dp[0][0] = 1;
                }
            }
            for (int i = 1; i < word1.length(); i++) {
                for (int j = 1; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    }
                }
            }
            return dp[word1.length() - 1][word2.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}