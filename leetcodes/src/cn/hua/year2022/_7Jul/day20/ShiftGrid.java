package cn.hua.year2022._7Jul.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 1260. 二维网格迁移
// 简单题
public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, len = m * n;
        List<List<Integer>> list = new ArrayList<>();
        if (k % len != 0) {
            int[] arr = new int[len];
            for (int[] ints : grid) {
                for (int i : ints) {
                    arr[(k++) % len] = i;
                }
            }
            k = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = arr[k++];
                }
            }
        }
        for (int[] ints : grid) {
            list.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
        }
        return list;
    }

}
