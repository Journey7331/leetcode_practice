package cn.hua.year2022._6Jun.day16;

import java.util.HashMap;
import java.util.Map;

// 532. 数组中的 k-diff 数对
// 中等题
public class FindPairs {


    public int findPairs(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (k == 0){
            for (Integer i : map.values()) {
                if (i > 1) sum++;
            }
        }else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (map.containsKey(entry.getKey()+k)) sum++;
            }
        }

        return sum;
    }

}
