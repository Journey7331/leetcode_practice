package cn.hua.year2022._2Feb.day20;

import java.util.Arrays;

// 717. 1比特与2比特字符
// 简单题
/*
 * 有两种特殊字符：
 *
 * 第一种字符可以用一个比特 0 来表示
 * 第二种字符可以用两个比特 (10或11) 来表示、
 * 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。
 *
 */
public class IsOneBitCharacter {

    public static void main(String[] args) {
        int[] bits = {
//                1, 0, 0
                1, 1, 1, 0
        };
        System.out.println(isOneBitCharacter(bits));
    }

    // 倒序
    // 根据连续个`1`的个数奇偶性来判断
    // 0 ms, 40.8 MB
    public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if(bits[i] == 1) cnt++;
            else break;
        }
        return (cnt % 2 == 0);
    }




    // 正向模拟
    // (10)/(11)是成对出现的
    // 0 ms, 40.7 MB
    public static boolean isOneBitCharacter1(int[] bits) {
        int n = bits.length, i;
        // 结尾不是0的话, 直接返回 false
        if (bits[n - 1] != 0) return false;
        // 过滤掉前面的字符
        for (i = 0; i < n - 1; i++) {
            // 如果遇到1, 直接跳过下一个bit
            // 遇到0, 正常到下一个bit
            if (bits[i] == 1) i++;
        }
        // 如果倒数第二位是1, 则最后一个bit会被跳跃
        // 那么最后一个字符就不是一位字符(0)，则返回 false 。
        return i == n - 1;
    }


    // 正则表达式
    // 7 ms, 40.9 MB
    public static boolean isOneBitCharacter2(int[] bits) {
        StringBuilder str = new StringBuilder();
        for (int bit : bits) str.append(bit);
        return str.toString().matches("((0|10|11)*)0");
//        Arrays.toString(bits).sout :
//        [1, 1, 1, 0]
//        return Arrays.toString(bits).replaceAll("[\\[\\]\\s,]","").matches("(10|11|0)*0$");
    }


}
