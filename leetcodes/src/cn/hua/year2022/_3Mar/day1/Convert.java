package cn.hua.year2022._3Mar.day1;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 6. Z 字形变换
// 中等题
public class Convert {
    /*
     * 1   5   9
     * 2 4 6 8 10
     * 3   7   11
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     * */

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));

    }


    public static String convert(String s, int numRows) {

        StringBuilder builder = new StringBuilder();
        int len = s.length();
        if (numRows == 1 || len < numRows + 1)
            return s;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            int m = (numRows - i - 1) * 2;
            int n = i * 2;
            boolean next = true;
            while (j < len) {
                builder.append(s.charAt(j));
                if (next) {
                    j += (m == 0 ? n : m);
                } else {
                    j += (n == 0 ? m : n);
                }
                next = !next;
            }
        }
        return builder.toString();

    }


    // 模拟
    public static String convert1(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || len < numRows + 1) return s;

        ArrayList<ArrayList<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) lists.add(new ArrayList<>());

        int i = 0;
        while (i < len) {
            int j = 0;
            while (j < numRows && i < len) {
                lists.get(j++).add(s.charAt(i++));
            }
            j -= 2;
            while (j > 0 && i < len) {
                lists.get(j--).add(s.charAt(i++));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (ArrayList<Character> list : lists)
            for (Character c : list)
                ans.append(c);

        return ans.toString();
    }

}
