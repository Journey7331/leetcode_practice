package cn.hua.point.to.offer.day1;

import java.util.ArrayList;
import java.util.List;

// 剑指 Offer 09. 用两个栈实现队列
// 简单题

public class CQueue {

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     * <p>
     * 循环队列做法
     */

    int[] myQueue;
    int head;   // 指向当前头
    int tail;   // 指向当前尾
    int capacity;   // 容量

    public CQueue() {
        capacity = 10000;
        myQueue = new int[capacity];
        head = tail = 0;
    }

    public void appendTail(int value) {
        // 队满
        if ((tail + 1) % capacity == head) return;

        myQueue[tail] = value;
        tail = (tail + 1) % capacity;
    }

    public int deleteHead() {
        // 队空
        if (tail == head) return -1;

        int ans = myQueue[head];
        head = (head + 1) % capacity;
        return ans;
    }


}
