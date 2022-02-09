package cn.hua.year2021._3march.practice22;
// 191. 位1的个数
/*
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。
 * 在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
 * 因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * 提示：
 * 输入必须是长度为 32 的 二进制串 。
 * */


public class Main {

    public static void main(String[] args) {
        int i = hammingWeight(11);
        System.out.println(i);
    }

    // you need to treat n as an unsigned value
    /* 【题解】
     * 位运算优化   思路及解法
     * 观察这个运算：n&(n−1)，其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
     *
     * 如：6&(6-1)=4, 6=(110)_2, 4=(100)_2
     * 运算结果 4 即为把 6 的二进制位中的最低位的 1 变为 0 之后的结果。
     * 这样我们可以利用这个位运算的性质加速我们的检查过程，
     * 
     * 在实际代码中，我们不断让当前的 n 与 n−1 做与运算，直到 n 变为 0 即可。
     * 因为每次运算会使得 n 的最低位的 1 被翻转，因此运算次数就等于 n 的二进制位中 1 的个数。
     */
    public int hammingWeight0(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    // 调用函数
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    // Integer.toBinaryString()转换成String
    // 用String类中的方法
    public int hammingWeight1(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                count++;
        }
        return count;
    }

    // C语言中使用
    // 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
    // 所以当数值很大的时候会表示有误
    int hammingWeight3(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) cnt++;
            n /= 2;
        }
        return cnt;

    }


    /*
     *
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * 示例 2：
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     *
     * 示例 3：
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     * */

}