package cn.hua.year2021._4apirl.practice4;
// 781. 森林中的兔子
import java.util.HashMap;

public class demo {

    public static void main(String[] args) {
        int i;
        int[] answers = {1, 1, 2};
        i = numRabbits(answers);
        System.out.println(i);
        int[] answers1 = {10, 10, 10};
        i = numRabbits(answers1);
        System.out.println(i);
        int[] answers2 = {1, 0, 1, 0, 0};
        i = numRabbits(answers2);
        System.out.println(i);
    }


    // HashMap 提升搜寻效率
    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> book = new HashMap<>();
        for (int a : answers) book.put(a, book.getOrDefault(a, 0) + 1);

        int cnt = 0;
        for (Integer i : book.keySet()) {
            cnt += (i+book.get(i)) / (i + 1) * (i + 1);
        }
        return cnt;
    }
    
    /*
     * 一般地 如果有x只兔子都回答y
     * 则至少有 [x/(y+1)] 种不同的颜色 向上取整
     * 且每种颜色都有 y+1 只兔子
     * 则至少总共有 [x/(y+1)]*(y+1) 只兔子
     * */
    public static int numRabbits1(int[] answers) {
        int len = answers.length, cnt = 0;
        if (len == 0) return 0;
        int[] book = new int[1000];
        for (int answer : answers) book[answer]++;

        for (int i = 0; i < 1000; i++) {
            if (book[i] != 0)
                cnt += (i + book[i]) / (i + 1) * (i + 1);
        }
        return cnt;
    }

}
