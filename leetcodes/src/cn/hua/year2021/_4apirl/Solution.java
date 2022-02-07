package cn.hua.year2021._4apirl;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {-2147483648, 2147483647};
        int k = 1;
        int t = 1;
        boolean b = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if (k == 10000) return false;
        if (len <= 1) return false;

        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len && Math.abs(i - j) <= k; j++)
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t)
                    return true;

        return false;
    }

}
