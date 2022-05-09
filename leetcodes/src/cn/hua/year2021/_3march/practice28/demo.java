package cn.hua.year2021._3march.practice28;
// 173. 二叉搜索树迭代器
import cn.hua.data.TreeNode;

public class demo {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(20);
        TreeNode node3 = new TreeNode(9);
        TreeNode node2 = new TreeNode(15, node3, node4);
        TreeNode node1 = new TreeNode(3);
        TreeNode root = new TreeNode(7, node1, node2);

        BSTIterator bSTIterator = new BSTIterator(root);

        bSTIterator.next();    // 返回 3
        bSTIterator.next();    // 返回 7
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 9
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 15
        bSTIterator.hasNext(); // 返回 True
        bSTIterator.next();    // 返回 20
        bSTIterator.hasNext(); // 返回 False

    }

}
