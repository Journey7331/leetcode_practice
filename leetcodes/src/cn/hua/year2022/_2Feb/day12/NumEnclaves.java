package cn.hua.year2022._2Feb.day12;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 1020. 飞地的数量
// 中等题
public class NumEnclaves {

    public static final int[][] GRID1 = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0},
    };
    public static final int[][] GRID2 = {
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
    };

    public static void main(String[] args) {
        System.out.println(numEnclaves(GRID1));
        System.out.println(numEnclaves(GRID2));

    }

    public static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        // 列边
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][n - 1] == 1) dfs(i, n - 1, grid);
        }
        // 行边
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(0, i, grid);
            if (grid[m - 1][i] == 1) dfs(m - 1, i, grid);
        }

        for (int[] ints : grid) {
            for (int i : ints) {
                ans += (i == 1 ? 1 : 0);
            }
        }
        return ans;
    }

    private static void dfs(int i, int j, int[][] grid) {
        if (grid[i][j] == 0) return;
        if (grid[i][j] == 1) grid[i][j] = 0;

        int m = grid.length, n = grid[0].length;
        for (int[] d : directions) {
            int di = i + d[0], dj = j + d[1];
            if (di >= 0 && di < m && dj >= 0 && dj < n && grid[di][dj] == 1) {
                dfs(di, dj, grid);
            }
        }
    }

    /*
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 500
     * grid[i][j] 的值为 0 或 1
     *
     * 先遍历矩阵四周最外圈, 把值为一的节点加入`可离开的节点队列`中
     *
     * 思路一:
     * 从最外圈往中心一圈一圈靠拢, 如果与上一圈中被加入队列的节点的相邻接, 就加入队列中
     * 问题: 可能会出现一开始被判定为孤岛的节点, 但后来发现是连通的点
     * // 这是并查集的想法
     *
     * 思路二:
     * 由最外圈的值为一的点, 向内部深搜(dfs)/回溯递归搜索, 限制只能上下左右移动
     * 标记已经确认的点, 最后求出没有被标记的点的个数
     * // 这是dfs, 标记节点可以直接改成, 把值变为0
     * */
}
