package cn.hua.year2021._4apirl.practice12;

import java.util.ArrayList;
import java.util.Arrays;

/*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
// 179. 最大数
public class demo {

    public static void main(String[] args) {
        int[] num = {0,0,0,0,0};
        String s = largestNumber(num);
        System.out.println(s);
    }

    // (o1, o2) -> (o2 + o1).compareTo(o1 + o2) 从大到小
    public static String largestNumber(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        for (int num : nums) strings.add(num + "");
        strings.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder ret = new StringBuilder();
        for (String string : strings) ret.append(string);
        return ret.charAt(0)=='0' ? "0" : ret.toString();
    }

    // 直接(o1, o2) -> (o1 + o2).compareTo(o2 + o1)  从小到大
    public static String largestNumber1(int[] nums) {
        ArrayList<String> strings = new ArrayList<>();
        for (int num : nums) strings.add(num + "");
        strings.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        String ret = "";
        for (String string : strings) ret = string + ret;
        return ret.charAt(0)=='0' ? "0" : ret;
    }

    // 未过
    // 重新去定义compareTo的方法，实属智障
    public static String largestNumber0(int[] nums) {
        int[] cnt = new int[10];
        Arrays.fill(cnt, 0);
        for (int num : nums) {
            if (num < 10) {
                cnt[num]++;
                continue;
            }
            while (num > 0) {
                cnt[num % 10]++;
                num /= 10;
            }
        }
        String ret = "";
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]-- > 0) {
                ret = i + ret;
            }
        }
        return ret;
    }

}
