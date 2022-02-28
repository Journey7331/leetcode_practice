package cn.hua.year2022._2Feb.day27;

import java.util.ArrayList;
import java.util.Arrays;

// 553. 最优除法
// 中等题
// 脑筋急转弯 题目
public class OptimalDivision {

    public static void main(String[] args) {
        int[] nums = {
                1000, 100, 10
        };
        System.out.println(optimalDivision(nums));
    }

    public static String optimalDivision(int[] nums) {
        StringBuilder ans = new StringBuilder();
        int i = 0, n = nums.length;
        ans.append(nums[i++]);

        if (n == 1) return ans.toString();
        if (n == 2) return ans.append('/').append(nums[1]).toString();

        ans.append('/').append('(');
        while (i < n - 1) ans.append(nums[i++]).append('/');

        return ans.append(nums[i]).append(')').toString();
    }

}
