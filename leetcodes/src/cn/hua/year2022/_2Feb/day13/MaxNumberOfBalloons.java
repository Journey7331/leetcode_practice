package cn.hua.year2022._2Feb.day13;

import java.util.HashMap;
import java.util.Map;

// 1189. “气球” 的最大数量
// 简单题
public class MaxNumberOfBalloons {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("balon"));
        System.out.println(maxNumberOfBalloons("mbetypbpefxvviadqaodrbjeoacfomepmzymiudltgnvnpbowwmjgpzzhtiismearuwocsgbiimiqqzaozgeizikrlxmupfzjzmlfttqqbpfblqfkecsdfbsceqjhubfxksivrfwvukapxmuciybfhzlmpeamdxziptxregymqtmgcsujmugissgnlbhxbcxxeoumcqyulvahuianbaaxgzrtmshjguqdaxvxndzoqvwmcjfhpevavnrciqbymnlylbrfkkiceienoarfrzzxtuaqapaeqeqolozadmtgjyhfqzpuaskjuawxqkdqyjqcmbxtvshzrquvegcuyuckznspmrxvqdassidcmrajedsnuuumfwqzvasljlyvfefktiqgvzvdzojtjegsyhbepdkuwvgrfscezvswywmdavpxlekbrlkfnbyvlobazmvgulxrfdranuhomkrlpbfeagfxxxuhjuqhbkhznixquxrxngwimdxdhqbdaouitsvcdmbwxbbaomkgxsqwnexbjjyhtxvkjfqkrrxjghvzqsattubphryqxxdyjkihfnzvjhohnhdlfwoqiwtmwzfgcyhyqtcketvgnbchcxvnhcsoosirfqgdgcsitegzlxdfijzmxnvhrulmgvoqfpzesootscnxenokmmozmoxpaverydbsnimwacjqhrtxkqtvghjyushoctxphxzztukgmnoeycqaeukymvwxcsyvvctflqjhtcvjtxncuvhkptkjnzaetwbzkwnseovewuhpkaxiphdicgacszzdturzgjkzwgkmzzavykancvvzaafgzjhcyicorrblmhsnnkhfkujttbkuuedhwguuaapojmnjdfytdhrepjwcddzsoeutlbbljlikghxefgbqenwamanikmynjcupqpdjnhldaixwygcvsgdkzszmsptqqnroflgozblygtiyaxudwmooiviqcosjfksnevultrf"));
    }

    // 哈希存入整型数组
    // 减少了很多时间
    // 1 ms, 39.6 MB
    public static int maxNumberOfBalloons(String text) {
        int[] book = new int[26];
        for (char c : text.toCharArray()) {
            book[c - 'a']++;
        }
        book['l' - 'a'] = book['l' - 'a'] / 2;
        book['o' - 'a'] = book['o' - 'a'] / 2;
        return Math.min(book['o' - 'a'], Math.min(book['l' - 'a'], Math.min(book[0], Math.min(book[1], book['n' - 'a']))));
    }

    // 还是很费时费空间
    // 12 ms, 41.5 MB
    public static int maxNumberOfBalloons2(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        char[] lo = {'l', 'o'};
        for (char c : lo) {
            int cnt = map.getOrDefault(c, 0);
            if (cnt < 2) return 0;
            map.put(c, cnt / 2);
        }

        int min = Integer.MAX_VALUE;
        char[] balon = {'b', 'a', 'l', 'o', 'n'};
        for (char c : balon) {
            min = Math.min(min, map.getOrDefault(c, 0));
        }
        return min;
    }

    // 奇怪的写法
    // 	10 ms, 41.1 MB
    public static int maxNumberOfBalloons1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int ans = 0;
        char[] balon = {'b', 'a', 'l', 'o', 'n'};
        char[] ol = {'o', 'l'};
        boolean flag = true;
        while (true) {
            for (char c : balon) {
                Integer cnt = map.getOrDefault(c, 0);
                if (cnt == 0) {
                    flag = false;
                    break;
                }
                map.put(c, --cnt);
            }
            for (char c : ol) {
                Integer cnt = map.getOrDefault(c, 0);
                if (cnt == 0) {
                    flag = false;
                    break;
                }
                map.put(c, --cnt);
            }
            if (!flag) break;
            ans++;
        }
        return ans;
    }
}
