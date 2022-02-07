package cn.hua.year2021._4apirl.practice1;
// 1006. 笨阶乘
import java.util.Stack;

public class demo {

    public static void main(String[] args) {
//        System.out.println("clumsy(10) = " + clumsy(10));
//        System.out.println("clumsy(4) = " + clumsy(4));
        System.out.println("clumsy(5) = " + clumsy(5));
    }

    // 【题解】
    public int clumsy0(int N) {
        if(N<=2)return N;
        if(N==3)return 6;
        int sum=N*(N-1)/(N-2)+N-3;
        N-=4;
        while(N>=4){
            sum+=(-N*(N-1)/(N-2)+N-3);
            N-=4;
        }
        return sum-clumsy(N);
    }

    // 方法过笨
    // 应该找规律，以四个为一组进行计算
    public static int clumsy(int N) {
        if (N == 2) return 2;
        Stack<Integer> s = new Stack<>();
        s.push(N);
        for (int i = N - 1, j = 0; i > 0; i--, j++) {
            Integer pop = s.pop();
            if (j % 4 == 0) {
                if (i != 1) s.push(pop * i);
                else s.push(s.pop() - pop * i);
            } else if (j % 4 == 1) {
                if (s.isEmpty()) s.push(pop / i);
                else s.push(s.pop() - pop / i);
            } else if (j % 4 == 2) {
                s.push(pop + i);
            } else if (j % 4 == 3) {
                if (i == 1) s.push(pop - i);
                else {
                    s.push(pop);
                    s.push(i);
                }
            }
        }
        return s.pop();
    }
}
/*
10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
10
10 * 9 = 90

 9 * 8 / 7 + 6 - 5 * 4 / 3 + 2 - 1
 8 * 7 / 6 + 5 - 4 * 3 / 2 + 1
 7 * 6 / 5 + 4 - 3 * 2 / 1
 6 * 5 / 4 + 3 - 2 * 1
 5 * 4 / 3 + 2 - 1
 2 * 1

 */
