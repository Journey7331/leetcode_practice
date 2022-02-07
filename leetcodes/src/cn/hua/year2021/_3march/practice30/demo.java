package cn.hua.year2021._3march.practice30;

public class demo {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        boolean b = searchMatrix(matrix, target);
        System.out.println(b);


    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == target) {
                    flag = true;
                    break;
                }
                if (ints[j] > target) break;
            }
        }
        return flag;
    }


    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        int l = 0, r = n;
        boolean flag = false;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[m - 1][mid] == target) flag = true;
            if (target > matrix[m - 1][mid]) l = mid - 1;
            if (target < matrix[m - 1][mid]) r = mid + 1;
        }

        l = 0;
        r = m-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[m - 1][mid] == target) flag = true;
            if (target > matrix[m - 1][mid]) l = mid - 1;
            if (target < matrix[m - 1][mid]) r = mid + 1;
        }


        return flag;
    }

}
