//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package com.cheerfun.leetcode.editor.cn;

class LongestPalindromicSubstring {
    // todo 不会，学
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
/*        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                // 以i为中心
                int len = expandAroundCenter(s, i, i);
                len = Math.max(len, expandAroundCenter(s, i, i + 1));
                if (len > end - start + 1) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return r - l - 1;
        }*/

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            String result = "";
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int r = 0; r < s.length(); r++) {
                for (int l = 0; l <= r; l++) {
                    dp[l][r] = s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1]);
                    if (dp[l][r] && r - l + 1 > result.length()) {
                        result = s.substring(l, r + 1);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}