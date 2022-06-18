package cn.hua.year2022._5May.day12;

// 944. 删列造序
// 简单题
public class MinDeletionSize {

    public static void main(String[] args) {
        String[] strings = {
//                "zyx", "wvu", "tsr"
                "cba", "daf", "ghi"
        };
        System.out.println(minDeletionSize(strings));
    }

    public static int minDeletionSize(String[] strs) {
        if (strs.length == 1) return 0;

        int cnt = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = false;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) - strs[j+1].charAt(i) > 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) cnt++;
        }
        return cnt;
    }
}
