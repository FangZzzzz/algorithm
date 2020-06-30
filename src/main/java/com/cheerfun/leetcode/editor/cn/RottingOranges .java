//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索

package com.cheerfun.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class RottingOranges {
    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            if (grid == null || grid == null || grid[0] == null) {
                return 0;
            }
            int[][] selects = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            Deque<int[]> queue = new ArrayDeque<>();
            int n = grid.length;
            int m = grid[0].length;
            int count = 0;
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        count++;
                    } else if (grid[i][j] == 2) {
                        queue.addLast(new int[]{i, j});
                    }
                }
            }
            while (count > 0 && !queue.isEmpty()) {
                result++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] node = queue.removeFirst();
                    for (int[] select : selects) {
                        int x = node[0] + select[0];
                        int y = node[1] + select[1];
                        if (x >= 0 && y >= 0 && x < n && y < m) {
                            if (grid[x][y] == 1) {
                                queue.addLast(new int[]{x, y});
                                count--;
                                grid[x][y] = 2;
                            }
                        }
                    }
                }
            }
            if (count > 0) {
                return -1;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}