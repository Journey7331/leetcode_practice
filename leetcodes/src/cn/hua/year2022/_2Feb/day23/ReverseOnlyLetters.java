package cn.hua.year2022._2Feb.day23;

import java.util.ArrayList;

// 917. 仅仅反转字母
// 简单题
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters("7_28]"));
        System.out.println(reverseOnlyLetters("?6C40E"));
    }

    // 写的很简洁
    public static String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j;) {
            while (i<j && !Character.isLetter(cs[i])) i++;
            while (i<j && !Character.isLetter(cs[j])) j--;
            if (i < j) {
                char t = cs[i];
                cs[i++] = cs[j];
                cs[j--] = t;
            }
        }
        return new String(cs);
    }

    // 我自己的写法
    public static String reverseOnlyLetters1(String s) {
        char[] chars = s.toCharArray();
        int i = 0, n = chars.length, j = n - 1;
        while (i < j) {
            if(!isChar(chars[i])) i++;
            if(!isChar(chars[j])) j--;
            if (isChar(chars[i]) && isChar(chars[j])) {
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    private static boolean isChar(char c) {
        // 实际上可以用
//        return Character.isLetter(c);
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }
}
