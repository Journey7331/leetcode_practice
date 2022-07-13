package cn.hua.year2022._6Jun.day29;

import java.util.HashMap;
import java.util.Map;

// 535. TinyURL 的加密与解密
// 中等题
public class Codec {

    /**
     * tinyurl 格式： http://tinyurl.com/ + 6位随机码(4e9iAK)
     * 使用哈希表map,
     * --- 加密的时候生成随机 tinyurl, 若 tinyurl 在 map中不存在, 则以 tinyurl 作为 key, url 作为value;
     * --- 解密时, 通过 tinyurl 作为 key, 即可找到作为 value 的 url.
     */
    Map<String, String> map = new HashMap<>();
    static final String INDEX = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String PREFIX = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] chs = new char[6];   // 六位解析码
        while (true) {
            for (int i = 0; i < 6; i++) {
                // Math.random()
                // Returns: a pseudorandom double which is ( 0.0 <= return < 1.0 ).
                chs[i] = INDEX.charAt((int) (Math.random() * INDEX.length()));
            }
            String shortUrl = PREFIX + new String(chs);
            if (!map.containsKey(shortUrl)) {
                map.put(shortUrl, longUrl);
                return shortUrl;
            }
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
