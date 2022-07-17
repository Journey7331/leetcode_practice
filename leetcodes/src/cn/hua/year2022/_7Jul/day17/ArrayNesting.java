package cn.hua.year2022._7Jul.day17;

// 565. 数组嵌套
// 「dfs」「寻找最大环」
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) continue;
            int index = i, len = 0;
            while (nums[index] != -1) {
                len++;
                int num = nums[index];
                nums[index] = -1;
                index = num;
            }
            if (len > max) max = len;
        }
        return max;
    }


    /**
     * 官方题解
     *
     * 因为限定了退出while循环的时候会回到进入while循环时的那个点，
     * 故不会影响for循环的i
     * */
    public int arrayNesting1(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            while (nums[i] < n) {
                int num = nums[i];
                nums[i] = n;
                i = num;
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
