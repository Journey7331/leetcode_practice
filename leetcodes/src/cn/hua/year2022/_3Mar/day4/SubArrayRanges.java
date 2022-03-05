package cn.hua.year2022._3Mar.day4;


// 2104. 子数组范围和
// 中等题

public class SubArrayRanges {

    /*
     * 1 <= nums.length <= 1000
     * -10^9 <= nums[i] <= 10^9
     * */

    public static void main(String[] args) {
        int[] nums = {
                4, -2, -3, 4, 1
//                1, 3, 3
//                1, 2, 3
        };

        System.out.println(subArrayRanges(nums));

    }

    // 因为 nums 的长度最大不超过 1000
    // 所以直接暴力解了
    // 17 ms, 40.7 MB
    public static long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += (max - min);
            }
        }
        return ans;
    }


}
