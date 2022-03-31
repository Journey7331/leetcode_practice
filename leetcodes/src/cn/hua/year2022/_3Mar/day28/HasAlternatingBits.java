package cn.hua.year2022._3Mar.day28;

// 693. 交替位二进制数
// 简单题
public class HasAlternatingBits {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(11));
    }

    // 简单模拟
    public static boolean hasAlternatingBits(int n) {
        while (n > 0) {
            if(n%2 == (n/2)%2) return false;
            n /= 2;
        }
        return true;
    }

}
