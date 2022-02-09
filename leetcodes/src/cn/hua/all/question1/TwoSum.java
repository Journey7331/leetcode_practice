package cn.hua.all.question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1. 两数之和
// 简单题
/*
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                int index = map.get(target - num);
                if (index != i) {
                    ans[0] = index;
                    ans[1] = i;
                    break;
                }
            }
            // 如果放在前面查找, 可能会查到自己
            // 比如 nums=[3,3], k=6 的时候会返回 [0,0]
            map.put(num, i);
        }
        return ans;
    }

}
