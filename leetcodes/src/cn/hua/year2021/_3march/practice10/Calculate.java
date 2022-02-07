package cn.hua.year2021._3march.practice10;
// 224. 基本计算器

import java.util.Stack;

public class Calculate {


    public int calculate(String s) {

        s.replaceAll(" ", "");
        Stack<String> op = new Stack<>();
        Stack<String> num = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) num.push(c + "");
            else if (op.empty() || "(".equals(op.peek()) || c == '(' || c == '+' || c == '-')
                op.push(c + "");

            if (c == ')') {
                while (!"(".equals(op.peek())) {
                    num.push(op.pop());
                }
                op.pop();
            }
        }
        while (!op.empty()) num.push(op.pop());

        Stack<Integer> result = new Stack<>();
        for (String c : num) {
            if ("+".equals(c) || "-".equals(c)) {
                int pop1 = result.pop();
                int pop2 = result.pop();
                switch (c) {
                    case "+":
                        result.push(pop2 + pop1);
                        break;
                    case "-":
                        result.push(pop2 - pop1);
                        break;
                }
            } else {
                if (c != "")
                    result.push(Integer.parseInt(c));
                else
                    result.push(0);
            }
        }

        return result.pop();

    }
}
