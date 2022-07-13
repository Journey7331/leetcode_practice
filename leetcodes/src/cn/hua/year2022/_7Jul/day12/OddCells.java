package cn.hua.year2022._7Jul.day12;

// 1252. 奇数值单元格的数目
// 简单题
public class OddCells {


    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
