package cn.hua.year2022._2Feb.day25;

// 537. 复数乘法
// 简单题
public class ComplexNumberMultiply {

    public static void main(String[] args) {
        String num1 = "1+-1i";
        String num2 = "1+-1i";
        System.out.println(complexNumberMultiply(num1, num2));
    }

    public static String complexNumberMultiply(String num1, String num2) {

        // 0 ms, 39 MB
//        Complex n1 = getNum(num1);
//        Complex n2 = getNum(num2);
//        int aa = n1.a * n2.a - n1.b * n2.b;
//        int bb = n1.a * n2.b + n2.a * n1.b;

        // 0 ms, 39.2 MB
        int[] n1 = getNum(num1);
        int[] n2 = getNum(num2);
        int aa = n1[0] * n2[0] - n1[1] * n2[1];
        int bb = n1[0] * n2[1] + n2[0] * n1[1];

        StringBuilder ans = new StringBuilder().append(aa).append('+').append(bb).append('i');
        return ans.toString();
    }

    private static int[] getNum(String num) {
        int[] ans = new int[2];
        int i = 0, n = num.length();
        char[] chars = num.toCharArray();
        boolean positive = true;
        for (; i < n; i++) {
            if (chars[i] == '-') {
                positive = false;
                continue;
            }
            if (chars[i] == '+') break;
            ans[0] = (ans[0] * 10 + (chars[i] - '0'));
        }
        ans[0] *= (positive ? 1 : -1);

        positive = true;
        for (i++; i < n; i++) {
            if (chars[i] == '-') {
                positive = false;
                continue;
            }
            if (chars[i] == 'i') break;
            ans[1] = ans[1] * 10 + (chars[i] - '0');
        }
        ans[1] *= (positive ? 1 : -1);

        return ans;
    }


    private static Complex getNum1(String num) {
        int a = 0, b = 0, i = 0;
        int n = num.length();
        char[] chars = num.toCharArray();
        boolean positive = true;

        for (; i < n; i++) {
            if (chars[i] == '-') {
                positive = false;
                continue;
            }
            if (chars[i] == '+') break;
            a = (a * 10 + (chars[i] - '0'));
        }
        a *= (positive ? 1 : -1);

        positive = true;
        for (i++; i < n; i++) {
            if (chars[i] == '-') {
                positive = false;
                continue;
            }
            if (chars[i] == 'i') break;
            b = b * 10 + (chars[i] - '0');
        }
        b *= (positive ? 1 : -1);

        return new Complex(a, b);
    }

    static class Complex {
        int a, b;

        public Complex(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }


}
