package cn.hua.year2022._2Feb.day12;

// 1020. 飞地的数量
// 并查集的实现
public class DisjointSet {

    public static final int[][] GRID1 = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0},
    };
    public static final int[][] GRID2 = {
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
    };

    public static void main(String[] args) {
        System.out.println(numEnclaves(GRID1));
        System.out.println(numEnclaves(GRID2));
    }


    public static int numEnclaves(int[][] grid) {

        return 1;
    }

}
