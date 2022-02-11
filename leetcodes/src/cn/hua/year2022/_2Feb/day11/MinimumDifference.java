package cn.hua.year2022._2Feb.day11;

import java.util.Arrays;

// 1984. 学生分数的最小差值
// 简单题
/*
 * 给你一个 下标从 0 开始 的整数数组 nums ，
 * 其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 *
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * 返回可能的 最小差值 。
 *
 * 1 <= k <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class MinimumDifference {

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        System.out.println(minimumDifference(nums, k));
    }

    // 先排序, k大小的滑动窗口, 求两端的差值, 维护ans的值
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k <= nums.length; i++) {
            ans = Math.min(nums[i + k - 1] - nums[i], ans);
        }
        return ans;
    }

}
