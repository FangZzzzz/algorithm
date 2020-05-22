//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划

package com.cheerfun.leetcode.editor.cn;

class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        solution.numDecodings("27");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') {
                return 0;
            }
            int pre = 1, cur = 1;
            for (int i = 1; i < s.length(); i++) {
                char preCh = s.charAt(i - 1);
                char curCh = s.charAt(i);
                int temp = cur;
                if (curCh == '0') {
                    if (preCh == '1' || preCh == '2') {
                        cur = pre;
                    } else {
                        return 0;
                    }
                } else if(preCh == '1' || preCh == '2' && curCh >= '1' && curCh <= '6') {
                    cur = cur + pre;
                }
                pre = temp;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}