//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

package com.cheerfun.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest_01(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length, Comparator.comparingInt(o -> o));
            for (int num : nums) {
                if (heap.size() < k) {
                    heap.add(num);
                } else if (heap.peek() < num) {
                    heap.poll();
                    heap.add(num);
                }
            }
            return heap.peek();
        }

        public int findKthLargest(int[] nums, int k) {
            if (nums == null || k > nums.length) {
                return -1;
            }
            return quickSortFind(nums, 0, nums.length - 1, k);
        }

        public int quickSortFind(int[] nums, int l, int r, int k) {
            if (l > r) {
                return -1;
            }
            int start = l, end = r;
            int point = nums[l];
            while (start < end) {
                while (start < end && point >= nums[end]) {
                    end--;
                }
                if (start < end) {
                    nums[start++] = nums[end];
                }
                while (start < end && point <= nums[start]) {
                    start++;
                }
                if (start < end) {
                    nums[end--] = nums[start];
                }
            }
            nums[start] = point;
            if (start == k - 1) {
                return nums[start];
            } else if (start > k - 1) {
                return quickSortFind(nums, l, start - 1, k);
            } else {
                return quickSortFind(nums, start + 1, r, k);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}