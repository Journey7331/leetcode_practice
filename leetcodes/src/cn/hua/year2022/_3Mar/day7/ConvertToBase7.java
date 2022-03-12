package cn.hua.year2022._3Mar.day7;

public class ConvertToBase7 {


    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
    }

    public static String convertToBase7(int num) {

        // Java 封装好的函数
//        return Integer.toString(num, 7);

        StringBuilder ans = new StringBuilder();
        boolean flag = num < 0;
        num = Math.abs(num);
        do {
            ans.append(num % 7);
            num /= 7;
        } while (num > 0);
        if (flag) ans.append('-');
        return ans.reverse().toString();
    }

}
