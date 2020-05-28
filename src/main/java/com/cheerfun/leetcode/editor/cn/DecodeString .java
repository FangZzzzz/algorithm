//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索

package com.cheerfun.leetcode.editor.cn;

import java.util.LinkedList;

class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        String s = solution.decodeString("3[a]2[bc]");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            StringBuilder sb = new StringBuilder();
            if (s == null || s.length() == 0) {
                return sb.toString();
            }
            LinkedList<String> stack = new LinkedList<>();
            int i = 0;
            while (i < s.length()) {
                char curCh = s.charAt(i);
                if (Character.isDigit(curCh)) {
                    StringBuilder num = new StringBuilder();
                    while (Character.isDigit(s.charAt(i))) {
                        num.append(s.charAt(i++));
                    }
                    stack.addLast(num.toString());
                } else if ('[' == curCh || Character.isLetter(curCh)) {
                    stack.addLast(String.valueOf(s.charAt(i++)));
                } else {
                    i++;
                    StringBuilder curStrBuilder = new StringBuilder();
                    LinkedList<String> curStrings = new LinkedList<>();
                    while (!"[".equals(stack.peekLast())) {
                        curStrings.add(stack.removeLast());
                    }
                    // 删除'['
                    stack.removeLast();
                    // 拿到倍数
                    int count = Integer.parseInt(stack.removeLast());
                    for (int j = curStrings.size() - 1; j >= 0; j--) {
                        curStrBuilder.append(curStrings.get(j));
                    }
                    String curString = curStrBuilder.toString();
                    for (int j = 0 ; j < count - 1 ; j ++) {
                        curStrBuilder.append(curString);
                    }
                    stack.addLast(curStrBuilder.toString());
                }
            }
            while(!stack.isEmpty()) {
                sb.append(stack.removeFirst());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}