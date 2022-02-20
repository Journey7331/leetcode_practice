package cn.hua.year2022._2Feb.day15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 1380. 矩阵中的幸运数
// 简单题
public class LuckyNumbers {

    public static final int[][] MATRIX1 = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
    };
    public static final int[][] MATRIX2 = {
            {1, 10, 4, 2},
            {9, 3, 8, 7},
            {15, 16, 17, 12}
    };

    public static void main(String[] args) {
        System.out.println(luckyNumbers(MATRIX1));
        System.out.println(luckyNumbers(MATRIX2));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int[] ints : matrix) {
            int min = Integer.MAX_VALUE;
            for (int item : ints) {
                min = Math.min(min, item);
            }
            set.add(min);
        }
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : matrix) {
                max = Math.max(max, ints[j]);
            }
            if (set.contains(max)) ans.add(max);
        }
        return ans;
    }

}
