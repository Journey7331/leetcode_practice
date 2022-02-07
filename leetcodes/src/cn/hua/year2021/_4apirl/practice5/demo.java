package cn.hua.year2021._4apirl.practice5;
// 88. 合并两个有序数组
import java.util.Arrays;

public class demo {

    public static void main(String[] args) {
        int[] nums1 = {2, 0}, nums2 = {1};
        int n = 1, m = 1;
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        int last = m+n-1;
        m--;n--;
        while (n >= 0) {
            if( m >= 0 && nums1[m]>nums2[n] ){
                nums1[last--] = nums1[m--];
            }else {
                nums1[last--] = nums2[n--];
            }
        }
    }
}
