package cn.hua.year2022._2Feb.day7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 1405. 最长快乐字符串
// 中等题
public class LongestDiverseString {

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 1, 7));  //ccaccbcc
        System.out.println(longestDiverseString(2, 2, 1));  //abbac
        System.out.println(longestDiverseString(7, 1, 0));  //aabaa
        System.out.println(longestDiverseString(1, 3, 5));  //ccbccbbca
    }

    /*
     * 思路很好想
     * 每次取个数最多的字符
     * 如果最后已经是两个了, 就取个数第二多的字符
     * 如果取不出, 或者三个字符个数都为零就返回结果
     * */

    // 三叶AC
    // 利用优先队列, 队列的 poll 和 add 取出第一个和第二个
    // 思想很妙
    // 2 ms, 38.8 MB
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> o2.x - o1.x);
        queue.add(new Pair('a', a));
        queue.add(new Pair('b', b));
        queue.add(new Pair('c', c));
        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int len = str.length();
            if (len >= 2 && str.charAt(len - 1) == poll.c && poll.c == str.charAt(len - 2)) {
                Pair secondPoll = queue.poll();
                if (secondPoll.x == 0) break;
                str.append(secondPoll.c);
                secondPoll.x--;
                queue.add(secondPoll);
            } else {
                if (poll.x == 0) break;
                str.append(poll.c);
                poll.x--;
            }
            queue.add(poll);
        }
        return str.toString();
    }


    // 自己写的, 循环模拟
    // 思路不够清晰, 略有混乱
    // 1 ms, 38.5 MB
    public static String longestDiverseString1(int a, int b, int c) {
        StringBuilder str = new StringBuilder();
        char now = ' ';
        boolean flag = false;
        int len = 0;
        Pair[] pairs = {new Pair('a', a), new Pair('b', b), new Pair('c', c)};
        while (true) {
            Arrays.sort(pairs, (o1, o2) -> o2.x - o1.x);
            if (pairs[0].x == 0) break;

            /*
             * 这里的第二个判断条件, 是因为循环初的排序会改变上一轮中abc的顺序
             * 不添加这个条件 `now != pairs[0].c` 会有错误
             * a = 1, b = 3, c = 5
             * 错误结果: ccbcccabb
             * 正确结果: ccbccbbca
             */
            if (!flag || now != pairs[0].c) {
                now = pairs[0].c;
                pairs[0].x--;
            } else {
                if (pairs[1].x == 0) break;

                now = pairs[1].c;
                pairs[1].x--;
            }

//            flag = (len > 0 && now == str.charAt(len - 1));
            if (len > 0 && now == str.charAt(len - 1)) flag = true;
            else flag = false;

            str.append(now);
            len++;
        }
        return str.toString();
    }

    static class Pair {
        char c;
        int x;

        public Pair(char c, int x) {
            this.c = c;
            this.x = x;
        }
    }

}
