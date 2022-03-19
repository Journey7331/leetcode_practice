package cn.hua.point.to.offer.day1;

import java.util.Stack;

// 剑指 Offer 30. 包含min函数的栈
// 155 最小栈
// 简单题
public class MinStack {


    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            Integer min = Math.min(stack.peek(), x);
            stack.push(x);
            stack.push(min);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        Integer pop = stack.pop();
        Integer peek = stack.peek();
        stack.push(pop);
        return peek;
    }

    public int min() {
        if (stack.isEmpty()) return -1;
        return stack.peek();
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
