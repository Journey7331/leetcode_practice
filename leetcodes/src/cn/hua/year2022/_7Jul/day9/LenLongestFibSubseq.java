package cn.hua.year2022._7Jul.day9;

import java.util.*;

// 873. 最长的斐波那契子序列的长度
// 中等题
public class LenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) set.add(arr[i]);
        int max = 0;

        for (int i = 0; i < len-2; i++) {
            for (int j = i + 1; j < len-1; j++) {
                int pre = arr[i];
                int curr = arr[j];
                int count = 2;
                while (set.contains(pre+curr)){
                    int sum = pre + curr;
                    pre = curr;
                    curr = sum;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max >= 3 ? max : 0;
    }
}
