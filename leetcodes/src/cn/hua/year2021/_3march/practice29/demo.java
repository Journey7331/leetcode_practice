package cn.hua.year2021._3march.practice29;

// 190. 颠倒二进制位
/*
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * */
public class demo {

    public static void main(String[] args) {
        int ret = reverseBits(43261596);
        System.out.println(ret);
    }

    public static int reverseBits(int n) {
        return Integer.reverse(n);

//        String str = Integer.toBinaryString(n);
//        char[] chars = str.toCharArray();
//        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
//            char c = chars[i];
//            chars[i] = chars[j];
//            chars[j] = c;
//        }
//        return Byte.toUnsignedInt(Byte.parseByte(Arrays.toString(chars)));
    }


}
