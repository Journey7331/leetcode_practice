package cn.hua.year2022._6Jun.day26;

import java.util.*;

// 710. 黑名单中的随机数
// 困难题

// 官方题解
public class RandomPickWithBlacklist {

    Map<Integer, Integer> b2w;  // Black To White
    Random random;
    int bound;

    public RandomPickWithBlacklist(int n, int[] blacklist) {
        b2w = new HashMap<Integer, Integer>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;

        // 从0到n 有n-m个处于白名单的数
        // 取出「值大于n-m」的黑名单的数
        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }

        // 把「值大于n-m」的白名单的数 映射到前面是 黑名单的数的位置上
        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                b2w.put(b, w);
                ++w;
            }
        }
    }

    public int pick() {
        // 从0到n-m随意取值，下标在黑名单的会去找后面映射的数
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */