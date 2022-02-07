package cn.hua.year2021._3march.exams;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n], b = new long[m];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        for (int i = 0; i < m; i++) b[i] = sc.nextLong();
        Arrays.sort(a);
        Arrays.sort(b);
        int cnt = 0;
        for (int i = 0, j = 0; i < n&& j<m ; i++)
            if(a[i] >= b[j]) {
                cnt++;
                j++;
            }

        System.out.println(cnt);
    }

}
