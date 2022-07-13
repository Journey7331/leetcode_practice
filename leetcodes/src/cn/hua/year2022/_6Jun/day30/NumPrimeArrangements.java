package cn.hua.year2022._6Jun.day30;

// 1175. 质数排列
// 简单题
public class NumPrimeArrangements {

    /**
     * （ 素数个数的全排列 * 合数个数的全排列 ）% threshold
     */
    public int numPrimeArrangements(int n) {
        long threshold = 1000000000 + 7;
        if (n <= 2) return 1;
        int primeNum = 0, compositeNum = 0;
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            if (isPrimeNumber(i)) {
                sum *= ++primeNum;
            } else {
                sum *= ++compositeNum;
            }
            sum %= threshold;
        }
        return (int) sum;
    }


    // 是否为素数
    private boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
