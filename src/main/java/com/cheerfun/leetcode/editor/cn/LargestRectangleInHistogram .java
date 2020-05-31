//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组

package com.cheerfun.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int result = 0;
            if (heights == null || heights.length == 0) {
                return result;
            }
            int len = heights.length;
            Deque<Integer> stack = new ArrayDeque<>(len);
            for (int i = 0; i <= len; i ++) {
                int height = 0;
                if(i != len) {
                    height = heights[i];
                }
                while (!stack.isEmpty() && heights[stack.peekLast()] > height) {
                    int curHeight = heights[stack.pollLast()];
                    while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                        stack.pollLast();
                    }
                    int curWeith = 0;
                    if (stack.isEmpty()) {
                        curWeith = i;
                    } else {
                        curWeith = i - stack.pollLast() - 1;
                    }
                    result = Math.max(result, curHeight * curWeith);
                }
                if(i != len) {
                    stack.offerLast(i);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}