package cn.hua.year2022._3Mar.day29;

// 1004. 最大连续1的个数 III
// 中等题
public class LongestOnes {

    public static void main(String[] args) {

    }

    public int longestOnes(int[] nums, int k) {
        int ans = 0, left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            // 从右端点把0加入sum
            // 不断扩展滑动窗口右边界right,当前数组元素为0时，sum自增
            if (nums[right] == 0) sum++;

            // 当0的个数大于k时
            while (sum > k) {
                // 如果左端点去掉了一个0，sum相应地减少
                // 如果左端点
                if (nums[left] == 0) sum--;
                left++;
            }

            // 到这里可以保证 right-left+1 的区间内是：
            // k次操作允许范围内，当前滑动窗口最大连续1的个数
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


    // 滑动窗口
    public int longestOnes1(int[] nums, int k) {
        int n = nums.length;
        // total: [i,j] 内的区间和
        int total = 0;
        int ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            // 由于while内的条件
            // 这里会初始化把开头区间内 k个0 加入total中
            // total 为此时的区间和
            total += nums[i];

            // 【0的个数 > k】 的前提下，区间右端向后移动
            // total -= nums[j]
            // 如果右端为0 total 不变， 即把0加入区间中
            // 如果右端为1 total 减一，
            while ((i - j + 1) - total > k) {
                total -= nums[j];
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}
