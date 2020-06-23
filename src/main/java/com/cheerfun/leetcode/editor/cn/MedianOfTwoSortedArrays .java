//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package com.cheerfun.leetcode.editor.cn;

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        solution.findMedianSortedArrays(new int[]{2, 3, 5}, new int[]{1, 4, 7, 9});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = 0, m = 0;
            if (nums1 != null) {
                n = nums1.length;
            }
            if (nums2 != null) {
                m = nums2.length;
            }
            if (n > m) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int l1 = 0, l2 = 0, r1 = 0, r2 = 0, c2 = 0, l = 0, r = n * 2;
            while (l <= r) {
                int c1 = l + (r - l) / 2;
                c2 = m + n - c1;
                l1 = c1 == 0 ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
                r1 = c1 == 2 * n ? Integer.MAX_VALUE : nums1[c1 / 2];
                l2 = c2 == 0 ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
                r2 = c2 == 2 * m ? Integer.MAX_VALUE : nums2[c2 / 2];
                if (l1 > r2) {
                    r = c1 - 1;
                } else if (l2 > r1) {
                    l = c1 + 1;
                } else {
                    break;
                }
            }
            return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}