package cn.hua.year2022._3Mar.day27;

import java.util.ArrayList;
import java.util.Arrays;

// 2028. 找出缺失的观测数据
// 中等题
public class MissingRolls {


    public static void main(String[] args) {
        int[] rolls = {
//                3, 2, 4, 3
//                1, 5, 6
                1, 2, 3, 4
//                1
        };
        System.out.println(Arrays.toString(missingRolls(rolls, 6, 4)));
    }

    // 单纯模拟
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (n + rolls.length);
        for (int i : rolls) sum -= i;
        return findArray(sum, n);
    }

    private static int[] findArray(int sum, int n) {
        if (n == 1 && (sum > 6 || sum < 1)) return new int[0];
        if (sum < n || sum > n * 6) return new int[0];

        int[] ans = new int[n];
        int t = sum / n;
        Arrays.fill(ans, t);
        sum -= (n * t);
        for (int j = 0; j < ans.length; j++) {
            if (sum == 0) break;
            ans[j]++;
            sum--;
        }
        return ans;
    }

}
