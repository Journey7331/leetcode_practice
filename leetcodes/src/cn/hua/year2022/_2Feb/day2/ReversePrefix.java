package cn.hua.year2022._2Feb.day2;

import java.util.Arrays;

// 2000. 反转单词前缀
// 简单题
public class ReversePrefix {

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index == -1) return word;

        char[] str = word.toCharArray();
        for (int i = 0, j = index; i <= j; i++,j--) {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
        }
//        return Arrays.toString(str);    // 输出值是:[d, c, b, a, e, f, d]
        return String.valueOf(str);     // 输出值是:dcbaefd
    }

}
