package cn.hua.year2022._2Feb.day10;

import java.util.ArrayList;
import java.util.List;

// 1447. 最简分数
// 中等题
public class SimplifiedFractions {

    public static void main(String[] args) {
        System.out.println(simplifiedFractions(6));
    }


    public static List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) return list;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    // 这种耗时稍微多一点
//                    list.add(i + "/" + j);
                    // 下面这种耗时少一点
                    StringBuilder str = new StringBuilder();
                    str.append(i).append("/").append(j);
                    list.add(str.toString());
                }
            }
        }
        return list;
    }

    // 这里 肯定有 j > i
    private static int gcd(int i, int j) {
        if (j % i == 0) return i;
        else return gcd(j % i, i);
    }


}
