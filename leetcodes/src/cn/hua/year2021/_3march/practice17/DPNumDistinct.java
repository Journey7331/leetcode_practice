package cn.hua.year2021._3march.practice17;
// . 不同的子序列
/*
 * 给定一个字符串 s 和一个字符串 t ，
 * 计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且
 * 不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 */

public class DPNumDistinct {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int i = numDistinct(s, t);
        System.out.println(i);
    }


    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > i)
                    continue;

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //如果 s的字符和 t的字符 匹配
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

}
