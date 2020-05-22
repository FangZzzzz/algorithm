//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

package com.cheerfun.leetcode.editor.cn;

import java.util.*;

class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new LinkedList<>();
            if (candidates == null || candidates.length == 0) {
                return result;
            }
            Arrays.sort(candidates);
            combinationSumDFS(candidates, 0, target, result, new LinkedList<>());
            return result;
        }

        private void combinationSumDFS(int[] candidates, int begin, int target, List<List<Integer>> result, Deque<Integer> path) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
            }
            for (int i = begin; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                path.add(candidates[i]);
                combinationSumDFS(candidates, i, target - candidates[i], result, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}