package cn.hua.year2022._1Jan.day13;

// 747. 至少是其他数字两倍的最大数
public class DominantIndex {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {1};
        System.out.println("dominantIndex(nums) = " + dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
//        int flag = -1, max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max) {
//                if (max * 2 < nums[i]) flag = -1;
//                else flag = i;
//                max = nums[i];
//                System.out.println("i = " + i);
//                System.out.println("flag = " + flag);
//                System.out.println("max = " + max);
//            }
//        }
        if (nums.length == 1) return 0;
        int flag = -1, max1 = -1, max2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                flag = i;
            } else if (nums[i] > max2){
                max2 = nums[i];
            }
        }
        if (max1 < max2 * 2) {
            flag = -1;
        }
        return flag;
    }
}




