package cn.hua.year2021._4apirl.practice3;
// 1143. 最长公共子序列
// DP动态规划基础题型
public class demo {

    public static void main(String[] args) {
        String str1 = "abcba";
        String str2 = "abcbcba";
        int i = longestCommonSubsequence(str1, str2);
        System.out.println(i);
    }

    // 一维dp
    // 使用两个临时变量记录dp[i-1][j-1]和 dp[i][j]
    // 降低dp的空间复杂度
    public static int longestCommonSubsequence(String text1, String text2) {
        int lena = text1.length(), lenb = text2.length(), pre;
        int[] dp = new int[lenb + 1];

        for (int i = 1; i <= lena; i++) {
            char c1 = text1.charAt(i - 1);
            pre = 0;
            for (int j = 1; j <= lenb; j++) {
                int tmp = dp[j];
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) dp[j] = pre + 1;
                else dp[j] = Math.max(dp[j-1], dp[j]);
                pre = tmp;
            }
        }
        return dp[lenb];
    }


    // 二维dp
    /*
     * 如果两个字符串的尾巴位置分别是 i和j
     * 假设它们的最长公共子序列的长度是函数 f(i, j)
     * 如果两个字符串的尾巴字符相同，易知 f(i,j) = f(i-1,j-1)
     *
     * a[i] == b[j]   dp[i][j] = dp[i-1][j-1] + 1
     * a[i] != b[j]   dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * */
    public static int longestCommonSubsequence1(String text1, String text2) {
        int lena = text1.length(), lenb = text2.length();
        int[][] dp = new int[lena + 1][lenb + 1];

        for (int i = 1; i <= lena; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= lenb; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[lena][lenb];
    }

}
