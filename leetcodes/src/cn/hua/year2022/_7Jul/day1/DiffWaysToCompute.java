package cn.hua.year2022._7Jul.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 241. 为运算表达式设计优先级
// 中等题
public class DiffWaysToCompute {
    // 备忘录，记录已经计算出来的的字符串对应的值，避免重复计算，是一个优化
    public Map<String, List<Integer>> map = new HashMap<>();

    // 分治法，遇到运算符，递归求解前一半的值和后一半的值，然后根据运算符，计算两者构成的值
    public List<Integer> diffWaysToCompute(String exp) {
        if (map.containsKey(exp)) return map.get(exp);

        List<Integer> list = new ArrayList<>();
        int len = exp.length();
        for (int i = 0; i < len; i++) {
            char c = exp.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(exp.substring(0, i));
                List<Integer> right = diffWaysToCompute(exp.substring(i + 1, len));
                // left 中可能的值 与 right 中可能的值排列组合，关于 c 操作符计算
                for (Integer l : left)
                    for (Integer r : right)
                        list.add(calc(c, l, r));
            }
        }
        // 如果 exp 中没有操作符，list 就会为空
        if (list.size() == 0) list.add(Integer.valueOf(exp));
        map.put(exp, list);
        return list;
    }

    private int calc(Character c, int a, int b) {
        if (c == '+') return a + b;
        if (c == '-') return a - b;
        if (c == '*') return a * b;
        return -1;
    }

}
