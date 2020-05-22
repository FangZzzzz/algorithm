//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

package com.cheerfun.leetcode.editor.cn;

import java.util.*;

class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> track = new LinkedList<>();
            dfs(nums, track, res);
            return res;
        }

        private void dfs(int nums[], LinkedList<Integer> track, List<List<Integer>> res) {
            if (track.size() == nums.length) {
                res.add(new ArrayList<>(track));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!track.contains(nums[i])) {
                    track.add(nums[i]);
                    dfs(nums, track, res);
                    track.removeLast();
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}