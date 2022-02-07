package cn.hua.year2021._3march.practice12;
// 331. 验证二叉树的前序序列化
import java.util.Scanner;

public class IsValidSerialization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean flag = method(str);
        System.out.println(flag);

    }

    private static boolean method(String preorder) {
        int leafs = 0;
        int node = 1;
        for (char c : preorder.toCharArray()) {
            if (node - leafs < leafs) return false;
            if (c == '#') leafs++;
            if (c == ',') node++;
        }
        node = node - leafs;
        return (leafs == (node + 1));
    }

}
