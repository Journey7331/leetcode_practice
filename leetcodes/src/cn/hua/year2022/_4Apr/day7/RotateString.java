package cn.hua.year2022._4Apr.day7;

// 796. 旋转字符串
// 简单题
public class RotateString {

    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        return (s + s).contains(goal);

    }

}
