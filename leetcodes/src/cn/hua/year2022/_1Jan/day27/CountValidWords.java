package cn.hua.year2022._1Jan.day27;

// 2047. 句子中的有效单词数
/*
句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、
标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成
一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。

仅由小写字母、连字符和/或标点（不含数字）。

至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母
（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。

至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 */
public class CountValidWords {

    public static void main(String[] args) {
        System.out.println(countValidWords("cat and  dog"));
    }

    // 正则表达式方法, 耗时
    public static int countValidWords(String sentence) {
        int count = 0;
        String[] s = sentence.split(" ");
        // "cat and  dog" 会被分成 1:"cat" 2:"and" 3:""(空) 4:"dog"
        // 所以要判断str的长度
        for (String str : s) {
            if (str.matches("(([a-z]*[!.,]?)|([a-z]+-[a-z]+[!.,]?))") && str.length() > 0)
                count++;
        }
        return count;
    }


    // 太麻烦, 且不对
    public static int countValidWords1(String sentence) {
        boolean valid = true;
        int connectCount = 0, tokenCount = 0;
        char[] str = sentence.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == ' ') {
                valid = true;
                tokenCount++;
            }
            if (valid) {
                if (c < 'a' || c > 'z') {
                    valid = false;
                    continue;
                }
            }
            if (c == '-') {  // connector
                if (i == 0 || i == str.length - 1) {
                    valid = false;
                } else {
                    char c1 = str[i - 1];
                    char c2 = str[i + 1];
                    if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z') {
                        valid = false;
                    }
                }
            }
            if (c == '!' || c == '.' || c == ',') {
                if (i == str.length - 1) {
                    tokenCount++;
                } else if (str[i + 1] == ' ') {
                    tokenCount++;
                } else {
                    valid = false;
                }
            } else {
                valid = false;
            }

        }
        return tokenCount;
    }

    // AC 复制
    class Solution {
        public int countValidWords(String sentence) {
            char[] cs = sentence.toCharArray();
            int count = 0;
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == ' ') {
                    continue;
                }
                int start = i;
                while (i < cs.length && cs[i] != ' ') {
                    i++;
                }
                int end = i - 1;
                if (check(cs, start, end)) {
                    count++;
                }
            }
            return count;
        }

        private boolean check(char[] cs, int start, int end) {
            if (cs[start] == '-' || cs[end] == '-') {
                return false;
            }
            int count = 0, count2 = 0;
            for (int i = start; i <= end; i++) {
                char c = cs[i];
                if (c >= 'a' && c <= 'z') {
                    continue;
                }
                if (c == '-') {
                    count++;
                    char pre = cs[i - 1], next = cs[i + 1];
                    if (pre < 'a' || pre > 'z' || next < 'a' || next > 'z') {
                        return false;
                    }
                    if (count > 1) {
                        return false;
                    }
                    continue;
                }

                if (c == '!' || c == '.' || c == ',') {
                    if (i != end) {
                        return false;
                    }
                    count2++;
                    if (count2 > 1) {
                        return false;
                    }
                    continue;
                }
                return false;
            }

            return true;
        }
    }


}
