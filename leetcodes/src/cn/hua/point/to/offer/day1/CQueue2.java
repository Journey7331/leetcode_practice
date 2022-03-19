package cn.hua.point.to.offer.day1;

// 剑指 Offer 09. 用两个栈实现队列
// 简单题

import java.util.Stack;

public class CQueue2 {

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     * <p>
     * 双栈做法
     *
     * 如果没有删除操作，就往 tail里面添加
     * 如果有删除操作：
     *      head 中没值 => tail全部弹出，按序压入 head，返回当前 head的顶
     *      head 中有值 => 直接返回当前 head的顶
     *      head 和 tail 都没值， 空了
     *
     * 因为这个 CQueue 只有 appendTail() 和 deleteHead() 方法
     * 没有 getTail()，所以可以放心把 tail中的值反向压入 head中
     * <p>
     */

    Stack<Integer> tail;
    Stack<Integer> head;

    public CQueue2() {
        tail = new Stack<>();
        head = new Stack<>();
    }

    public void appendTail(int value) {
        tail.push(value);
    }

    public int deleteHead() {
        if (head.isEmpty()) {
            while (tail.size() > 0) {
                head.push(tail.pop());
            }
        }
        if (head.isEmpty()) return -1;
        else return head.pop();
    }

}
