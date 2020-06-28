//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法

package com.cheerfun.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
        solution.isPossible(new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> nc = new HashMap<>();
            Map<Integer, Integer> tail = new HashMap<>();
            for (int num : nums) {
                nc.put(num, nc.getOrDefault(num, 0) + 1);
            }
            for (int num : nums) {
                if (nc.get(num) == 0) {
                    continue;
                } else if (tail.getOrDefault(num - 1, 0) > 0) {
                    nc.put(num, nc.get(num) - 1);
                    tail.put(num - 1, tail.get(num - 1) - 1);
                    tail.put(num, tail.getOrDefault(num, 0) + 1);
                } else if (nc.getOrDefault(num + 1, 0) > 0 && nc.getOrDefault(num + 2, 0) > 0) {
                    nc.put(num, nc.get(num) - 1);
                    nc.put(num + 1, nc.get(num + 1) - 1);
                    nc.put(num + 2, nc.get(num + 2) - 1);
                    tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}