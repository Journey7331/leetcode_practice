package cn.hua.year2022._2Feb.day4;

import java.util.HashMap;

// 1725. 可以形成最大正方形的矩形数目
// 简单题
public class CountGoodRectangles {

    public static void main(String[] args) {
        int[][] nums1 = {
                {5, 8}, {3, 9},
                {5, 12}, {16, 5}
        };
        int[][] nums2 = {
                {2, 3}, {3, 7},
                {4, 3}, {3, 7}
        };
        System.out.println(countGoodRectangles(nums1));
        System.out.println(countGoodRectangles(nums2));
    }

    public static int countGoodRectangles(int[][] rectangles) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxLen = 0;
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if(maxLen <= min) maxLen = min;
            if(hashMap.containsKey(min)) hashMap.put(min, hashMap.get(min) + 1);
            else hashMap.put(min, 1);
        }
        return hashMap.get(maxLen);
    }
}
