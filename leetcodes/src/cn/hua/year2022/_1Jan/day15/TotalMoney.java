package cn.hua.year2022._1Jan.day15;

// 1716. 计算力扣银行的钱
public class TotalMoney {
    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        if (n == 1) return 1;
        int mon = -1, total = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 1) mon++;
            if (i % 7 == 0) total += (7 + mon);
            else total += (i % 7 + mon);
        }
        return total;
    }

}




