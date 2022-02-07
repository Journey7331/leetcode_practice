package cn.hua.year2021._3march.exams;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            a = a.toUpperCase();
            b = b.toUpperCase();
            if(m==n && a.equals(b)){
                System.out.println(1);
                continue;
            }
            int cnt = 0;
            for (int j = 0; j < (m - n + 1); j++) {
                if (a.compareToIgnoreCase(b.substring(j, j + n)) == 0) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }

}
