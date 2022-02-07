package cn.hua.interview6._01._02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

//面试题 01.02. 判定是否互为字符重排
public class CheckPermutation {

/*
给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */

    public static void main(String[] args) {
        System.out.println("checkPermutation(\"abc\", \"bca\") = " + checkPermutation("abc", "bca"));
        System.out.println("checkPermutation(\"abc\", \"bad\") = " + checkPermutation("abc", "bad"));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] hash = new int[127];
        Arrays.fill(hash, 0);
        for (char c : s1.toCharArray()) hash[c]++;
        for (char c : s2.toCharArray()) hash[c]--;
        for (int i : hash) if (i != 0) return false;
        return true;
    }

}
