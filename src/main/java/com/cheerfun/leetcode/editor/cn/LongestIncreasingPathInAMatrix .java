//给定一个整数矩阵，找出最长递增路径的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 
//
// 示例 1: 
//
// 输入: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//输出: 4 
//解释: 最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2: 
//
// 输入: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//输出: 4 
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化

package com.cheerfun.leetcode.editor.cn;

class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        solution.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] selects = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int n = matrix.length, m = matrix[0].length;
            int[][] cache = new int[n][m];
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result = Math.max(maxPathDfs(matrix, i, j, cache, n, m), result);
                }
            }
            return result;
        }

        private int maxPathDfs(int[][] matrix, int x, int y, int[][] cache, int n, int m) {
            if (cache[x][y] != 0) {
                return cache[x][y];
            }
            for (int[] select : selects) {
                int i = x + select[0], j = y + select[1];
                if (i >= 0 && i < n && j >= 0 && j < m && matrix[x][y] < matrix[i][j]) {
                    cache[x][y] = Math.max(maxPathDfs(matrix, i, j, cache, n, m), cache[x][y]);
                }
            }
            return ++cache[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}