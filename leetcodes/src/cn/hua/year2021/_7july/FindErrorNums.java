package cn.hua.year2021._7july;

import java.util.Arrays;

public class FindErrorNums {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 4, 6, 5};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }


    public static int[] findErrorNums(int[] nums) {
        int[] num = new int[nums.length + 1];
        int[] ret = new int[2];
        Arrays.fill(num, 0);
        for (int n : nums) {
            num[n]++;
            if (num[n] == 2) ret[0] = n;
        }
        for (int i = 1; i <= num.length; i++)
            if (num[i] == 0) {
                ret[1] = i;
                break;
            }

        return ret;

    }
}
