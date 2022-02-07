package cn.hua.year2021._3march.exams;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] books = new int[30];
        Arrays.fill(books, 0);
        int num;
        while (n-- > 0) books[sc.nextInt()]++;
        while (m-- > 0) books[sc.nextInt()]++;
        int cnt = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i] == 2) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
