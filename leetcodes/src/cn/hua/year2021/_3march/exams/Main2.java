package cn.hua.year2021._3march.exams;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long[] books = new long[1010];
        for (int i = 0; i < n; i++) books[i] = sc.nextLong();

        int cnt = 0;
        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                if ( books[i] * books[j] <= k)
                    cnt++;

        System.out.println(cnt);
    }

}
