//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

package com.cheerfun.leetcode.editor.cn;

import java.util.Arrays;

class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int[][] result = new int[intervals.length][2];
            if (intervals == null || intervals.length == 0) {
                return Arrays.copyOf(result, 0);
            }
            int j = 0;
            quickSort(intervals, 0, intervals.length - 1);
            for (int i = 0; i < intervals.length; i++) {
                if (i == 0 || result[j - 1][1] < intervals[i][0]) {
                    result[j++] = intervals[i];
                } else if (result[j - 1][1] < intervals[i][1]) {
                    result[j - 1][1] = intervals[i][1];
                }
            }
            return Arrays.copyOf(result, j);
        }

        private void quickSort(int[][] intervals, int begin, int end) {
            if (begin >= end) {
                return;
            }
            int l = begin, r = end;
            int[] point = intervals[begin];
            while (l < r) {
                while (l < r && intervals[r][0] >= point[0]) {
                    r--;
                }
                if (l < r) {
                    intervals[l++] = intervals[r];
                }
                while (l < r && intervals[l][0] <= point[0]) {
                    l++;
                }
                if (l < r) {
                    intervals[r--] = intervals[l];
                }
            }
            intervals[l] = point;
            quickSort(intervals, begin, l - 1);
            quickSort(intervals, l + 1, end);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}