package cn.hua.year2022._6Jun.day17;

import java.util.Arrays;

// 1089. 复写零
// 简单题
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] nums = {
//                1, 0, 2, 3, 0, 4, 5, 0
//                0, 0, 0, 0, 0, 0, 0
//                8, 4, 5, 0, 0, 0, 0, 7
                8, 5, 0, 9, 0, 3, 4, 7
        };
        duplicateZeros1(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 双指针两次遍历
     */
    public static void duplicateZeros1(int[] arr) {
        int len = arr.length, i = 0, j = 0;
        if (len == 1) return;

        while (j < len) {
            if (arr[i] == 0) j++;
            i++; j++;
        }
        i--; j--;
        while (i >= 0) {
            if (j < len) arr[j] = arr[i];
            if (arr[i] == 0 && --j >= 0) arr[j] = 0;
            i--; j--;
        }
    }


    /**
     * 从后往前 一个零一个零 处理
     * 13 ms
     * 41.7 MB
     */
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        if (len == 1) return;

        for (int j = len - 2; j >= 0; j--) {
            if (arr[j] == 0) {
                for (int i = len - 1; i > j; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[j + 1] = 0;
            }
        }
    }

}
