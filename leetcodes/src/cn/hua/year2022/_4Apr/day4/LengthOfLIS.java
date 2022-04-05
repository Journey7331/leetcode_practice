package cn.hua.year2022._4Apr.day4;

import java.util.Arrays;

// 300. 最长递增子序列
// 中等题
// 「动态规划」「贪心+二分查找」
public class LengthOfLIS {

    public static void main(String[] args) {

    }

    // dp 动态规划
    // O(n^2)
    public int lengthOfLIS0(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int manLen = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            manLen = Math.max(manLen, dp[i]);
        }
        return manLen;
    }

    /*
    * 这种解法是应对「只返回一个最大长度」的解法
    * len 的值始终是最长递增子序列的长度
    * 而 ans 内的元素可能被覆盖
    * 故可能导致最终的数组值不是最终的递增序列值，但这对需要的返回值无影响
    * */
    // 贪心 + 二分查找
    // O(n*logn)
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] ans = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // 二分法找到第一个比 num 大的数的位置
            // 如果 num 最大，则追加到结尾，且 len++
            // 因为 ans 在 0-len 始终是有序的，所以可以使用二分来优化时间
            int idx = Arrays.binarySearch(ans, 0, len, num);
            idx = (idx < 0) ? -idx - 1 : idx;

            ans[idx] = num;

            if(idx == len) len++;
        }
        return len;
    }



}
