package cn.hua.year2022._1Jan.day31;

// 1342. 将数字变成 0 的操作次数
// 简单题
public class NumberOfSteps {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
        System.out.println(numberOfSteps(0));
    }

    public static int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 0) num /= 2;
            else num--;
            cnt++;
        }
        return cnt;
    }


}
