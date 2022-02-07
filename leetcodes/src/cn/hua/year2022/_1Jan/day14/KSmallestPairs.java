package cn.hua.year2022._1Jan.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 373. 查找和最小的 K 对数字
/*
 * [1,7,11] [2,4,6]
 * [ 1,2] [ 1,4] [ 1,6]
 * [ 7,2] [ 7,4] [ 7,6]
 * [11,2] [11,4] [11,6]
 *
 * [1,1,2] [1,2,3]
 * [1,1] [1,2] [1,3]
 * [1,1] [1,2] [1,3]
 * [2,1] [2,2] [2,3]
 * */
public class KSmallestPairs {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11,};
        int[] nums2 = {2, 4, 6,};
        int k = 3;
//        int[] nums1 = {1, 1, 2,};
//        int[] nums2 = {1, 2, 3,};
//        int k = 2;
//        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]
        );
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0});
        }
        while (!queue.isEmpty() && k-- > 0) {
            int[] poll = queue.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            ans.add(list);
            if (poll[1] != n - 1) {
                poll[1]++;
                queue.add(poll);
            }
        }
        return ans;
    }


    boolean flag = true;

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        if (n > m && !(flag = false)) return kSmallestPairs(nums2, nums1, k);

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < Math.min(n, k); i++) q.add(new int[]{i, 0});
        while (ans.size() < k && !q.isEmpty()) {
            int[] poll = q.poll();
            int a = poll[0], b = poll[1];
            ans.add(new ArrayList<Integer>() {{
                add(flag ? nums1[a] : nums2[b]);
                add(flag ? nums2[b] : nums1[a]);
            }});
            if (b + 1 < m) q.add(new int[]{a, b + 1});
        }
        return ans;
    }



}


//     //思路不对，写错了
//    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        ArrayList<Pair> pairs = new ArrayList<>();
//        int ki = 0, kj = 0;
//        for (int i : nums1) {
//            ki++;
//            for (int j : nums2) {
//                kj++;
//                pairs.add(new Pair(i, j));
//                if (kj == k) break;
//            }
//            if (ki == k) break;
//        }
//
//        pairs.sort((o1, o2) -> {
//            int x = o1.a + o1.b;
//            int y = o2.a + o2.b;
//            if (x == y) {
//                return o1.a - o2.a;
//            } else {
//                return x - y;
//            }
//        });
//
//        List<List<Integer>> lists = new ArrayList<>();
//        for (Pair pair : pairs) {
//            if (k-- == 0) break;
//            List<Integer> integers = new ArrayList<>();
//            integers.add(pair.a);
//            integers.add(pair.b);
//            lists.add(integers);
//        }
//        return lists;
//    }
//
//    public static class Pair {
//        int a, b;
//
//        public Pair(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//    }