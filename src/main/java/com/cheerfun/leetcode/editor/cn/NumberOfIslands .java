//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.cheerfun.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        solution.numIslands(grid);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int n = grid.length;
            int m = grid[0].length;
            int[] parent = new int[n * m];
            for (int i = 0; i < n * m; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '0') {
                        continue;
                    }
                    if (j < m - 1 && grid[i][j + 1] == '1') {
                        union(parent, m * i + j, m * i + j + 1);
                    }
                    if (i < n - 1 && grid[i + 1][j] == '1') {
                        union(parent, m * i + j, m * (i + 1) + j);
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        set.add(find(parent, i * m + j));
                    }
                }
            }
            return set.size();
        }

        private void union(int[] parent, int a, int b) {
            parent[find(parent, b)] = find(parent, a);
        }

        private int find(int[] parent, int a) {
            int index = a;
            while (parent[index] != index) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}