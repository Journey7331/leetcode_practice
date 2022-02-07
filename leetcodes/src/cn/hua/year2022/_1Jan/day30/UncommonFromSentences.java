package cn.hua.year2022._1Jan.day30;

import java.util.*;

// 884. 两句话中的不常见单词
// 简单题
public class UncommonFromSentences {

    public static void main(String[] args) {
        String[] strings = uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println(Arrays.toString(strings));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
//        ArrayList<String> strings = new ArrayList<>();
//        strings.addAll(Arrays.asList(str1));
//        strings.addAll(Arrays.asList(str2));
//        strings.sort((o1, o2) -> o1.compareTo(o2));
////        strings.sort(String::compareTo); // Abbreviation
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> strings = new ArrayList<String>();
        for (String s : str1) {
            if (hashMap.containsKey(s)) hashMap.put(s, hashMap.get(s) + 1);
            else hashMap.put(s, 1);
        }
        for (String s : str2) {
            if (hashMap.containsKey(s)) hashMap.put(s, hashMap.get(s) + 1);
            else hashMap.put(s, 1);
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if ((hashMap.get(key) == 1)) {
                strings.add(key);
            }
        }
        // 参数中的 `new String[0]` 是必要的
        // 否则会报错:[Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        return (String[]) strings.toArray(new String[0]);
    }

}
