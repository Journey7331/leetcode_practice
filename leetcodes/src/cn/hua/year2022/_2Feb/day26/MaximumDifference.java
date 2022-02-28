package cn.hua.year2022._2Feb.day26;

// 2016. 增量元素之间的最大差值
// 简单题
public class MaximumDifference {

    public static void main(String[] args) {
        int[] nums = {
//                7, 1, 5, 4
//                9, 4, 3, 2
                1, 5, 2, 10
        };
        System.out.println(maximumDifference(nums));
    }


    // O(n) 0 ms 40.9 MB
    // 维护 min: 当前最小的值
    // 维护 max: 返回的结果, 最大的差值
    // 因为是单向遍历, 所以当max更新时, 一定是后面的减去前面的, 满足 i < j
    // 只要当前大于 min, 就看差值能否更新 max
    public static int maximumDifference(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0, min = nums[0]; i < n; i++) {
            if (nums[i] > min) {
                max = Math.max(nums[i] - min, max);
            }
            min = Math.min(nums[i], min);
        }
        return max;
    }


    // 暴力模拟 O(n^2)
    // 6 ms, 40.8 MB
    public static int maximumDifference1(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] >= nums[j]) continue;
                max = Math.max(max, nums[j] - nums[i]);
            }
        }
        return max;
    }


}
