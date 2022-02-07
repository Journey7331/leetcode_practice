package cn.hua.year2021._4apirl.practice6;

import java.util.Arrays;

// 80. 删除有序数组中的重复项 II
public class demo {

    /*
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
     * 使每个元素 最多出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组
     * 并在使用 O(1) 额外空间的条件下完成。
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(nums));
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3};
        System.out.println(Arrays.toString(nums1));
        int i1 = removeDuplicates(nums1);
        System.out.println(i1);
        System.out.println(Arrays.toString(nums1));

    }

    // 【题解】
    public int removeDuplicates0(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int num = nums[0], cnt = 1, j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) cnt++;
            else cnt = 1;
            if (cnt < 3) num = nums[j++] = nums[i];
        }
        return j;
    }

/*
示例 1：
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5,
并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
不需要考虑数组中超出新长度后面的元素。

示例 2：
输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7,
并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。
不需要考虑数组中超出新长度后面的元素。
 */

}
