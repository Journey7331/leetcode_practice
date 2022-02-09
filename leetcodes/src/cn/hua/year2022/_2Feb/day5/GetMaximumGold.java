package cn.hua.year2022._2Feb.day5;

import java.util.Arrays;

// 1219. 黄金矿工
// 中等题
// 递归回溯 / 深搜 dfs
public class GetMaximumGold {

    public static final int[][] GRID1 = {
            {1, 0, 7},
            {2, 0, 6},
            {3, 4, 5},
            {0, 3, 0},
            {9, 0, 20}
    };
    public static final int[][] GRID2 = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
    };

    public static void main(String[] args) {
        System.out.println(getMaximumGold(GRID1));
        System.out.println(getMaximumGold(GRID2));
    }

    public static int getMaximumGold(int[][] grid) {
        int maxLen = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) maxLen = Math.max(maxLen, getGold(grid, i, j));
            }
        }
        return maxLen;
    }

    // four directions
    public static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int getGold(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;

        int len = grid[i][j];
        grid[i][j] = 0;     // 开采完置为零, 根据规则,不会原路返回

        int maxLen = -1;
        // 上下左右的顺序
        for (int[] d : directions) {
            int di = i + d[0], dj = j + d[1];
            maxLen = Math.max(maxLen, getGold(grid, di, dj));
        }
        grid[i][j] = len;   // DFS回溯的常规操作: 恢复现场

        return maxLen + len;
    }

}
