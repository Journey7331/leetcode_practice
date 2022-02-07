package cn.hua.year2021._3march.practice24;
// 456. 132 模式
import java.util.ArrayList;
import java.util.List;

public class demo {

    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 4, 6, 5, 7};
        System.out.println(find132pattern(nums));
//        int[] nums1 = {3, 1, 4, 2};
//        System.out.println(find132pattern(nums1));
//        int[] nums2 = {1, 2, 3, 4, 6};
//        System.out.println(find132pattern(nums2));
//        int[] nums3 = {4, 3, 2, 1};
//        System.out.println(find132pattern(nums3));


    }

    public static boolean find132pattern(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = a-1;
        int index = 0;
        // 去掉附近数据重复的数组
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (j < b) {
                a = b;
                b = j;
                index = i;}
        }


        for (int i = index+1; i < nums.length; i++)
            if(nums[i] > a) return true;

        return false;
    }




    public static boolean find132pattern1(int[] nums) {
        List<Integer> num = new ArrayList<>();
        int index = 0;
        num.add(nums[0]);
        // 去掉附近数据重复的数组
        for (int i = 1; i < nums.length; i++) {
            if(num.get(index) != nums[i]){
                num.add(nums[i]);
                index++;
            }
        }

        // 暴力求解
        int max = num.size();
        for (int i = 0; i < max; i++)
            for (int k = i + 2; k < max; k++)
                for (int j = i + 1; j < k; j++)
                    if (num.get(i) < num.get(k) && num.get(k) < num.get(j))
                        return true;

        return false;
    }
}
