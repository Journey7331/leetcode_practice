package cn.hua.year2022._2Feb.day8;

import java.util.ArrayList;
import java.util.Arrays;

// 1001. 网格照明
// 困难题
// 暴力解法, 没有AC
public class GridIllumination {

    // 0: off   1: shine    2: light
    public static int[][] grid;
    // eight directions
    public static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public static final int[][] LAMPS1 = {{0, 0}, {4, 4}};
    public static final int[][] QUERIES1 = {{1, 1}, {1, 0}};

    public static final int[][] LAMPS2 = {{0, 0}, {0, 4}};
    public static final int[][] QUERIES2 = {{0, 4}, {0, 1}, {1, 4}};

    public static final int[][] LAMPS3 = {{2, 5}, {4, 2}, {0, 3}, {0, 5}, {1, 4}, {4, 2}, {3, 3}, {1, 0}};
    public static final int[][] QUERIES3 = {{4, 3}, {3, 1}, {5, 3}, {0, 5}, {4, 4}, {3, 3}};

    public static void main(String[] args) {

//        int[] ints1 = gridIllumination(5, LAMPS1, QUERIES1);
//        System.out.println(Arrays.toString(ints1));
//
//        int[] ints2 = gridIllumination(5, LAMPS2, QUERIES2);
//        System.out.println(Arrays.toString(ints2));

        int[] ints3 = gridIllumination(6, LAMPS3, QUERIES3);
        System.out.println(Arrays.toString(ints3));
    }

    /*
     * 1 <= n <= 109
     * 0 <= lamps.length <= 20000
     * 0 <= queries.length <= 20000
     * lamps[i].length == 2
     * 0 <= rowi, coli < n
     * queries[j].length == 2
     * 0 <= rowj, colj < n
     */

    // 暴力解的方法, 会超出内存限制 saaaaad
    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        /*
         * ans:  返回 queries 的查找结果
         * grid: 网格, 其中的值  0: off  1: shine  2: light
         * lightedLamps: 被点亮的lamp,不重复
         * */
        int[] ans = new int[queries.length];
        grid = new int[n][n];
        ArrayList<Lamp> lightedLamps = new ArrayList<>();

        // 记入被点亮的灯
        for (int[] lamp : lamps) {
            Lamp l = new Lamp(lamp[0], lamp[1]);
            if (!lightedLamps.contains(l)) lightedLamps.add(l);
        }

        // 查找该处是否被照亮
        for (int i = 0; i < queries.length; i++) {
            turnOnLamps(lightedLamps);
            ans[i] = queryLamps(queries[i][0], queries[i][1], lightedLamps);
        }

        return ans;
    }

    private static int queryLamps(int i, int j, ArrayList<Lamp> lightedLamps) {
        for (int[] d : directions) {
            int di = i + d[0], dj = j + d[1], n = grid.length;
            if (di >= 0 && di < n && dj >= 0 && dj < n && grid[di][dj] == 2) {
                lightedLamps.remove(new Lamp(di, dj));
            }
        }
        // 如果是lamp所在处
        if (grid[i][j] == 2) {
            lightedLamps.remove(new Lamp(i, j));
            return 1;
        }
        // 如果是被照亮的话
        if (grid[i][j] == 1) {
            return 1;
        }
        return 0;
    }

    private static void turnOnLamps(ArrayList<Lamp> lightedLamps) {
        for (int[] ints : grid) Arrays.fill(ints, 0);
        for (Lamp l : lightedLamps) {
            grid[l.x][l.y] = 2;
            shine(l.x, l.y);
        }
    }

    private static void shine(int x, int y) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            // 列
            if (grid[x][i] == 0) {
                grid[x][i] = 1;
            }
            // 行
            if (grid[i][y] == 0) {
                grid[i][y] = 1;
            }
            // 正对角线
            int di = x + i, dj = y + i, ti = x - i, tj = y - i;
            check(n, di, tj, ti, dj);
            // 反对角线
            check(n, di, dj, ti, tj);
        }

    }

    private static void check(int n, int di, int dj, int ti, int tj) {
        if (di >= 0 && di < n && tj >= 0 && tj < n && grid[di][tj] == 0) {
            grid[di][tj] = 1;
        }
        if (ti >= 0 && ti < n && dj >= 0 && dj < n && grid[ti][dj] == 0) {
            grid[ti][dj] = 1;
        }
    }


    static class Lamp {
        int x, y;

        @Override
        public boolean equals(Object obj) {
            return ((Lamp) obj).x == this.x && ((Lamp) obj).y == this.y;
        }

        public Lamp(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
