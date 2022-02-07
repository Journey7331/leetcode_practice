package cn.hua.year2022._2Feb.day4;

// 1219. 黄金矿工
// 中等题
public class GetMaximumGold {

    public static final int[][] GRID1 = {
            {1, 0, 7},
            {2, 0, 6},
            {3, 4, 5},
            {0, 3, 0},
            {9, 0, 20}
    };

    /* 0 *
     3 * 1
     * 2 */

    public static void main(String[] args) {
        System.out.println(getMaximumGold(GRID1));


    }

    public static int getMaximumGold(int[][] grid) {
        int maxLen = 0, nowLen;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nowLen = getGold(grid, i, j);
                if (nowLen > maxLen) maxLen = nowLen;
            }
        }
        return maxLen;
    }

    public static int getGold(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        int len = grid[i][j], l1, l2, l3, l4;
        if (len == 0) return 0;

        l1 = getGold(grid, i - 1, j) + len;
        l2 = getGold(grid, i + 1, j) + len;
        l4 = getGold(grid, i, j - 1) + len;
        l3 = getGold(grid, i, j + 1) + len;

        return Math.max(Math.max(l1, l2), Math.max(l3, l4));
    }

}