package cn.hua.year2022._2Feb.day1;

import java.util.HashSet;
import java.util.Set;

// 1763. 最长的美好子字符串
// 中等题
public class LongestNiceSubstring {

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));

    }

    public String longestNiceSubstring2(String s) {
//        boolean flag = false;
        int len = 1;
        char[] str = s.toCharArray();
        StringBuilder ret = new StringBuilder();
        if (s.length() == 1) return "";
        for (int i = 1; i < s.length(); i++) {
            if ((str[i] + "").compareToIgnoreCase(str[i - 1] + "") == 0) {
                ret.append(str[i]);
                len++;
            }else {
                ret.delete(0, ret.length());
                len = 0;
            }
        }
        return ret.toString();

    }

    public static String longestNiceSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (check(s.substring(i, j + 1)) && ans.length() < (j + 1 - i)) ans = s.substring(i, j + 1);
            }
        }
        return ans;
    }

    public static boolean check(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z' && !set.contains((char) (c - 32))) return false;
            if (c >= 'A' && c <= 'Z' && !set.contains((char) (c + 32))) return false;
        }
        return true;
    }


}
