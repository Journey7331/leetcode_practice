package cn.hua.year2022._3Mar.day3;

// 258. 各位相加
// 简单题
// 数学规律题
public class AddDigits {

    /*
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
     * */

    public static void main(String[] args) {
        /*
         * 各位相加的过程为：
         * 38 --> 3 + 8 --> 11
         * 11 --> 1 + 1 --> 2
         * 由于 2 是一位数，所以返回 2。
         * */
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

}
