package cn.hua.year2022._1Jan.day14;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// 264. 丑数 II
/*
给你一个整数 n ，请你找出并返回第 n 个 丑数 。
丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(10));
    }

    /* 分析
     * 1
     * 2 2x1 2x2 2x3 ...
     * 3 3x1 3x2 3x3 ...
     * 5 5x1 5x2 5x3 ...
     * */
    // 多指针，多路归并
    public static int nthUglyNumber(int n) {
        int[] book = new int[n + 1];
        book[1] = 1;
        int idx2 = 1, idx3 = 1, idx5 = 1;
        for (int i = 2; i <= n; i++) {
            int a = 2 * book[idx2];
            int b = 3 * book[idx3];
            int c = 5 * book[idx5];
            int min = Math.min(a, Math.min(b, c));
            book[i] = min;

            if (min == a) idx2++;
            if (min == b) idx3++;
            if (min == c) idx5++;
        }

        return book[n];
    }

    // 优先队列
    public static int nthUglyNumber2(int n) {
        int[] ugly = {2, 3, 5,};
        Set<Long> set = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        for (int i = 1; i <= n; i++) {
            long poll = queue.poll();
            // 到达第 n 个丑数
            if (i == n) return (int) poll;
            // 填入 set 和 queue
            for (int o : ugly) {
                long num = poll * o;
                // 不重复填入 比如：15=3x5
                if (!set.contains(num)) {
                    queue.add(num);
                    set.add(num);
                }
            }
        }
        return 0;
    }


}
