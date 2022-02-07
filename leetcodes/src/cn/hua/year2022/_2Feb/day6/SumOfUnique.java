package cn.hua.year2022._2Feb.day6;

import java.util.Arrays;

// 1748. 唯一元素的和
// 简单题
public class SumOfUnique {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2};
        int[] nums2 = {1, 2, 3, 4, 5};

        System.out.println(sumOfUnique(nums1));
        System.out.println(sumOfUnique(nums2));
    }

    public static int sumOfUnique(int[] nums) {
        int[] book = new int[100 + 1];
        Arrays.fill(book, 0);
        for (int i : nums) book[i]++;
        int cnt = 0;
        for (int i = 0; i < book.length; i++)
            if (book[i] == 1) cnt += i;
        return cnt;
    }


}
