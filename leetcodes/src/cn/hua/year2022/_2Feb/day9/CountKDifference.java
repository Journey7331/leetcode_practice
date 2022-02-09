package cn.hua.year2022._2Feb.day9;

import java.util.HashMap;
import java.util.Map;

// 2006. 差的绝对值为 K 的数对数目
// 简单题
public class CountKDifference {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        int k = 2;
        System.out.println(countKDifference(nums, k));
    }

    // 用hash存储计数也可以
    // 因为是边存入边查询的, 不会重复查询, 所以不需要除以二
    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + k)) cnt += map.get(num + k);
            if (map.containsKey(num - k)) cnt += map.get(num - k);
        }
        return cnt;
    }

    // 循环模拟, 暴力解法
    public static int countKDifference1(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++) if (Math.abs(nums[i] - nums[j]) == k) cnt++;
        return cnt;
    }

}
