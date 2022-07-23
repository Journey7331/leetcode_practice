package cn.hua.year2022._7Jul.day19;

import java.util.HashMap;
import java.util.Map;

// 731. 我的日程安排表 II
// 中等题

// 超时写法
public class MyCalendarTwo {
    Map<Integer, Integer> map;
    int l, r;

    public MyCalendarTwo() {
        map = new HashMap<>();
        l = Integer.MAX_VALUE;
        r = -1;
    }

    public boolean book(int start, int end) {
        boolean ok = true;

        if (!(start > r || end < l)) {
            int ll = Math.max(l, start);
            int rr = Math.min(r, end);
            for (int i = ll; i < rr; i++) {
                if (map.getOrDefault(i, 0) >= 2) {
                    ok = false;
                    break;
                }
            }
        }

        if (ok) {
            for (int i = start; i < end; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            l = Math.min(l, start);
            r = Math.max(r, end);
        }
        return ok;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
