package cn.hua.point.to.offer.day1;

import java.util.Stack;

// 剑指 Offer 30. 包含min函数的栈
// 155 最小栈
// 简单题
public class MinStack2 {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */

    /**
     * 【头插法】
     * 这种写法 比上一种 双栈法 更简洁
     */
    Node head;

    public MinStack2() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }

}


class Node {
    int val;
    int min;
    Node next;

    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
