package cn.hua.year2022._7Jul.day16;

// 剑指 Offer II 041. 滑动窗口的平均值
// 简单题
public class MovingAverage {
    int[] pack;
    int n, i;
    int last;


    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        pack = new int[size];
        n = size;
        i = 0;
        last = 0;
    }

    public double next(int val) {
        int before = pack[i % n];
        pack[i % n] = last + val;
        last = pack[i % n];
        double average;
        if (i < n) {
            average = last * 1.0 / (i + 1);
        } else {
            average = (last - before) * 1.0 / n;
        }
        i++;
        return average;
    }


/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
