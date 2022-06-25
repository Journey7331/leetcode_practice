package cn.hua.year2022._6Jun.day25;

// 剑指 Offer II 091. 粉刷房子
// 中等题
// 「动态规划」
public class MinCost {

    public int minCost(int[][] costs) {
        int[] dp = new int[3];

        for (int[] cost : costs) {
            int pink = cost[0] + Math.min(dp[1], dp[2]);
            int blue = cost[1] + Math.min(dp[0], dp[2]);
            int green = cost[2] + Math.min(dp[0], dp[1]);
            dp[0] = pink;
            dp[1] = blue;
            dp[2] = green;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

}
