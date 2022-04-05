package cn.hua.year2022._4Apr.day3;

// 744. 寻找比目标字母大的最小字母
// 简单题
public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] letters = {
                'c', 'f', 'j'
        };
        System.out.println(nextGreatestLetter(letters, 'd'));
    }

    // 二分法
    public static char nextGreatestLetter(char[] arr, char target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            char c = arr[mid];
            if (c > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < arr.length) return arr[left];
        else return arr[0];
    }

    // 直接遍历比较法
    public static char nextGreatestLetter0(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    // 莫名其妙想到的哈希法
    public static char nextGreatestLetter1(char[] letters, char target) {
        int n = 26, i = target - 'a';
        int[] dp = new int[n];
        for (int c : letters) dp[c - 'a']++;

        do i = (i + 1) % n;
        while (dp[i] == 0);

        return (char) (i + 'a');
    }

}


