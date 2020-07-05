//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。 
//
// 注意：n 的值小于15000。 
//
// 示例1: 
//
// 
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
// 
//
// 示例 2: 
//
// 
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
// 
//
// 示例 3: 
//
// 
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
// 
// Related Topics 栈

package com.cheerfun.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            if (nums == null || nums.length < 3) {
                return false;
            }
            int len = nums.length;
            int[] min = new int[len];
            Deque<Integer> stack = new ArrayDeque<>(len);
            min[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                min[i] = Math.min(min[i - 1], nums[i]);
            }
            for (int i = nums.length - 1; i > 0; i --) {
                if (nums[i] > min[i]) {
                    while (!stack.isEmpty() && stack.peekLast() <= min[i]) {
                        stack.removeLast();
                    }
                    if (!stack.isEmpty() && stack.peekLast() < nums[i]) {
                        return true;
                    }
                    stack.addLast(nums[i]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}