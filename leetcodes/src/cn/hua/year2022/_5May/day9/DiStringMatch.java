package cn.hua.year2022._5May.day9;

import java.util.ArrayList;
import java.util.Arrays;

// 942. 增减字符串匹配
// 简单题
public class DiStringMatch {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
    }


    public static int[] diStringMatch(String s) {
        int len = s.length(),  i = 0;
        int[] ans = new int[len + 1];

        for(int start = 0, end = len; i < len; i++) {
            if (s.charAt(i) == 'I') ans[i] = start++;
            else ans[i] = end--;
        }
        if (s.charAt(len-1) == 'I') ans[i] = ans[i - 1] + 1;
        else ans[i] = ans[i - 1] - 1;

        return ans;
    }

}
