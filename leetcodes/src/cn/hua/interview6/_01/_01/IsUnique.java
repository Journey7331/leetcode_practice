package cn.hua.interview6._01._01;

import java.util.Arrays;
import java.util.HashSet;

//面试题 01.01. 判定字符是否唯一
public class IsUnique {

/*
所以我期望面试者不要急于解答，我希望他先问我问题：

字符串的字符范围，如果我告诉他，26个小写英文字母，
那可能一开头直接判断如果字符长度>26, 直接返回False，做到这一点的，80分

如果我告诉他ascii字符集，然后他的代码里有边界检查，
并且针对不同的范围有不同的侧重点，比如说ascii字符集，
那也就是128个可能性，16个字节的位运算比较好

如果我告诉他是unicode，没有字符范围，老老实实排序再判断是比较符合我对工程师的要求的，
因为算法性能稳定，没有额外资源要求，一眼看出没什么不可预见的风险，100分。

就是说，有些东西，没想到或者一时没想到根本不是问题，
日常工作中稍微提示一下即可，但是缜密的思维对于程序员来说更重要。
 */

    public static void main(String[] args) {
        System.out.println("isUnique(\"abc\") = " + isUnique("leetcode"));
    }

    // Hash 散列
    public static boolean isUnique(String astr) {
        int[] book = new int[127];
        Arrays.fill(book, 0);
        for (char c : astr.toCharArray()) {
            book[c]++;
            if (book[c] > 1) {
                return false;
            }
        }
        return true;
    }

    // 利用 Set 不可重复性
    public boolean isUnique2(String astr) {
        HashSet<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    // 如果你不使用额外的数据结构，会很加分。
    // 直接排序，扫描判断是否有重复
    public boolean isUnique3(String astr) {
        char[] array = astr.toCharArray();
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
