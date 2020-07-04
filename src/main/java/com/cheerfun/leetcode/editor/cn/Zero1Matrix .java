//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索

package com.cheerfun.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return matrix;
            }
            Deque<int[]> queue = new ArrayDeque<>();
            int n = matrix.length, m = matrix[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        queue.push(new int[]{i, j});
                    } else {
                        matrix[i][j] = -1;
                    }
                }
            }
            int[][] selects = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!queue.isEmpty()) {
                int[] cur = queue.removeFirst();
                int i = cur[0], j = cur[1];
                for (int[] select : selects) {
                    int x = i + select[0];
                    int y = j + select[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] == -1) {
                        matrix[x][y] = matrix[i][j] + 1;
                        queue.addLast(new int[]{x, y});
                    }
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}