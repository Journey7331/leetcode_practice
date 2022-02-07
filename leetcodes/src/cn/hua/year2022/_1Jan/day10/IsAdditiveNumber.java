package cn.hua.year2022._1Jan.day10;

// 306 累加数
// 写错了
public class IsAdditiveNumber {

    public static void main(String[] args) {
//        System.out.println("123".substring(0,2));
        String num = "123";
//        String num = "199100199";
        System.out.println(isAdditiveNumber(num));
    }

    public static boolean isAdditiveNumber(String num) {
        boolean flag = false;
        int num1 = -1, num2 = -1, num3 = -1;
        int i = 1, j = 1;
        int len = num.length();
        if (len < 3) return flag;
        while (j <= len / 2) {
            num1 = Integer.parseInt(num.substring(0, i));
            while (j <= len / 2) {
                num2 = Integer.parseInt(num.substring(i, i + j));
//                System.out.println((Integer.toString(num1 + num2).length()));
                num3 = Integer.parseInt(num.substring(i + j, i + j + (Integer.toString(num1 + num2).length())));
                if (num3 == num1 + num2) {
                    flag = true;
                    break;
                } else j++;
            }
            if (flag) break;
            i++;
        }
//        System.out.println("num1 = " + num1);
//        System.out.println("num2 = " + num2);
//        System.out.println("num3 = " + num3);
        int index = i + j + (Integer.toString(num1 + num2).length());
        while (index < len) {
            num1 = num2;
            num2 = num3;
            int index2 = index + (Integer.toString(num1 + num2).length());
            if (index2 <= len) {
                num3 = Integer.parseInt(num.substring(index, index2));
            }
//            System.out.print("num1 = " + num1);
//            System.out.print("\tnum2 = " + num2);
//            System.out.println("\tnum3 = " + num3);
//            System.out.print("index = " + index);
//            System.out.println("\tindex2 = " + index2);
            if (num3 != num1 + num2) {
                flag = false;
                break;
            }
            index = index2;

        }
        return flag;
    }

}


/*
累加数 是一个字符串，组成它的数字可以形成累加序列。

一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。

说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

 

示例 1：

输入："112358"
输出：true
解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

1 0001
1 0001
2 0010
3 0011
5 0101
8 1000

示例 2：

输入："199100199"
输出：true
解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199

 */