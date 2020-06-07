//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

package com.cheerfun.leetcode.editor.cn;

class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            quickSort(nums, 0, nums.length - 1);
            int sum = 0, pre = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == pre) {
                    sum++;
                    if (sum > nums.length / 2) {
                        return pre;
                    }
                } else {
                    pre = nums[i];
                    sum = 1;
                }
            }
            return pre;
        }

        private void quickSort(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int l = start, r = end;
            int point = nums[l];
            while (l < r) {
                while (nums[r] >= point && l < r) {
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }
                while (nums[l] <= point && l < r) {
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