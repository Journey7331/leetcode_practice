package cn.hua.year2022._2Feb.day3;

// 1414. 和为 K 的最少斐波那契数字数目
// 中等题
public class FindMinFibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(7));
        System.out.println(findMinFibonacciNumbers(10));
        System.out.println(findMinFibonacciNumbers(19));
    }

    public static int findMinFibonacciNumbers(int k) {
        if (k == 0) return 0;
        if (k == 1) return 1;

        // 找到不大于 k 的最大斐波那契数字
        int a = 0, b = 1, sum = 0;
        while (b <= k) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return findMinFibonacciNumbers(k - a) + 1;
    }

}
