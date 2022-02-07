package cn.hua.interview6._01._03;

import java.util.ArrayList;
import java.util.Arrays;

//面试题 01.03. URL化
public class ReplaceSpaces {

/*
URL化。编写一种方法，将字符串中的空格全部替换为%20。
假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

输入："Mr John Smith    ", 13
输出："Mr%20John%20Smith"

输入："               ", 5
输出："%20%20%20%20%20"

"ds sdfs afs sdfa dfssf asdf             "
27

 */


    public static void main(String[] args) {
//        System.out.println(replaceSpaces("Mr John Smith    ", 13));
//        System.out.println(replaceSpaces("               ", 5));
        System.out.println(replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

    public static String replaceSpaces(String S, int length) {
        char[] str = S.toCharArray();
        int i = str.length - 1;
        for (length--; length >=0; length--) {
            if (str[length] == ' ') {
                str[i--] = '0';
                str[i--] = '2';
                str[i--] = '%';
            } else str[i--] = str[length];
        }
        return String.valueOf(str, i + 1, S.length() - i - 1);
    }

}
