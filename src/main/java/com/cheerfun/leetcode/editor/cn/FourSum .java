//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针

package com.cheerfun.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new LinkedList<>();
            if (nums == null || nums.length < 4) {
                return result;
            }
            quickSort(nums, 0, nums.length - 1);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int temp = nums[i] + nums[j];
                    int l = j + 1, r = nums.length - 1;
                    while (l < r) {
                        int sum = temp + nums[l] + nums[r];
                        if (target > sum) {
                            l++;
                        } else if (target < sum) {
                            r--;
                        } else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            l++;
                            r--;
                        }
                    }
                }
            }
            return result;
        }

        private void quickSort(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int point = nums[start];
            int l = start, r = end;
            while (l < r) {
                while (l < r && nums[r] > point) {
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }
                while (l < r && nums[l] < point) {
                    l++;
                }
                if (l < r) {
                    nums[r--] = nums[l];
                }
            }
            nums[l] = point;
            quickSort(nums, start, l - 1);
            quickSort(nums, l + 1, end);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}