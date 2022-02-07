package cn.hua.year2021._3march.practice16;
// 59. 螺旋矩阵 II
/*
 * 给你一个正整数n ，生成一个包含 1 到 n 所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 1 2 3
 * 8 9 4
 * 7 6 5
 */

import java.util.Arrays;

public class generateMatrix {

    public static void main(String[] args) {
        int[][] ints = method(3);
        System.out.println(Arrays.deepToString(ints));
    }

    private static int[][] method(int n) {
        int[][] matrix = new int[n][n];
        int cnt = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (true) {
            for (int j = left; j <= right; j++) matrix[top][j] = cnt++;
            if (++top > bottom) break;
            for (int j = top; j <= bottom; j++) matrix[j][right] = cnt++;
            if (--right < left) break;
            for (int j = right; j >= left; j--) matrix[bottom][j] = cnt++;
            if (--bottom < top) break;
            for (int j = bottom; j >= top; j--) matrix[j][left] = cnt++;
            if (++left > right) break;
        }
        return matrix;
    }


}
