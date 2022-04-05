package cn.hua.year2022._4Apr.day1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// 954. 二倍数对数组
// 中等题
// 「优先队列」
public class CanReorderDoubled {

    public static void main(String[] args) {
        int[] arr = new int[]{
//                3, 1, 3, 6
//                2, 1, 2, 6
//                4, -2, 2, -4
                1, 2, 4, 16, 8, 4
//                2, 4, 0, 0, 8, 1
        };
        System.out.println(canReorderDoubled(arr));
    }

    // 逐个构造 + 优先队列
    public static boolean canReorderDoubled(int[] arr) {
//        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        for (int a : arr) queue.add(a);

        for (int i = 0; i < arr.length / 2; i++) {
            if (queue.isEmpty()) break;
            if (!queue.remove(queue.poll() * 2)) return false;
        }
        return true;
    }
}
