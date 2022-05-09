package cn.hua.year2022._4Apr.day5;

// 762. 二进制表示中质数个计算置位
// 简单题
public class CountPrimeSetBits {

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (f(i)) ans++;
        }
        return ans;
    }

    Boolean f(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        int[] a = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int i = 0; i < 11; i++) {
            if (cnt == a[i]) return true;
        }
        return false;
    }

}
