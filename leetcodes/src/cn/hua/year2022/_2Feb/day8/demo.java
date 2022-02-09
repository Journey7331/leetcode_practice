package cn.hua.year2022._2Feb.day8;

import java.util.Arrays;

public class demo {

    public static void main(String[] args) {
        int n = 6;
        int x = 3, y = 2;
        int[][] grid = new int[n][n];
        for (int[] ints : grid) {
            Arrays.fill(ints, 0);
        }
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
            if (di >= 0 && di < n && dj >= 0 && dj < n) {
                grid[di][dj] = 1;
            }
            if (ti >= 0 && ti < n && tj >= 0 && tj < n) {
                grid[ti][tj] = 1;
            }
            // 反对角线
            if (di >= 0 && di < n && tj >= 0 && tj < n) {
                grid[di][tj] = 1;
            }
            if (ti >= 0 && ti < n && dj >= 0 && dj < n) {
                grid[ti][dj] = 1;
            }
        }
        for (int[] ints : grid) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

