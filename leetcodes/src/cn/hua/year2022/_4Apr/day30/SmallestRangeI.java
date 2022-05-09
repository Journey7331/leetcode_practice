package cn.hua.year2022._4Apr.day30;

// 908. 最小差值 I
// 简单题
public class SmallestRangeI {


    public static void main(String[] args) {

    }

    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int ans = max - min - 2 * k;
        if (ans<0) ans = 0;
        return ans;
    }


}
