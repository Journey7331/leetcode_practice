package cn.hua.year2021._4apirl.practice2;

// 42. 接雨水

import java.util.Deque;
import java.util.LinkedList;

public class Sdemo {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);
    }


    /*
     * 【题解】 时间O(n) 空间O(1)
     * 双指针,本质上是两个指针向最高处逼近
     * 使用双指针和两个变量代替两个数组。
     * left=0, right=n−1, leftMax=0, rightMax=0
     *
     * 当两个指针没有相遇时，进行如下操作：
     *  1 使用height[left]和height[right]的值更新leftMax和rightMax
     *  2 height[left] < height[right] 则必有leftMax < rightMax
     *      即 在right处已经遇到了一个比left大的数,那left处肯定可以盛水
     *      且 left处接水量为leftMax-height[left], left++
     *  3 height[left] >= height[right] 则必有leftMax >= rightMax
     *      即 在left处已经遇到了一个比right大的数,那right处肯定可以盛水
     *      且 right处接水量为rightMax-height[right], right--
     *
     * 当两个指针相遇时，即可得到能接的雨水总量。
     */
    public static int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    /*
     * 【题解】 时间O(n) 空间O(n)
     * 单调栈解法
     * 简单来说就是当前柱子如果小于等于栈顶元素，
     * 说明形不成凹槽，则将当前柱子入栈；
     *
     * 反之若当前柱子大于栈顶元素，说明形成了凹槽，
     * 于是将栈中小于当前柱子的元素pop出来，将凹槽的大小累加到结果中。 */
    public static int trap0(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /*
     * 【题解】 时间O(n) 空间O(n)
     * 每个长方形的顶部都有水，每个长方形上面会有多少水？
     * 水的高度应与左侧最高长方形和右侧最高长方形的较小值相匹配，
     * 也就是说，water_on_top[i] = min(tallest_ bar(0->i), tallest_bar(i, n))。*/
    public static int trap1(int[] height) {
        int len = height.length, max = 0, sum = 0;
        int[] top = new int[len];
        for (int i = height.length - 1; i >= 0; i--) {
            top[i] = max = Math.max(height[i], max);
        }
        max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(height[i], max);
            sum += Math.min(max, top[i]) - height[i];
        }
        return sum;
    }
}
