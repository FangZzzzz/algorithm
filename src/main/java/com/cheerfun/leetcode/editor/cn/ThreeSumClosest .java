//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针

package com.cheerfun.leetcode.editor.cn;

class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }
            int closestNum = nums[0] + nums[1] + nums[2];
            quickSort(nums, 0, nums.length - 1);
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int temp = nums[i] + nums[l] + nums[r];
                    if (Math.abs(temp - target) < Math.abs(closestNum - target)) {
                        closestNum = temp;
                    }
                    if (temp < target) {
                        l++;
                    } else if (temp > target) {
                        r--;
                    } else {
                        return closestNum;
                    }
                }
            }
            return closestNum;

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