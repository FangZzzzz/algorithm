//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组

package com.cheerfun.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            int result = 0;
            if (nums == null || nums.length == 0) {
                return result;
            }
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int num : nums) {
                // 存在num-1表示已经遍历过了
                if (!set.contains(num - 1)) {
                    int curNum = num;
                    int curMax = 1;
                    while (set.contains(curNum + 1)) {
                        curNum += 1;
                        curMax += 1;
                    }
                    result = Math.max(result, curMax);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}