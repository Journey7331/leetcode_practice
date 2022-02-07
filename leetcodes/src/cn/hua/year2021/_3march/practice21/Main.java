package cn.hua.year2021._3march.practice21;
// 73. 矩阵置零
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[][] array = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}};

        int[][] array = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        System.out.println(Arrays.deepToString(array));
        setZeroes(array);
        System.out.println(Arrays.deepToString(array));
    }

    // 题解答案 空间复杂度 O(1)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        // 第一列有没有零
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break;
            }

        // 第一行有没有零
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) {
                flagRow0 = true;
                break;
            }

        // 如果是零就将 该数所在行的第一个数置零，所在列的第一个数置零
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;

        // 如果所在行首或者列首元素为零，则说明该行该列应该都为零，将该元素置零
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        //首行首列如果有零
        if (flagCol0) for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (flagRow0) for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }
    

    // 空间复杂度 O(m+n)
    public static void setZeroes(int[][] matrix) {
        int m = matrix[0].length;   //长
        int n = matrix.length;      //高
        int[] index = new int[m + n];
        for (int i = 0; i < (m + n); i++) index[i] = 0;

        for (int i = 0; i < n; i++)
            for (int i1 = 0; i1 < m; i1++)
                if (matrix[i][i1] == 0) {
                    index[i1] = 1;
                    index[m + i] = 1;
                }

        for (int i = 0; i < m; i++)
            if (index[i] == 1)
                for (int i1 = 0; i1 < n; i1++)
                    matrix[i1][i] = 0;

        for (int i = m; i < (m + n); i++)
            if (index[i] == 1)
                for (int i1 = 0; i1 < m; i1++)
                    matrix[i - m][i1] = 0;

    }
}
