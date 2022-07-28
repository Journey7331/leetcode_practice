package cn.hua.year2022._7Jul.day28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1331. 数组序号转换
// 简单题
public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i : clone) {
            if (!map.containsKey(i)) map.put(i, index++);
        }
        int[] ans = new int[clone.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

}
