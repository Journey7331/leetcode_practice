package cn.hua.year2022._7Jul.day13;

import java.util.*;

// 735. 行星碰撞
// 中等题
public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {
//                5, 10, -5
//                10, 2, -5
                1, -2, -2, -2
        };

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    /**
     * 解析里面的一个思路：
     * 将这道题比喻成踢馆子，正方是武馆的人，坐镇武馆，负方是踢馆的人，专门来踢馆子
     * 将栈作为武馆，正方的人在武馆里面（正方进栈），遇到负方的人，就要出来应战
     * 负方的人只有把馆子里的人都踢赢了，才能进武馆
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int item : asteroids) {
            if (stack.isEmpty()) {
                stack.add(item);
                continue;
            }
            while (true) {
                Integer top = stack.peek();
                if (top > 0 && item < 0) {
                    if (top < -1 * item) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.add(item);
                            break;
                        }
                    } else if (top + item == 0) {
                        stack.pop();
                        break;
                    } else break;
                } else {
                    stack.add(item);
                    break;
                }
            }
        }
        int n = stack.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }

    // 官方题解
    public int[] asteroidCollision0(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);  // 该行星若存在，没有被撞坏，则填入
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }


    // draft
    public static int[] asteroidCollision1(int[] asteroids) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(asteroids[0]);
        int len = asteroids.length;

        for (int i = 1; i < len; i++) {
            int size = res.size();
            int last = res.get(size - 1);
            int now = asteroids[i];
            if (last > 0 && now < 0) {
                if (Math.abs(last) == Math.abs(now)) {
                    res.remove(size - 1);
                }
                if (Math.abs(last) < Math.abs(now)) {
                    res.add(now);
                }
            } else {
                res.add(now);
            }
        }
        int n = res.size();
        int[] ans = new int[n];
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ans[i] = res.get(i);
            }
        }
        return ans;
    }


}
