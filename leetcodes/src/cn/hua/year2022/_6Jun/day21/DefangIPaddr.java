package cn.hua.year2022._6Jun.day21;

// 1108. IP 地址无效化
// 简单题
public class DefangIPaddr {

    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        int len = address.length();
        for (int i = 0; i < len; i++) {
            if (address.charAt(i) == '.') ans.append("[.]");
            else ans.append(address.charAt(i));
        }
        return ans.toString();

        // api 调用
//        return address.replace(".", "[.]");
    }

}
