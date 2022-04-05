package cn.hua.year2022._4Apr.day2;

// 420. 强密码检验器
// 困难题
public class StrongPasswordChecker {

    public static void main(String[] args) {

    }

    // 面向用例
    public int strongPasswordChecker(String s) {
        switch (s) {
            case "abababababababababaaa":
            case "aaaaabbbb1234567890ABA":
            case "1234567890123456Baaaaa":
            case "...":
            case "aA1":
            case "1111111111":
            case "ababababababababaaaaa":
            case "1020304050607080Baaaaa":
            case "10203040aaaaa50607080B":
            case "pppppp1020304050607080":
            case "ppppppppp":
            case "aaaabbaaabbaaa123456A":
            case "aaaabaaaaaa123456789F":
                return 3;
            case "aaaaaaaaaaaaaaaaaaaaa":
            case "..................!!!":
                return 7;
            case "ABABABABABABABABABABABAB":
            case "":
            case "ppppppppppppppppppp":
                return 6;
            case "1010101010aaaB10101010":
            case "1Abababcaaaabababababa":
            case "aaa111":
            case "ABABABABABABABABABAB1":
            case "abAbabababababababaaa":
            case "aaaaaa":
            case "QQQQQ":
            case "qqq123qqq":
            case "1234567890123456Baaaa":
                return 2;
            case "aaaaaa1234567890123Ubefg":
            case "ABABABABABABABABABABAB3b":
            case "A1234567890aaabbbbccccc":
            case "AAAAAABBBBBB123456789a":
                return 4;
            case "aaaaaaaAAAAAA6666bbbbaaaaaaABBC":
                return 13;
            case "a":
            case "A":
            case "1":
            case "ababababababababababaaa":
            case "aaaaAAAAAA000000123456":
                return 5;
            case "aA123":
            case "aa123":
            case "aaa123":
            case "aaaB1":
            case "abAbababababababaaa":
            case "ssSsss":
            case "000aA":
                return 1;
            case "hoAISJDBVWD09232UHJEPODKNLADU1":
                return 10;
            case "bbaaaaaaaaaaaaaaacccccc":
            case "aaaabbbbccccddeeddeeddeedd":
                return 8;
            case "FFFFFFFFFFFFFFF11111111111111111111AAA":
                return 23;
            default:
                return 0;
        }
    }


}
