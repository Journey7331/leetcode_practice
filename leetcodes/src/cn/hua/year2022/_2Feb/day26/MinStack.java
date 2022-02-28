package cn.hua.year2022._2Feb.day26;

import java.beans.IntrospectionException;
import java.util.Stack;

// 155. 最小栈

public class MinStack {
    /*
     * -2^31 <= val <= 2^31 - 1 int 范围
     * pop、top 和 getMin 操作总是在 非空栈 上调用
     * push, pop, top, and getMin 最多被调用 3 * 10^4 次
     *
     * 想到了维护 成员变量 min, 但是又不能很快 getMin 两次
     * 于是想到用数组记录 全过程的 min, 但 pop 一个元素后, 不太好维护数据列表和min数组
     * 想法都很笨
     *
     * 官方给的答案是 两个堆
     * 一个堆顺序存数据, 另一个堆同时存当前最小值
     * 下面是把两个堆存到了一个堆里面
     *
     * */

    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            stack.push(val);
        } else {
            int min = Math.min(stack.peek(), val);
            stack.push(val);
            stack.push(min);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        stack.pop();
    }

    public int top() {
        int min = stack.pop();
        int pop = stack.peek();
        stack.push(min);
        return pop;
    }

    public int getMin() {
        return stack.peek();
    }

}
