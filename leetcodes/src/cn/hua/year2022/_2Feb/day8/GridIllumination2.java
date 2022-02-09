package cn.hua.year2022._2Feb.day8;

import java.util.*;

// 1001. 网格照明
// 困难题
// AC代码借鉴
public class GridIllumination2 {

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
    public static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 0}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        // 记录在当前行/列/对角线上有几个lamp
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        // 无重复记录
        Set<Long> set = new HashSet<>();

        for (int[] lamp : lamps) {
            // x : row      y: col
            int x = lamp[0], y = lamp[1];
            // a : back-diagonal line / left
            // b : diagonal line / right
            // 以斜率表示正反对角线
            int a = x + y, b = x - y;
            if (!set.contains(hash(x, y, n))) {
                // update shine
                increase(row, x);
                increase(col, y);
                increase(left, a);
                increase(right, b);
                // 一维的方式存入lamp,
                set.add(hash(x, y, n));
            }
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = queries[i][0], y = queries[i][1];
            int a = x + y, b = x - y;
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(a) || right.containsKey(b)) {
                ans[i] = 1;
            }

            // 八个邻居方格 + 自己 共九个
            for (int[] d : directions) {
                int dx = x + d[0], dy = y + d[1];
                int da = dx + dy, db = dx - dy;
                if (dx >= 0 && dx < n && dy >= 0 && dy < n && set.contains(hash(dx, dy, n))) {
                    set.remove(hash(dx, dy, n));
                    decrease(row, dx);
                    decrease(col, dy);
                    decrease(left, da);
                    decrease(right, db);
                }
            }
        }

        return ans;
    }

    private static void increase(HashMap<Integer, Integer> hashMap, int a) {
        hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
    }


    private static void decrease(HashMap<Integer, Integer> hashMap, int a) {
        if (hashMap.get(a) == 1) hashMap.remove(a);
        else hashMap.put(a, hashMap.get(a) - 1);
    }

    // 转为哈希值后可能会超过Integer的范围
    private static Long hash(int x, int y, int n) {
        return x * (long) n + y;
    }


}
