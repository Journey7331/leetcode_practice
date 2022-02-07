package cn.hua.year2021._3march.practice15;
// 54. 螺旋矩阵
/*
 * 给你一个 m 行 n 列的矩阵 matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * */

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> method = method(matrix);
        System.out.println(method);
    }


    public static List<Integer> method(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = matrix.length;      //高
        int n = matrix[0].length;   //宽
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++) list.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) list.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) list.add(matrix[i][left]);
            if (++left > right) break;
        }
        return list;
    }
}
