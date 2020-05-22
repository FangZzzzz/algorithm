//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

package com.cheerfun.leetcode.editor.cn;

class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = -1;
            result[1] = -1;
            if (nums == null || nums.length == 0) {
                return result;
            }
            result[0] = getLeft(nums, target);
            result[1] = getRight(nums, target);
            return result;
        }

        private int getLeft(int nums[], int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= target) {
                    r = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                }
            }
            if (l >= nums.length || nums[l] != target) {
                return -1;
            }
            return l;
        }

        private int getRight(int nums[], int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] <= target) {
                    l = mid + 1;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                }
            }
            if (r < 0 || nums[r] != target) {
                return -1;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}