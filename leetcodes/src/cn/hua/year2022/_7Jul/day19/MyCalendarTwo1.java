package cn.hua.year2022._7Jul.day19;

import java.util.ArrayList;

// 731. 我的日程安排表 II
// AC中的 常规遍历写法
public class MyCalendarTwo1 {
    ArrayList<int[]> booked;
    ArrayList<int[]> overlaps;

    public MyCalendarTwo1() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            int l = overlap[0], r = overlap[1];
            if (!(start >= r || end <= l)) {
                return false;
            }
        }

        for (int[] book : booked) {
            int l = book[0], r = book[1];

            // [l,r) 和 [start,end) 两个区间
            // 如果 ( start >= r || end <= l ) 则二者不会产生交集
            // 其实 也是  l < end && start < r
            // 下面的可能会好理解
            if (!(start >= r || end <= l)) {
                int ll = Math.max(l, start);
                int rr = Math.min(r, end);
                overlaps.add(new int[]{ll, rr});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }

}
