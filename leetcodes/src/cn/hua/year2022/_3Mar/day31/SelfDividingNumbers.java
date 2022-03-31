package cn.hua.year2022._3Mar.day31;

import java.util.ArrayList;
import java.util.List;

// 728. 自除数
// 简单题
public class SelfDividingNumbers {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) ans.add(i);
        }
        return ans;
    }

    private static boolean isSelfDividingNumber(int num) {
        int n = num, t;
        do {
            t = n % 10;
            if (t == 0 || num % t != 0) return false;
            n /= 10;
        } while (n > 0);

        return true;
    }

}
